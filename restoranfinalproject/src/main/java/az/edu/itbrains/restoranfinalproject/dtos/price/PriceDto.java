package az.edu.itbrains.restoranfinalproject.dtos.price;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDto {
    private Long id;
    private Double amount;
    private String currency;
}
