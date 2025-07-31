package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.category.*;
import az.edu.itbrains.restoranfinalproject.models.Category;
import az.edu.itbrains.restoranfinalproject.repositories.CategoryRepository;
import az.edu.itbrains.restoranfinalproject.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
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

    @Override
    public List<CategoryGetAllDto> categoryGetAll() {
        List<CategoryGetAllDto> categories=categoryRepository.findAll()
                .stream().map(category -> modelMapper.map(category, CategoryGetAllDto.class)).collect(Collectors.toList());
        return categories;
    }

    @Override
    public CategoryGetIdDto categoryGetIdDto(Long id) {
        Category findCategory=categoryRepository.findById(id).orElseThrow();
        CategoryGetIdDto result=modelMapper.map(findCategory, CategoryGetIdDto.class);
        return result;
    }

    @Override
    public void createCategory(CategoryCreateDto categoryCreateDto) {
        Category category=new Category();
        category.setName(categoryCreateDto.getName());
        category.setTag(categoryCreateDto.getTag());
        category.setIcon(categoryCreateDto.getIcon());
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(CategoryUpdateDto categoryUpdateDto, Long id) {
        Category category=categoryRepository.findById(id).orElseThrow();
        category.setName(categoryUpdateDto.getName());
        category.setTag(categoryUpdateDto.getTag());
        category.setIcon(categoryUpdateDto.getIcon());
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        Category findCategory=categoryRepository.findById(id).orElseThrow();
        categoryRepository.delete(findCategory);
    }
}
