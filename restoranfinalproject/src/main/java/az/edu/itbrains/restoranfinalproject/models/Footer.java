package az.edu.itbrains.restoranfinalproject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "footer")
public class Footer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // company links
    private String aboutUsLink;
    private String contactUsLink;
    private String reservationLink;
    private String privacyPolicyLink;
    private String termsConditionLink;

    // contact info
    private String address;
    private String phone;
    private String email;

    // social media url
    private String twitterIcon;
    private String facebookIcon;
    private String youtubeIcon;
    private String linkedinIcon;

    // opening hours
    private String weekdayHours;
    private String sundaysHours;

    // newsletter
    private String newsletterText;



}
