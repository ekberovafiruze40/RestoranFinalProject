package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.testimonial.*;
import az.edu.itbrains.restoranfinalproject.models.Testimonial;
import az.edu.itbrains.restoranfinalproject.repositories.TestimonialRepository;
import az.edu.itbrains.restoranfinalproject.services.TestimonialService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestimonialServiceImpl implements TestimonialService {

    private final TestimonialRepository testimonialRepository;
    private final ModelMapper modelMapper;

    public TestimonialServiceImpl(TestimonialRepository testimonialRepository, ModelMapper modelMapper) {
        this.testimonialRepository = testimonialRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TestimonialDto> getAllTestimonials() {
        List<TestimonialDto> testimonialDtos = testimonialRepository.findAll().stream()
                .map(testimonial -> {
                    TestimonialDto testimonialDto = new TestimonialDto();
                    testimonialDto.setId(testimonial.getId());
                    testimonialDto.setIcon(testimonial.getIcon());
                    testimonialDto.setDescription(testimonial.getDescription());
                    testimonialDto.setImageUrl(testimonial.getImageUrl());
                    testimonialDto.setClientName(testimonial.getClientName());
                    testimonialDto.setProfession(testimonial.getProfession());
                    return testimonialDto;
                }).collect(Collectors.toList());
        return testimonialDtos;
    }

    @Override
    public List<TestimonialGetAllDto> testimonialsGetAll() {
        List<TestimonialGetAllDto> testimonials=testimonialRepository.findAll()
                .stream().map(testimonial -> modelMapper.map(testimonial, TestimonialGetAllDto.class)) .collect(Collectors.toList());
        return testimonials;
    }

    @Override
    public TestimonialGetIdDto testimonialsGetId(Long id) {
        Testimonial findTestimonial = testimonialRepository.findById(id).orElseThrow();
        TestimonialGetIdDto result = modelMapper.map(findTestimonial, TestimonialGetIdDto.class);
        return result;
    }

    @Override
    public void createTestimonial(TestimonialCreateDto testimonialCreateDto) {
        Testimonial testimonial = new Testimonial();
        testimonial.setIcon(testimonialCreateDto.getIcon());
        testimonial.setDescription(testimonialCreateDto.getDescription());
        testimonial.setImageUrl(testimonialCreateDto.getImageUrl());
        testimonial.setClientName(testimonialCreateDto.getClientName());
        testimonial.setProfession(testimonialCreateDto.getProfession());
        testimonialRepository.save(testimonial);
    }

    @Override
    public void updateTestimonial(TestimonialUpdateDto testimonialUpdateDto, Long id) {
        Testimonial testimonial = testimonialRepository.findById(id).orElseThrow();
        testimonial.setIcon(testimonialUpdateDto.getIcon());
        testimonial.setDescription(testimonialUpdateDto.getDescription());
        testimonial.setImageUrl(testimonialUpdateDto.getImageUrl());
        testimonial.setClientName(testimonialUpdateDto.getClientName());
        testimonial.setProfession(testimonialUpdateDto.getProfession());
        testimonialRepository.save(testimonial);
    }

    @Override
    public void deleteTestimonial(Long id) {
        Testimonial findTestimonial = testimonialRepository.findById(id).orElseThrow();
        testimonialRepository.delete(findTestimonial);
    }
}
