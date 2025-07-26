package az.edu.itbrains.restoranfinalproject.dtos.partner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerDto {
    private Long id;
    private String title;
    private String photoUrl;
}
