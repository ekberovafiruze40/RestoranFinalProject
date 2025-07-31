package az.edu.itbrains.restoranfinalproject.dtos.gallery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GalleryGetIdDto {
    private Long id;
    private String imageUrl;
}
