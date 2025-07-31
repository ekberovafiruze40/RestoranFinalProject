package az.edu.itbrains.restoranfinalproject.dtos.ourTeam;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamGetIdDto {
    private Long id;
    private String fullName;
    private String imageUrl;
    private String designation;
    private String facebookIcon;
    private String twitterIcon;
    private String instagramIcon;
}
