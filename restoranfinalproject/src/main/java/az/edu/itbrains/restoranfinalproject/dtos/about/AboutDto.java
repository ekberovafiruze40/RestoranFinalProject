package az.edu.itbrains.restoranfinalproject.dtos.about;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AboutDto {
    private Long id;
    private String title;
    private String subTitle;
    private String icon;
    private String description;
    private int yearsOfExperience;
    private int popularCount;
}
