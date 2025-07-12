package az.edu.itbrains.restoranfinalproject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ourTeams")
public class OurTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String imageUrl;
    private String designation;
    private String facebookIcon;
    private String twitterIcon;
    private String instagramIcon;
}
