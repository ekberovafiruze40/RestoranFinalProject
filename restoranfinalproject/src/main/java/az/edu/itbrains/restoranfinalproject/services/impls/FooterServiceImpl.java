package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.footer.FooterDto;
import az.edu.itbrains.restoranfinalproject.models.Footer;
import az.edu.itbrains.restoranfinalproject.repositories.FooterRepository;
import az.edu.itbrains.restoranfinalproject.services.FooterService;
import org.springframework.stereotype.Service;

@Service
public class FooterServiceImpl implements FooterService {

    private final FooterRepository footerRepository;

    public FooterServiceImpl(FooterRepository footerRepository) {
        this.footerRepository = footerRepository;
    }

    @Override
    public FooterDto getFooterInfo() {
        Footer footer=footerRepository.findById(1L).orElseThrow();
        FooterDto footerDto = new FooterDto();
        footerDto.setId(footer.getId());
        footerDto.setCompany(footer.getCompany());
        footerDto.setContact(footer.getContact());
        footerDto.setOpening(footer.getOpening());
        footerDto.setAboutUsLink(footer.getAboutUsLink());
        footerDto.setContactUsLink(footer.getContactUsLink());
        footerDto.setReservationLink(footer.getReservationLink());
        footerDto.setPrivacyPolicyLink(footer.getPrivacyPolicyLink());
        footerDto.setTermsConditionLink(footer.getTermsConditionLink());
        footerDto.setAddress(footer.getAddress());
        footerDto.setPhone(footer.getPhone());
        footerDto.setEmail(footer.getEmail());
        footerDto.setFacebookIcon(footer.getFacebookIcon());
        footerDto.setTwitterIcon(footer.getTwitterIcon());
        footerDto.setYoutubeIcon(footer.getYoutubeIcon());
        footerDto.setLinkedinIcon(footer.getLinkedinIcon());
        footerDto.setWeekDay(footer.getWeekDay());
        footerDto.setSunDay(footer.getSunDay());
        footerDto.setWeekdayHours(footer.getWeekdayHours());
        footerDto.setSundayHours(footer.getSundayHours());

        return footerDto;
    }
}
