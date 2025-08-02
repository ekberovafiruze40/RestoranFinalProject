package az.edu.itbrains.restoranfinalproject.services;

import az.edu.itbrains.restoranfinalproject.dtos.menuItem.*;

import java.util.List;

public interface MenuItemService {
    List<MenuItemDto> getAllMenuItems();

    List<MenuGetAllDto> menuGetAll();

    MenuGetIdDto menuGetIdDto(Long id);

    void createMenu(MenuCreateDto menuCreateDto);
    void updateMenu(MenuUpdateDto menuUpdateDto, Long id);
    void deleteMenu(Long id);
}
