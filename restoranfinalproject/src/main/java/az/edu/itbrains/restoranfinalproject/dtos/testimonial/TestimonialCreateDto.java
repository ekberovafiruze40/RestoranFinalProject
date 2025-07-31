package az.edu.itbrains.restoranfinalproject.dtos.testimonial;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestimonialCreateDto {
    private String icon;
    private String description;
    private String imageUrl;
    private String clientName;
    private String profession;
}
