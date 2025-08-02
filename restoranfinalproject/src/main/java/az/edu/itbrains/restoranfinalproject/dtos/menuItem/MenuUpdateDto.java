package az.edu.itbrains.restoranfinalproject.dtos.menuItem;

import az.edu.itbrains.restoranfinalproject.dtos.category.CategoryDto;
import az.edu.itbrains.restoranfinalproject.dtos.price.PriceDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuUpdateDto {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;

    private CategoryDto category;
    private PriceDto price;
}
