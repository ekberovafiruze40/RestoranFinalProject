package az.edu.itbrains.restoranfinalproject;

import az.edu.itbrains.restoranfinalproject.models.Role;
import az.edu.itbrains.restoranfinalproject.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        Stream.of("ROLE_ADMIN", "ROLE_EDITOR")
                .filter(name -> !roleRepository.existsByName(name))
                .forEach(name -> roleRepository.save(new Role(null, name, new ArrayList<>())));
    }
}
