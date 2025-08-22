package az.edu.itbrains.restoranfinalproject.controllers.dashboard;

import az.edu.itbrains.restoranfinalproject.models.User;
import az.edu.itbrains.restoranfinalproject.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/user")
    public String listUser(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "/dashboard/user/index";
    }

    @PostMapping("/admin/user/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return "redirect:/admin/user";
    }
    @PostMapping("/admin/user/role/{id}")
    public String changeUserRole(@PathVariable Long id, @RequestParam String role){
        userService.updateUserRole(id, role);
        return "redirect:/admin/user";
    }
}
