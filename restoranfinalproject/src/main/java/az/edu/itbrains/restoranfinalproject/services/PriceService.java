package az.edu.itbrains.restoranfinalproject.services;

import az.edu.itbrains.restoranfinalproject.dtos.price.*;

import java.util.List;

public interface PriceService {
    List<PriceDto> getAllPrices();

    List<PriceGetAllDto> priceGetAll();

    PriceGetIdDto priceGetIdDto(Long id);

    void createPrice(PriceCreateDto priceCreateDto);
    void updatePrice(PriceUpdateDto priceUpdateDto, Long id);
    void deletePrice(Long id);
}
