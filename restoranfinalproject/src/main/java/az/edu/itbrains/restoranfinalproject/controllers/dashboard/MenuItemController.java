package az.edu.itbrains.restoranfinalproject.controllers.dashboard;

import az.edu.itbrains.restoranfinalproject.dtos.category.CategoryDto;
import az.edu.itbrains.restoranfinalproject.dtos.menuItem.MenuCreateDto;
import az.edu.itbrains.restoranfinalproject.dtos.menuItem.MenuGetAllDto;
import az.edu.itbrains.restoranfinalproject.dtos.menuItem.MenuGetIdDto;
import az.edu.itbrains.restoranfinalproject.dtos.menuItem.MenuUpdateDto;
import az.edu.itbrains.restoranfinalproject.dtos.price.PriceDto;
import az.edu.itbrains.restoranfinalproject.services.CategoryService;
import az.edu.itbrains.restoranfinalproject.services.MenuItemService;
import az.edu.itbrains.restoranfinalproject.services.PriceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MenuItemController {

    private final MenuItemService menuItemService;
    private final CategoryService categoryService;
    private final PriceService priceService;

    public MenuItemController(MenuItemService menuItemService, CategoryService categoryService, PriceService priceService) {
        this.menuItemService = menuItemService;
        this.categoryService = categoryService;
        this.priceService = priceService;
    }

    @GetMapping("/admin/menu")
    public String menu(Model model){
        List<MenuGetAllDto> menuItems=menuItemService.menuGetAll();
        model.addAttribute("menus", menuItems);
        return "/dashboard/menu/index";
    }

    @GetMapping("/admin/menu/create")
    public String menuCreate(Model model){
        List<CategoryDto> categories = categoryService.getAllCategories();
        List<PriceDto> prices = priceService.getAllPrices();

        model.addAttribute("categories", categories);
        model.addAttribute("prices", prices);
        return "/dashboard/menu/create";
    }

    @PostMapping("/admin/menu/create")
    public String createMenu(@ModelAttribute("menu")MenuCreateDto menuCreateDto){
        menuItemService.createMenu(menuCreateDto);
        return "redirect:/admin/menu";
    }

    @GetMapping("/admin/menu/update/{id}")
    public String menuUpdate(@PathVariable Long id, Model model){
        MenuGetIdDto menuGetIdDto = menuItemService.menuGetIdDto(id);
        model.addAttribute("menu", menuGetIdDto);

        List<CategoryDto> categories = categoryService.getAllCategories();
        List<PriceDto> prices = priceService.getAllPrices();

        model.addAttribute("categories", categories);
        model.addAttribute("prices", prices);

        return "/dashboard/menu/update";
    }

    @PostMapping("/admin/menu/update/{id}")
    public String updateMenu(@PathVariable Long id, @ModelAttribute("menu")MenuUpdateDto menuUpdateDto){
        menuItemService.updateMenu(menuUpdateDto, id);
        return "redirect:/admin/menu";
    }

    @GetMapping("/admin/menu/delete/{id}")
    public String deleteMenu(@PathVariable Long id){
        return "/dashboard/menu/delete";
    }

    @PostMapping("/admin/menu/delete/{id}")
    public String removeMenu(@PathVariable Long id){
        menuItemService.deleteMenu(id);
        return "redirect:/admin/menu";
    }

}
