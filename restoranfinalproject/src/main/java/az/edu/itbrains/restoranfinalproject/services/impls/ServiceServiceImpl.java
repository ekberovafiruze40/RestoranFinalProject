package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.service.ServiceDto;
import az.edu.itbrains.restoranfinalproject.repositories.ServiceRepository;
import az.edu.itbrains.restoranfinalproject.services.ServiceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<ServiceDto> getAllServices() {

        List<ServiceDto> serviceDtos = serviceRepository.findAll().stream()
                .map(service -> {
                    ServiceDto serviceDto = new ServiceDto();
                    serviceDto.setId(service.getId());
                    serviceDto.setIconUrl(service.getIconUrl());
                    serviceDto.setTitle(service.getTitle());
                    serviceDto.setDescription(service.getDescription());
                    return serviceDto;
                }).collect(Collectors.toList());

        return serviceDtos;
    }
}
