package az.edu.itbrains.restoranfinalproject.controllers.dashboard;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PreAuthorize("isAuthenticated()")
public class DashboardController {

    @GetMapping("/admin")
    public String admin(){
        return "/dashboard/index";
    }
}
