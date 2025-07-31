package az.edu.itbrains.restoranfinalproject.controllers.dashboard;

import az.edu.itbrains.restoranfinalproject.dtos.category.CategoryCreateDto;
import az.edu.itbrains.restoranfinalproject.dtos.category.CategoryGetAllDto;
import az.edu.itbrains.restoranfinalproject.dtos.category.CategoryGetIdDto;
import az.edu.itbrains.restoranfinalproject.dtos.category.CategoryUpdateDto;
import az.edu.itbrains.restoranfinalproject.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/admin/category")
    public String category(Model model){
        List<CategoryGetAllDto> result = categoryService.categoryGetAll();
        model.addAttribute("categories", result);
        return "/dashboard/category/index";
    }

    @GetMapping("/admin/category/create")
    public String categoryCreate(Model model){
        return "/dashboard/category/create";
    }

    @PostMapping("/admin/category/create")
    public String createCategory(@ModelAttribute("category")CategoryCreateDto categoryCreateDto){
        categoryService.createCategory(categoryCreateDto);
        return "redirect:/admin/category";
    }

    @GetMapping("/admin/category/update/{id}")
    public String categoryUpdate(@PathVariable Long id, Model model){
        CategoryGetIdDto categoryGetIdDto=categoryService.categoryGetIdDto(id);
        model.addAttribute("category", categoryGetIdDto);
        return "/dashboard/category/update";
    }

    @PostMapping("/admin/category/update/{id}")
    public String categoryUpdate(@PathVariable Long id, @ModelAttribute("category")CategoryUpdateDto categoryUpdateDto){
        categoryService.updateCategory(categoryUpdateDto, id);
        return "redirect:/admin/category";
    }

    @GetMapping("/admin/category/delete/{id}")
    public String deleteCategory(@PathVariable Long id){
        return "/dashboard/category/delete";
    }

    @PostMapping("/admin/category/delete/{id}")
    public String removeCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return "redirect:/admin/category";
    }

}
