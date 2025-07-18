package az.edu.itbrains.restoranfinalproject.dtos.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private Long id;
    private String name;
    private String email;

    @DateTimeFormat(pattern = "MM/dd/yyyy hh:mm a")
    private LocalDateTime dateTime;

    private int numberOfPeople;
    private String specialRequest;
}
