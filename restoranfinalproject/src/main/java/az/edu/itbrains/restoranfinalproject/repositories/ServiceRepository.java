package az.edu.itbrains.restoranfinalproject.repositories;

import az.edu.itbrains.restoranfinalproject.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
