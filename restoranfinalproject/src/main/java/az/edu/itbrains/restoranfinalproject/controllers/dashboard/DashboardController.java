package az.edu.itbrains.restoranfinalproject.controllers.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/admin")
    public String admin(){
        return "/dashboard/index";
    }
}
