package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.service.*;
import az.edu.itbrains.restoranfinalproject.models.ServiceEntity;
import az.edu.itbrains.restoranfinalproject.repositories.ServiceRepository;
import az.edu.itbrains.restoranfinalproject.services.ServiceService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;
    private final ModelMapper modelMapper;

    public ServiceServiceImpl(ServiceRepository serviceRepository, ModelMapper modelMapper) {
        this.serviceRepository = serviceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ServiceDto> getAllServices() {

        List<ServiceDto> serviceDtos = serviceRepository.findAll().stream()
                .map(service -> {
                    ServiceDto serviceDto = new ServiceDto();
                    serviceDto.setId(service.getId());
                    serviceDto.setIcon(service.getIcon());
                    serviceDto.setTitle(service.getTitle());
                    serviceDto.setDescription(service.getDescription());
                    return serviceDto;
                }).collect(Collectors.toList());

        return serviceDtos;
    }

    @Override
    public List<ServiceGetAllDto> servicesGetAll() {
        List<ServiceGetAllDto> services=serviceRepository.findAll()
                .stream().map(service-> modelMapper.map(service, ServiceGetAllDto.class)).collect(Collectors.toList());
        return services;
    }

    @Override
    public ServiceGetIdDto servicesGetId(Long id) {
        ServiceEntity findService=serviceRepository.findById(id).orElseThrow();
        ServiceGetIdDto result = modelMapper.map(findService, ServiceGetIdDto.class);
        return result;
    }

    @Override
    public void createService(ServiceCreateDto serviceCreateDto) {
        ServiceEntity service = new ServiceEntity();
        service.setTitle(serviceCreateDto.getTitle());
        service.setDescription(serviceCreateDto.getDescription());
        service.setIcon(serviceCreateDto.getIcon());
        serviceRepository.save(service);
    }

    @Override
    public void updateService(ServiceUpdateDto serviceUpdateDto, Long id) {
       ServiceEntity  service=serviceRepository.findById(id).orElseThrow();
        service.setTitle(serviceUpdateDto.getTitle());
        service.setDescription(serviceUpdateDto.getDescription());
        service.setIcon(serviceUpdateDto.getIcon());
        serviceRepository.save(service);
    }

    @Override
    public void deleteService(Long id) {
       ServiceEntity findService=serviceRepository.findById(id).orElseThrow();
       serviceRepository.delete(findService);
    }
}
