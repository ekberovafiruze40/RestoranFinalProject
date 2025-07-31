package az.edu.itbrains.restoranfinalproject.dtos.testimonial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestimonialDto {
    private Long id;
    private String icon;
    private String description;
    private String imageUrl;
    private String clientName;
    private String profession;
}
