package az.edu.itbrains.restoranfinalproject.services;

import az.edu.itbrains.restoranfinalproject.dtos.booking.BookingDto;
import az.edu.itbrains.restoranfinalproject.dtos.booking.BookingGetAllDto;

import java.util.List;

public interface BookingService {
    boolean createBooking(BookingDto bookingDto);
    List<BookingDto> getAllBookings();

    List<BookingGetAllDto> bookingGetAll();
}
