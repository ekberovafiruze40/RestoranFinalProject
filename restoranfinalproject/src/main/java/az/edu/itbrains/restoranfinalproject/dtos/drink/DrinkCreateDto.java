package az.edu.itbrains.restoranfinalproject.dtos.drink;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DrinkCreateDto {
    private String name;
    private String description;
    private String imageUrl;
    private Double price;
}
