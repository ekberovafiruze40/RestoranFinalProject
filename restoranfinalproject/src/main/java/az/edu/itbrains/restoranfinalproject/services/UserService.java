package az.edu.itbrains.restoranfinalproject.services;


import az.edu.itbrains.restoranfinalproject.dtos.auth.RegisterDto;
import az.edu.itbrains.restoranfinalproject.dtos.auth.UserDto;

public interface UserService {
    boolean registerUser(RegisterDto registerDto);
    UserDto getUserInfo(String userEmail);
}
