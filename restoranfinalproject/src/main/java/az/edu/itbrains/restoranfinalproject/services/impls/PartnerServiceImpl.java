package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.partner.*;
import az.edu.itbrains.restoranfinalproject.models.Partner;
import az.edu.itbrains.restoranfinalproject.repositories.PartnerRepository;
import az.edu.itbrains.restoranfinalproject.services.PartnerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartnerServiceImpl implements PartnerService {

    private final PartnerRepository partnerRepository;
    private final ModelMapper modelMapper;

    public PartnerServiceImpl(PartnerRepository partnerRepository, ModelMapper modelMapper) {
        this.partnerRepository = partnerRepository;
        this.modelMapper = modelMapper;
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

    @Override
    public List<PartnerGetAllDto> partnerGetAll() {
        List<PartnerGetAllDto> partners=partnerRepository.findAll()
                .stream().map(partner -> modelMapper.map(partner, PartnerGetAllDto.class)).collect(Collectors.toList());
        return partners;
    }

    @Override
    public PartnerGetIdDto partnerGetId(Long id) {
        Partner findPartner = partnerRepository.findById(id).orElseThrow();
        PartnerGetIdDto result=modelMapper.map(findPartner, PartnerGetIdDto.class);
        return result;
    }

    @Override
    public void createPartner(PartnerCreateDto partnerCreateDto) {
        Partner partner = new Partner();
        partner.setTitle(partnerCreateDto.getTitle());
        partner.setPhotoUrl(partnerCreateDto.getPhotoUrl());
        partnerRepository.save(partner);
    }

    @Override
    public void updatePartner(PartnerUpdateDto partnerUpdateDto, Long id) {
        Partner partner = partnerRepository.findById(id).orElseThrow();
        partner.setTitle(partnerUpdateDto.getTitle());
        partner.setPhotoUrl(partnerUpdateDto.getPhotoUrl());
        partnerRepository.save(partner);
    }

    @Override
    public void deletePartner(Long id) {
        Partner findPartner = partnerRepository.findById(id).orElseThrow();
        partnerRepository.delete(findPartner);
    }
}
