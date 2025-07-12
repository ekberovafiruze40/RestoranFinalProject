package az.edu.itbrains.restoranfinalproject.repositories;

import az.edu.itbrains.restoranfinalproject.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
