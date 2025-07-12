package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.price.PriceDto;
import az.edu.itbrains.restoranfinalproject.repositories.PriceRepository;
import az.edu.itbrains.restoranfinalproject.services.PriceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
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
}
