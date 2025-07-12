package az.edu.itbrains.restoranfinalproject.services;

import az.edu.itbrains.restoranfinalproject.dtos.service.ServiceDto;

import java.util.List;

public interface ServiceService {
    List<ServiceDto> getAllServices();
}
