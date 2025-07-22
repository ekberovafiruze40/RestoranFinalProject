package az.edu.itbrains.restoranfinalproject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contactInfo")
public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookTitle;
    private String generalTitle;
    private String technicalTitle;
    private String bookingMail;
    private String generalMail;
    private String technicalMail;
    private String iconUrl;
    @Column(length = 1000)
    private String iframeSrc;
}
