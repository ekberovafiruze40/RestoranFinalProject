package az.edu.itbrains.restoranfinalproject.services;

import az.edu.itbrains.restoranfinalproject.dtos.testimonial.TestimonialDto;

import java.util.List;

public interface TestimonialService {
    List<TestimonialDto> getAllTestimonials();
}
