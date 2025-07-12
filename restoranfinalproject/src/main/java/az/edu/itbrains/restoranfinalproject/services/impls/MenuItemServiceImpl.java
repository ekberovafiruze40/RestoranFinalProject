package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.category.CategoryDto;
import az.edu.itbrains.restoranfinalproject.dtos.menuItem.MenuItemDto;
import az.edu.itbrains.restoranfinalproject.dtos.price.PriceDto;
import az.edu.itbrains.restoranfinalproject.models.MenuItem;
import az.edu.itbrains.restoranfinalproject.repositories.CategoryRepository;
import az.edu.itbrains.restoranfinalproject.repositories.MenuItemRepository;
import az.edu.itbrains.restoranfinalproject.repositories.PriceRepository;
import az.edu.itbrains.restoranfinalproject.services.MenuItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository, CategoryRepository categoryRepository, PriceRepository priceRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public List<MenuItemDto> getAllMenuItems() {
        return menuItemRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private MenuItemDto convertToDto(MenuItem menuItem){
        MenuItemDto menuItemDto = new MenuItemDto();
        menuItemDto.setId(menuItem.getId());
        menuItemDto.setName(menuItem.getName());
        menuItemDto.setDescription(menuItem.getDescription());
        menuItemDto.setImageUrl(menuItem.getImageUrl());

        // CategoryDto
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(menuItem.getCategory().getId());
        categoryDto.setName(menuItem.getCategory().getName());
        categoryDto.setTag(menuItem.getCategory().getTag());
        categoryDto.setIcon(menuItem.getCategory().getIcon());
        menuItemDto.setCategory(categoryDto);

        // PriceDto
        PriceDto priceDto = new PriceDto();
        priceDto.setId(menuItem.getPrice().getId());
        priceDto.setAmount(menuItem.getPrice().getAmount());
        priceDto.setCurrency(menuItem.getPrice().getCurrency());
        menuItemDto.setPrice(priceDto);

        return menuItemDto;
    }

}
