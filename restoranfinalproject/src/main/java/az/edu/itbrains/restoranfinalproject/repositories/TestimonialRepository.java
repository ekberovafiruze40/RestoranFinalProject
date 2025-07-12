package az.edu.itbrains.restoranfinalproject.repositories;

import az.edu.itbrains.restoranfinalproject.models.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {
}
