package az.edu.itbrains.restoranfinalproject.controllers.dashboard;

import az.edu.itbrains.restoranfinalproject.dtos.testimonial.TestimonialCreateDto;
import az.edu.itbrains.restoranfinalproject.dtos.testimonial.TestimonialGetAllDto;
import az.edu.itbrains.restoranfinalproject.dtos.testimonial.TestimonialGetIdDto;
import az.edu.itbrains.restoranfinalproject.dtos.testimonial.TestimonialUpdateDto;
import az.edu.itbrains.restoranfinalproject.services.TestimonialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TestimonialController {
    private final TestimonialService testimonialService;

    public TestimonialController(TestimonialService testimonialService) {
        this.testimonialService = testimonialService;
    }

    @GetMapping("/admin/testimonial")
    public String testimonial(Model model){
        List<TestimonialGetAllDto> result = testimonialService.testimonialsGetAll();
        model.addAttribute("testimonials", result);
        return "/dashboard/testimonial/index";
    }

    @GetMapping("/admin/testimonial/create")
    public String testimonialCreate(Model model){
        return "/dashboard/testimonial/create";
    }

    @PostMapping("/admin/testimonial/create")
    public String createTestimonial(@ModelAttribute("testimonial")TestimonialCreateDto testimonialCreateDto){
        testimonialService.createTestimonial(testimonialCreateDto);
        return "redirect:/admin/testimonial";
    }

    @GetMapping("/admin/testimonial/update/{id}")
    public String testimonialUpdate(@PathVariable Long id, Model model){
        TestimonialGetIdDto testimonialGetIdDto=testimonialService.testimonialsGetId(id);
        model.addAttribute("testimonial", testimonialGetIdDto);
        return "/dashboard/testimonial/update";
    }

    @PostMapping("/admin/testimonial/update/{id}")
    public String testimonialUpdate(@PathVariable Long id, @ModelAttribute("testimonial")TestimonialUpdateDto testimonial){
        testimonialService.updateTestimonial(testimonial, id);
        return "redirect:/admin/testimonial";
    }

    @GetMapping("/admin/testimonial/delete/{id}")
    public String deleteTestimonial(@PathVariable Long id){
        return "/dashboard/testimonial/delete";
    }

    @PostMapping("/admin/testimonial/delete/{id}")
    public String removeTestimonial(@PathVariable Long id){
        testimonialService.deleteTestimonial(id);
        return "redirect:/admin/testimonial";
    }
}
