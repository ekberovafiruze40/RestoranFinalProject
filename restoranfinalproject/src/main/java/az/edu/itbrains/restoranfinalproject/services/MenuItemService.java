package az.edu.itbrains.restoranfinalproject.services;

import az.edu.itbrains.restoranfinalproject.dtos.menuItem.MenuItemDto;

import java.util.List;

public interface MenuItemService {
    List<MenuItemDto> getAllMenuItems();
}
