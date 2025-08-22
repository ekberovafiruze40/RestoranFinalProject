package az.edu.itbrains.restoranfinalproject.dtos.booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingGetAllDto {
    private Long id;
    private String name;
    private String email;
    private String  dateTime;
    private int numberOfPeople;
    private String specialRequest;
}
