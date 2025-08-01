package az.edu.itbrains.restoranfinalproject.dtos.banner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannerDto {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
}
