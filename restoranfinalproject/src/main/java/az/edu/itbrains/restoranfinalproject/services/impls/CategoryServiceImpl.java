package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.category.CategoryDto;
import az.edu.itbrains.restoranfinalproject.repositories.CategoryRepository;
import az.edu.itbrains.restoranfinalproject.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> categoryDtos = categoryRepository.findAll().stream()
                .map(category -> {
                    CategoryDto categoryDto = new CategoryDto();
                    categoryDto.setId(category.getId());
                    categoryDto.setName(category.getName());
                    categoryDto.setTag(category.getTag());
                    categoryDto.setIcon(category.getIcon());
                    return categoryDto;
                }).collect(Collectors.toList());
        return categoryDtos;
    }
}
