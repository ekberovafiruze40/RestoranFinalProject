package az.edu.itbrains.restoranfinalproject.controllers;

import az.edu.itbrains.restoranfinalproject.dtos.booking.BookingDto;
import az.edu.itbrains.restoranfinalproject.services.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }



    @PostMapping("/booking")
    public String createBooking(@ModelAttribute("booking") BookingDto bookingDto, RedirectAttributes redirectAttributes){
        boolean success = bookingService.createBooking(bookingDto);
        if (!success){
            redirectAttributes.addFlashAttribute("error", "Bu saat üçün artıq rezervasiya mövcuddur.");
            return "redirect:/booking";
        }

        redirectAttributes.addFlashAttribute("message", "Rezervasiya uğurla tamamlandı.");
        return "redirect:/booking";
    }
}
