package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.contact.ContactInfoDto;
import az.edu.itbrains.restoranfinalproject.models.ContactInfo;
import az.edu.itbrains.restoranfinalproject.repositories.ContactInfoRepository;
import az.edu.itbrains.restoranfinalproject.services.ContactInfoService;
import org.springframework.stereotype.Service;

@Service
public class ContactInfoServiceImpl implements ContactInfoService {

    private final ContactInfoRepository contactInfoRepository;

    public ContactInfoServiceImpl(ContactInfoRepository contactInfoRepository) {
        this.contactInfoRepository = contactInfoRepository;
    }

    @Override
    public ContactInfoDto getContactInfo() {
        ContactInfo contactInfo = contactInfoRepository.findById(1L).orElseThrow();
        ContactInfoDto contactInfoDto=new ContactInfoDto();
        contactInfoDto.setId(contactInfo.getId());
        contactInfoDto.setBookingMail(contactInfo.getBookingMail());
        contactInfoDto.setGeneralMail(contactInfo.getGeneralMail());
        contactInfoDto.setTechnicalMail(contactInfo.getTechnicalMail());
        contactInfoDto.setIframeSrc(contactInfo.getIframeSrc());
        contactInfoDto.setIconUrl(contactInfo.getIconUrl());
        contactInfoDto.setBookTitle(contactInfo.getBookTitle());
        contactInfoDto.setGeneralTitle(contactInfo.getGeneralTitle());
        contactInfoDto.setTechnicalTitle(contactInfo.getTechnicalTitle());

        return contactInfoDto;
    }
}
