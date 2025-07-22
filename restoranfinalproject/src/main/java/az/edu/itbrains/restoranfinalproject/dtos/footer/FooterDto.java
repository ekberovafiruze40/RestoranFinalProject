package az.edu.itbrains.restoranfinalproject.dtos.footer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FooterDto {
    private Long id;
    private String company;
    private String contact;
    private String opening;

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
    private String weekDay;
    private String sunDay;
    private String weekdayHours;
    private String sundayHours;

}
