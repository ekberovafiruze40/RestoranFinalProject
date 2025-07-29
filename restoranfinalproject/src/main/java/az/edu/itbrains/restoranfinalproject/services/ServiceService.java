package az.edu.itbrains.restoranfinalproject.services;

import az.edu.itbrains.restoranfinalproject.dtos.service.*;

import java.util.List;

public interface ServiceService {
    List<ServiceDto> getAllServices();

    List<ServiceGetAllDto> servicesGetAll();

    ServiceGetIdDto servicesGetId(Long id);

    void createService(ServiceCreateDto serviceCreateDto);
    void updateService(ServiceUpdateDto serviceUpdateDto, Long id);
    void deleteService(Long id);

}
