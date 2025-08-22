package az.edu.itbrains.restoranfinalproject.repositories;

import az.edu.itbrains.restoranfinalproject.models.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
    List<Drink> findByNameContainingIgnoreCase(String name);
}
