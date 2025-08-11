package az.edu.itbrains.restoranfinalproject.dtos.booking;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @DateTimeFormat(pattern = "MM/dd/yyyy hh:mm a")
    private LocalDateTime dateTime;

    private int numberOfPeople;
    private String specialRequest;
}
