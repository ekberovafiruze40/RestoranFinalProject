package az.edu.itbrains.restoranfinalproject.dtos.price;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceUpdateDto {
    private Long id;
    private Double amount;
    private String currency;
}
