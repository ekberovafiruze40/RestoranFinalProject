package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.drink.*;
import az.edu.itbrains.restoranfinalproject.models.Drink;
import az.edu.itbrains.restoranfinalproject.repositories.DrinkRepository;
import az.edu.itbrains.restoranfinalproject.services.DrinkService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository drinkRepository;
    private final ModelMapper modelMapper;

    public DrinkServiceImpl(DrinkRepository drinkRepository, ModelMapper modelMapper) {
        this.drinkRepository = drinkRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DrinkDto> getAllDrinks() {
        List<DrinkDto> drinkDtos =drinkRepository.findAll().stream()
                .map(drink -> {
                    DrinkDto drinkDto = new DrinkDto();
                    drinkDto.setId(drink.getId());
                    drinkDto.setName(drink.getName());
                    drinkDto.setDescription(drink.getDescription());
                    drinkDto.setImageUrl(drink.getImageUrl());
                    drinkDto.setPrice(drink.getPrice());
                    return drinkDto;
                }).collect(Collectors.toList());
        return drinkDtos;
    }

    @Override
    public List<DrinkDto> getDrinksByName(String name) {
        return drinkRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(drink -> {
                    DrinkDto drinkDto = new DrinkDto();
                    drinkDto.setId(drink.getId());
                    drinkDto.setName(drink.getName());
                    drinkDto.setDescription(drink.getDescription());
                    drinkDto.setImageUrl(drink.getImageUrl());
                    drinkDto.setPrice(drink.getPrice());
                    return drinkDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<DrinkGetAllDto> drinkGetAll() {
        List<DrinkGetAllDto> drinks = drinkRepository.findAll()
                .stream().map(drink -> modelMapper.map(drink, DrinkGetAllDto.class)).collect(Collectors.toList());
        return drinks;
    }

    @Override
    public DrinkGetIdDto drinkGetIdDto(Long id) {
        Drink findDrink = drinkRepository.findById(id).orElseThrow();
        DrinkGetIdDto result = modelMapper.map(findDrink, DrinkGetIdDto.class);
        return result;
    }

    @Override
    public void createDrink(DrinkCreateDto drinkCreateDto) {
        Drink drink = new Drink();
        drink.setName(drinkCreateDto.getName());
        drink.setDescription(drinkCreateDto.getDescription());
        drink.setImageUrl(drinkCreateDto.getImageUrl());
        drink.setPrice(drinkCreateDto.getPrice());
        drinkRepository.save(drink);
    }

    @Override
    public void updateDrink(DrinkUpdateDto drinkUpdateDto, Long id) {
        Drink drink = drinkRepository.findById(id).orElseThrow();
        drink.setName(drinkUpdateDto.getName());
        drink.setDescription(drinkUpdateDto.getDescription());
        drink.setImageUrl(drinkUpdateDto.getImageUrl());
        drink.setPrice(drinkUpdateDto.getPrice());
        drinkRepository.save(drink);
    }

    @Override
    public void deleteDrink(Long id) {
        Drink findDrink = drinkRepository.findById(id).orElseThrow();
        drinkRepository.delete(findDrink);
    }
}
