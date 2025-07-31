package az.edu.itbrains.restoranfinalproject.dtos.partner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartnerGetIdDto {
    private Long id;
    private String title;
    private String photoUrl;
}
