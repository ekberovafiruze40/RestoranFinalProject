package az.edu.itbrains.restoranfinalproject.dtos.drink;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DrinkDto {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;
}
