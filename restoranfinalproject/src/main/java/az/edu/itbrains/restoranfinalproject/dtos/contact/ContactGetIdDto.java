package az.edu.itbrains.restoranfinalproject.dtos.contact;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactGetIdDto {
    private Long id;
    private String name;
    private String email;
    private String subject;
    private String message;
}
