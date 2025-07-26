package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.partner.PartnerDto;
import az.edu.itbrains.restoranfinalproject.repositories.PartnerRepository;
import az.edu.itbrains.restoranfinalproject.services.PartnerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartnerServiceImpl implements PartnerService {

    private final PartnerRepository partnerRepository;

    public PartnerServiceImpl(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @Override
    public List<PartnerDto> getAllPartners() {
        List<PartnerDto> partners = partnerRepository.findAll().stream()
                .map(partner -> {
                    PartnerDto partnerDto = new PartnerDto();
                    partnerDto.setId(partner.getId());
                    partnerDto.setTitle(partner.getTitle());
                    partnerDto.setPhotoUrl(partner.getPhotoUrl());
                    return partnerDto;
                }).collect(Collectors.toList());
        return partners;
    }
}
