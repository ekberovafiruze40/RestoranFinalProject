package az.edu.itbrains.restoranfinalproject.controllers.dashboard;

import az.edu.itbrains.restoranfinalproject.dtos.service.ServiceCreateDto;
import az.edu.itbrains.restoranfinalproject.dtos.service.ServiceGetAllDto;
import az.edu.itbrains.restoranfinalproject.dtos.service.ServiceGetIdDto;
import az.edu.itbrains.restoranfinalproject.dtos.service.ServiceUpdateDto;
import az.edu.itbrains.restoranfinalproject.services.ServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService service) {
        this.serviceService = service;
    }

    @GetMapping("/admin/service")
    public String service(Model model){
        List<ServiceGetAllDto> result=serviceService.servicesGetAll();
        model.addAttribute("services", result);
        return "/dashboard/service/index";
    }

    @GetMapping("/admin/service/create")
    public String serviceCreate(Model model){
        return "/dashboard/service/create";
    }

    @PostMapping("/admin/service/create")
    public String createService(@ModelAttribute("service") ServiceCreateDto serviceDto){
        serviceService.createService(serviceDto);
        return "redirect:/admin/service";
    }

    @GetMapping("/admin/service/update/{id}")
    public String serviceUpdate(@PathVariable Long id, Model model) {
        ServiceGetIdDto serviceGetIdDto=serviceService.servicesGetId(id);
        model.addAttribute("service", serviceGetIdDto);
        return "/dashboard/service/update";
    }

    @PostMapping("/admin/service/update/{id}")
    public String serviceUpdate(@PathVariable Long id, @ModelAttribute("service")ServiceUpdateDto service){
        serviceService.updateService(service, id);
        return "redirect:/admin/service";
    }

    @GetMapping("/admin/service/delete/{id}")
    public String serviceDelete(@PathVariable Long id){
        return "/dashboard/service/delete";
    }

    @PostMapping("/admin/service/delete/{id}")
    public String serviceRemove(@PathVariable Long id){
        serviceService.deleteService(id);
        return "redirect:/admin/service";
    }



}
