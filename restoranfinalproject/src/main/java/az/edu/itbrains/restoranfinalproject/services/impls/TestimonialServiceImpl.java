package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.testimonial.TestimonialDto;
import az.edu.itbrains.restoranfinalproject.repositories.TestimonialRepository;
import az.edu.itbrains.restoranfinalproject.services.TestimonialService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestimonialServiceImpl implements TestimonialService {

    private final TestimonialRepository testimonialRepository;

    public TestimonialServiceImpl(TestimonialRepository testimonialRepository) {
        this.testimonialRepository = testimonialRepository;
    }

    @Override
    public List<TestimonialDto> getAllTestimonials() {
        List<TestimonialDto> testimonialDtos = testimonialRepository.findAll().stream()
                .map(testimonial -> {
                    TestimonialDto testimonialDto = new TestimonialDto();
                    testimonialDto.setId(testimonial.getId());
                    testimonialDto.setIconUrl(testimonial.getIconUrl());
                    testimonialDto.setDescription(testimonial.getDescription());
                    testimonialDto.setImageUrl(testimonial.getImageUrl());
                    testimonialDto.setClientName(testimonial.getClientName());
                    testimonialDto.setProfession(testimonial.getProfession());
                    return testimonialDto;
                }).collect(Collectors.toList());
        return testimonialDtos;
    }
}
