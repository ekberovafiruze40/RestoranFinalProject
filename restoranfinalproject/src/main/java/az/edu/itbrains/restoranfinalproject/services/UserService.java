package az.edu.itbrains.restoranfinalproject.services;


import az.edu.itbrains.restoranfinalproject.dtos.auth.RegisterDto;
import az.edu.itbrains.restoranfinalproject.dtos.auth.UserDto;
import az.edu.itbrains.restoranfinalproject.models.User;

import java.util.List;

public interface UserService {
    boolean registerUser(RegisterDto registerDto);
    UserDto getUserInfo(String userEmail);
    void addRoleToUser(String email, String roleName);

    List<User> getAllUsers();
    void deleteUserById(Long id);
    void updateUserRole(Long id, String role);

}
