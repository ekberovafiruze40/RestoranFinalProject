package az.edu.itbrains.restoranfinalproject.dtos.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDto {
    private Long id;
    private String iconUrl;
    private String title;
    private String description;
}
