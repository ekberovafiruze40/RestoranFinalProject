package az.edu.itbrains.restoranfinalproject.dtos.ourTeam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OurTeamDto {
    private Long id;
    private String fullName;
    private String imageUrl;
    private String designation;
    private String facebookIcon;
    private String twitterIcon;
    private String instagramIcon;
}
