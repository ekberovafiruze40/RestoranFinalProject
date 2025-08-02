package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.price.*;
import az.edu.itbrains.restoranfinalproject.models.Price;
import az.edu.itbrains.restoranfinalproject.repositories.PriceRepository;
import az.edu.itbrains.restoranfinalproject.services.PriceService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;
    private final ModelMapper modelMapper;

    public PriceServiceImpl(PriceRepository priceRepository, ModelMapper modelMapper) {
        this.priceRepository = priceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PriceDto> getAllPrices() {
        List<PriceDto> priceDtos = priceRepository.findAll().stream()
                .map(price -> {
                    PriceDto priceDto = new PriceDto();
                    priceDto.setId(price.getId());
                    priceDto.setAmount(price.getAmount());
                    priceDto.setCurrency(price.getCurrency());
                    return priceDto;
                }).collect(Collectors.toList());
        return priceDtos;
    }

    @Override
    public List<PriceGetAllDto> priceGetAll() {
        List<PriceGetAllDto> prices=priceRepository.findAll()
                .stream().map(price -> modelMapper.map(price, PriceGetAllDto.class)).collect(Collectors.toList());
        return prices;
    }

    @Override
    public PriceGetIdDto priceGetIdDto(Long id) {
        Price findPrice=priceRepository.findById(id).orElseThrow();
        PriceGetIdDto result=modelMapper.map(findPrice, PriceGetIdDto.class);
        return result;
    }

    @Override
    public void createPrice(PriceCreateDto priceCreateDto) {
        Price price = new Price();
        price.setAmount(priceCreateDto.getAmount());
        price.setCurrency(priceCreateDto.getCurrency());
        priceRepository.save(price);
    }

    @Override
    public void updatePrice(PriceUpdateDto priceUpdateDto, Long id) {
        Price price = priceRepository.findById(id).orElseThrow();
        price.setAmount(priceUpdateDto.getAmount());
        price.setCurrency(priceUpdateDto.getCurrency());
        priceRepository.save(price);
    }

    @Override
    public void deletePrice(Long id) {
        Price findPrice=priceRepository.findById(id).orElseThrow();
        priceRepository.delete(findPrice);
    }
}
