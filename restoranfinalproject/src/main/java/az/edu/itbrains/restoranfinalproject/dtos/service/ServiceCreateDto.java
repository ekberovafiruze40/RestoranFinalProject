package az.edu.itbrains.restoranfinalproject.dtos.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceCreateDto {
    private String icon;
    private String title;
    private String description;

}
