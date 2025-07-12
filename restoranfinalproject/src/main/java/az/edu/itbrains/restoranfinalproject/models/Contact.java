package az.edu.itbrains.restoranfinalproject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookingMail;
    private String generalMail;
    private String technicalMail;

    private String name;
    private String email;
    private String subject;
    private String message;
    private String mapUrl;
}
