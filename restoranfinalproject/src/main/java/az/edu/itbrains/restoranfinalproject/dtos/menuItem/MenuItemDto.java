package az.edu.itbrains.restoranfinalproject.dtos.menuItem;

import az.edu.itbrains.restoranfinalproject.dtos.category.CategoryDto;
import az.edu.itbrains.restoranfinalproject.dtos.price.PriceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemDto {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;

    private CategoryDto category;
    private PriceDto price;
}
