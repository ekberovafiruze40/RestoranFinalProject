package az.edu.itbrains.restoranfinalproject.services;

import az.edu.itbrains.restoranfinalproject.dtos.price.PriceDto;

import java.util.List;

public interface PriceService {
    List<PriceDto> getAllPrices();
}
