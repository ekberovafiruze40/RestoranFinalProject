package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.category.CategoryDto;
import az.edu.itbrains.restoranfinalproject.dtos.menuItem.*;
import az.edu.itbrains.restoranfinalproject.dtos.price.PriceDto;
import az.edu.itbrains.restoranfinalproject.models.Category;
import az.edu.itbrains.restoranfinalproject.models.MenuItem;
import az.edu.itbrains.restoranfinalproject.models.Price;
import az.edu.itbrains.restoranfinalproject.repositories.CategoryRepository;
import az.edu.itbrains.restoranfinalproject.repositories.MenuItemRepository;
import az.edu.itbrains.restoranfinalproject.repositories.PriceRepository;
import az.edu.itbrains.restoranfinalproject.services.MenuItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final CategoryRepository categoryRepository;
    private final PriceRepository priceRepository;
    private final ModelMapper modelMapper;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository, CategoryRepository categoryRepository, PriceRepository priceRepository, ModelMapper modelMapper) {
        this.menuItemRepository = menuItemRepository;
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MenuItemDto> getAllMenuItems() {
        return menuItemRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MenuGetAllDto> menuGetAll() {
        List<MenuGetAllDto> menus=menuItemRepository.findAll()
                .stream().map(menuItem -> modelMapper.map(menuItem, MenuGetAllDto.class)).collect(Collectors.toList());
        return menus;
    }

    @Override
    public MenuGetIdDto menuGetIdDto(Long id) {
        MenuItem menuItem = menuItemRepository.findById(id).orElseThrow(()-> new RuntimeException("Menu tapılmadı: " + id));

        MenuGetIdDto dto = new MenuGetIdDto();
        dto.setId(menuItem.getId());
        dto.setName(menuItem.getName());
        dto.setDescription(menuItem.getDescription());
        dto.setImageUrl(menuItem.getImageUrl());

        if (menuItem.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(menuItem.getCategory().getId());
            categoryDto.setName(menuItem.getCategory().getName());
            categoryDto.setTag(menuItem.getCategory().getTag());
            categoryDto.setIcon(menuItem.getCategory().getIcon());
            dto.setCategory(categoryDto);
        }

        if (menuItem.getPrice() != null) {
            PriceDto priceDto = new PriceDto();
            priceDto.setId(menuItem.getPrice().getId());
            priceDto.setAmount(menuItem.getPrice().getAmount());
            priceDto.setCurrency(menuItem.getPrice().getCurrency());
            dto.setPrice(priceDto);
        }

        return dto;
    }

    @Override
    public void createMenu(MenuCreateDto menuCreateDto) {
        MenuItem menuItem = new MenuItem();
        menuItem.setName(menuCreateDto.getName());
        menuItem.setDescription(menuCreateDto.getDescription());
        menuItem.setImageUrl(menuCreateDto.getImageUrl());

        if (menuCreateDto.getCategory() != null && menuCreateDto.getCategory().getId() != null){
            Category category = categoryRepository.findById(menuCreateDto.getCategory().getId())
                    .orElseThrow(()-> new RuntimeException("Kateqoriya tapılmadı: " + menuCreateDto.getCategory().getId()));
            menuItem.setCategory(category);
        }

        if (menuCreateDto.getPrice() != null && menuCreateDto.getPrice().getId() != null){
            Price price = priceRepository.findById(menuCreateDto.getPrice().getId())
                    .orElseThrow(()-> new RuntimeException("Qiymət tapılmadı: " + menuCreateDto.getPrice().getId()));
            menuItem.setPrice(price);
        }
        menuItemRepository.save(menuItem);
    }

    @Override
    public void updateMenu(MenuUpdateDto menuUpdateDto, Long id) {
        MenuItem menuItem = menuItemRepository.findById(id).orElseThrow(()-> new RuntimeException("Menu tapılmadı: " + id));

        menuItem.setName(menuUpdateDto.getName());
        menuItem.setDescription(menuUpdateDto.getDescription());
        menuItem.setImageUrl(menuUpdateDto.getImageUrl());

        if (menuUpdateDto.getCategory() != null && menuUpdateDto.getCategory().getId() != null){
            Category category = categoryRepository.findById(menuUpdateDto.getCategory().getId())
                    .orElseThrow(()-> new RuntimeException("Kateqoriya tapılmadı: " + menuUpdateDto.getCategory().getId()));
            menuItem.setCategory(category);
        }

        if (menuUpdateDto.getPrice() != null && menuUpdateDto.getPrice().getId() != null){
            Price price = priceRepository.findById(menuUpdateDto.getPrice().getId())
                    .orElseThrow(()-> new RuntimeException("Qiymət tapılmadı: " + menuUpdateDto.getPrice().getId()));
            menuItem.setPrice(price);
        }
        menuItemRepository.save(menuItem);
    }

    @Override
    public void deleteMenu(Long id) {
        MenuItem menuItem = menuItemRepository.findById(id).orElseThrow(()-> new RuntimeException("Silinəcək menyu tapılmadı: " + id));
        menuItemRepository.delete(menuItem);
    }

    private MenuItemDto convertToDto(MenuItem menuItem){
        MenuItemDto menuItemDto = new MenuItemDto();
        menuItemDto.setId(menuItem.getId());
        menuItemDto.setName(menuItem.getName());
        menuItemDto.setDescription(menuItem.getDescription());
        menuItemDto.setImageUrl(menuItem.getImageUrl());

        // CategoryDto
       if (menuItem.getCategory() != null) {
           CategoryDto categoryDto = new CategoryDto();
           categoryDto.setId(menuItem.getCategory().getId());
           categoryDto.setName(menuItem.getCategory().getName());
           categoryDto.setTag(menuItem.getCategory().getTag());
           categoryDto.setIcon(menuItem.getCategory().getIcon());
           menuItemDto.setCategory(categoryDto);
       }
        // PriceDto
        if (menuItem.getPrice() != null) {
            PriceDto priceDto = new PriceDto();
            priceDto.setId(menuItem.getPrice().getId());
            priceDto.setAmount(menuItem.getPrice().getAmount());
            priceDto.setCurrency(menuItem.getPrice().getCurrency());
            menuItemDto.setPrice(priceDto);
        }
        return menuItemDto;
    }

}
