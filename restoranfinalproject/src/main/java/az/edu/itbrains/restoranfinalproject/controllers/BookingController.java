package az.edu.itbrains.restoranfinalproject.controllers;

import az.edu.itbrains.restoranfinalproject.dtos.booking.BookingDto;
import az.edu.itbrains.restoranfinalproject.dtos.booking.BookingGetAllDto;
import az.edu.itbrains.restoranfinalproject.services.BookingService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }



    @PostMapping("/booking")
    public String createBooking(@Valid @ModelAttribute("booking") BookingDto bookingDto, BindingResult result, RedirectAttributes redirectAttributes){

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("formError", "Zəhmət olmasa, bütün sahələri düzgün doldurun.");
            return "redirect:/booking";
        }

        boolean success = bookingService.createBooking(bookingDto);
        if (!success){
            redirectAttributes.addFlashAttribute("error", "Bu saat üçün artıq rezervasiya mövcuddur.");
            return "redirect:/booking";
        }

        redirectAttributes.addFlashAttribute("message", "Rezervasiya uğurla tamamlandı.");
        return "redirect:/booking";
    }

    @GetMapping("/admin/booking")
    public String booking(Model model){
        List<BookingGetAllDto> bookingGetAllDto = bookingService.bookingGetAll();
        model.addAttribute("bookings", bookingGetAllDto);
        return "/dashboard/booking/index";
    }
}
