package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.booking.BookingDto;
import az.edu.itbrains.restoranfinalproject.models.Booking;
import az.edu.itbrains.restoranfinalproject.repositories.BannerRepository;
import az.edu.itbrains.restoranfinalproject.repositories.BookingRepository;
import az.edu.itbrains.restoranfinalproject.services.BookingService;
import az.edu.itbrains.restoranfinalproject.services.EmailService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final ModelMapper modelMapper;
    private final EmailService emailService;

    public BookingServiceImpl(BannerRepository bannerRepository, BookingRepository bookingRepository, ModelMapper modelMapper, EmailService emailService) {
        this.bookingRepository = bookingRepository;
        this.modelMapper = modelMapper;
        this.emailService = emailService;
    }

    @Override
    public boolean createBooking(BookingDto bookingDto) {
        LocalDateTime bookingTime = bookingDto.getDateTime();
        LocalDateTime startTime = bookingTime.minusMinutes(59);
        LocalDateTime endTime = bookingTime.minusMinutes(59);

        List<Booking> existing = bookingRepository.findAllByDateTimeBetween(startTime,endTime);
        if (!existing.isEmpty()){
            return false;
        }

        Booking booking = modelMapper.map(bookingDto, Booking.class);
        bookingRepository.save(booking);

        String subject = "Rezervasiya təsdiqi";
        String message = "Salam" + booking.getName() + ",\nRezervasiyanız qəbul edildi!\n" +
                "Tarix:" + booking.getDateTime() + "\nŞəxs sayı: " + booking.getNumberOfPeople();

        emailService.sendEmail(booking.getEmail(), subject, message);
        return true;
    }

    @Override
    public List<BookingDto> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(b-> modelMapper.map(b, BookingDto.class))
                .collect(Collectors.toList());
    }
}
