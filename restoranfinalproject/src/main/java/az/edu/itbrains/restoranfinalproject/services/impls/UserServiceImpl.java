package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.auth.RegisterDto;
import az.edu.itbrains.restoranfinalproject.dtos.auth.UserDto;
import az.edu.itbrains.restoranfinalproject.models.Role;
import az.edu.itbrains.restoranfinalproject.models.User;
import az.edu.itbrains.restoranfinalproject.repositories.RoleRepository;
import az.edu.itbrains.restoranfinalproject.repositories.UserRepository;
import az.edu.itbrains.restoranfinalproject.services.UserService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean registerUser(RegisterDto registerDto) {
        Optional<User> existingUser = userRepository.findByEmail(registerDto.getEmail());
        if (existingUser.isPresent()) {
            System.out.println("User already exists with email: " + registerDto.getEmail());
            return false;
        }

        Optional<Role> roleOptional = roleRepository.findByName("ROLE_USER");
        if (!roleOptional.isPresent()) {
            System.out.println("Role ROLE_USER not found!");
            return false;
        }
        Role userRole = roleOptional.get();

        User user = new User();
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setRoles(Collections.singletonList(userRole));

        userRepository.save(user);
        System.out.println("User registered successfully: " + user.getEmail());
        return true;
    }

    @Override
    public UserDto getUserInfo(String userEmail) {
        Optional<User> userOpt = userRepository.findByEmail(userEmail);
        if (userOpt.isEmpty()) {
            return null;
        }

        User user = userOpt.get();
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
