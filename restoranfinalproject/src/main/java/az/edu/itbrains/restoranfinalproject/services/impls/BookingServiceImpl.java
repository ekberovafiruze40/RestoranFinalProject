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

        if (bookingTime == null) {
            throw new IllegalArgumentException("Rezervasiya vaxtı boş ola bilməz!");
        }

        // həmin saatın başlanğıcı və sonu
        LocalDateTime startTime = bookingTime.withMinute(0).withSecond(0).withNano(0);
        LocalDateTime endTime = startTime.plusHours(1);

        // bu 1 saat icinde rezervasiya var?
        List<Booking> existingBookings = bookingRepository.findAllByDateTimeBetween(startTime,endTime);

        if (existingBookings.size() >= 10){
            return false; // artiq bu sayda rezerv oldugu ucun icaze verilmir
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
