package az.edu.itbrains.restoranfinalproject.controllers.dashboard;

import az.edu.itbrains.restoranfinalproject.models.Role;
import az.edu.itbrains.restoranfinalproject.repositories.RoleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoleController {

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping("/admin/role")
    public String listRole(Model model){
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("newRole", new Role());
        return "/dashboard/role/index";
    }

    @PostMapping("/admin/role/delete/{id}")
    public String deleteRole(@PathVariable Long id) {
        roleRepository.deleteById(id);
        return "redirect:/admin/role";
    }
}
