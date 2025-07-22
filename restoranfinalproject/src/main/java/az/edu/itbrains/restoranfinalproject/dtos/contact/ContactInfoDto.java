package az.edu.itbrains.restoranfinalproject.dtos.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactInfoDto {
    private Long id;
    private String bookTitle;
    private String generalTitle;
    private String technicalTitle;
    private String bookingMail;
    private String generalMail;
    private String technicalMail;
    private String iconUrl;
    private String iframeSrc;
}
