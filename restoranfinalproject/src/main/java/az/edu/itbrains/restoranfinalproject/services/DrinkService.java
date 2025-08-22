package az.edu.itbrains.restoranfinalproject.services;

import az.edu.itbrains.restoranfinalproject.dtos.drink.*;

import java.util.List;

public interface DrinkService {
    List<DrinkDto> getAllDrinks();
    List<DrinkDto> getDrinksByName(String name);

    List<DrinkGetAllDto> drinkGetAll();

    DrinkGetIdDto drinkGetIdDto(Long id);

    void createDrink(DrinkCreateDto drinkCreateDto);
    void updateDrink(DrinkUpdateDto drinkUpdateDto, Long id);
    void deleteDrink(Long id);
}
