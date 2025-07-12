package az.edu.itbrains.restoranfinalproject.dtos.gallery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GalleryImageDto {
    private Long id;
    private String imageUrl;
}
