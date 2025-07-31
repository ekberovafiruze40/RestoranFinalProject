package az.edu.itbrains.restoranfinalproject.services;

import az.edu.itbrains.restoranfinalproject.dtos.partner.*;

import java.util.List;

public interface PartnerService {
    List<PartnerDto> getAllPartners();

    List<PartnerGetAllDto> partnerGetAll();

    PartnerGetIdDto partnerGetId(Long id);

    void createPartner(PartnerCreateDto partnerCreateDto);
    void updatePartner(PartnerUpdateDto partnerUpdateDto, Long id);
    void deletePartner(Long id);
}
