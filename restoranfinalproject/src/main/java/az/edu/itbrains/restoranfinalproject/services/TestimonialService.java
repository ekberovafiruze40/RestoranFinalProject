package az.edu.itbrains.restoranfinalproject.services;

import az.edu.itbrains.restoranfinalproject.dtos.testimonial.*;

import java.util.List;

public interface TestimonialService {
    List<TestimonialDto> getAllTestimonials();

    List<TestimonialGetAllDto> testimonialsGetAll();

    TestimonialGetIdDto testimonialsGetId(Long id);

    void createTestimonial(TestimonialCreateDto testimonialCreateDto);
    void updateTestimonial(TestimonialUpdateDto testimonialUpdateDto, Long id);
    void deleteTestimonial(Long id);
}
