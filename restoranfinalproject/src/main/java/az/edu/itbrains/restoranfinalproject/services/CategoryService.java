package az.edu.itbrains.restoranfinalproject.services;

import az.edu.itbrains.restoranfinalproject.dtos.category.*;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();

    List<CategoryGetAllDto> categoryGetAll();

    CategoryGetIdDto categoryGetIdDto(Long id);

    void createCategory(CategoryCreateDto categoryCreateDto);
    void updateCategory(CategoryUpdateDto categoryUpdateDto, Long id);
    void deleteCategory(Long id);
}
