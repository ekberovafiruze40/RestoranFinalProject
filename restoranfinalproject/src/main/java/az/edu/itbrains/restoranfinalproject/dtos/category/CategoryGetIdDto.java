package az.edu.itbrains.restoranfinalproject.dtos.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryGetIdDto {
    private Long id;
    private String name;
    private String tag;
    private String icon;
}
