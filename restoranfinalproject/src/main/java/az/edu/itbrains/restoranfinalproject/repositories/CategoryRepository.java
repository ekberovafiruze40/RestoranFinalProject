package az.edu.itbrains.restoranfinalproject.repositories;

import az.edu.itbrains.restoranfinalproject.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
