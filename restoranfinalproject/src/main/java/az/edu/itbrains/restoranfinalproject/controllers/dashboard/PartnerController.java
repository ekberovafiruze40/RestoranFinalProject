package az.edu.itbrains.restoranfinalproject.controllers.dashboard;

import az.edu.itbrains.restoranfinalproject.dtos.partner.PartnerCreateDto;
import az.edu.itbrains.restoranfinalproject.dtos.partner.PartnerGetAllDto;
import az.edu.itbrains.restoranfinalproject.dtos.partner.PartnerGetIdDto;
import az.edu.itbrains.restoranfinalproject.dtos.partner.PartnerUpdateDto;
import az.edu.itbrains.restoranfinalproject.services.PartnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PartnerController {
    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping("/admin/partner")
    public String partner(Model model){
        List<PartnerGetAllDto> result = partnerService.partnerGetAll();
        model.addAttribute("partners", result);
        return "/dashboard/partner/index";
    }

    @GetMapping("/admin/partner/create")
    public String partnerCreate(Model model){
        return "/dashboard/partner/create";
    }

    @PostMapping("/admin/partner/create")
    public String createPartner(@ModelAttribute("partner")PartnerCreateDto partnerCreateDto){
        partnerService.createPartner(partnerCreateDto);
        return "redirect:/admin/partner";
    }

    @GetMapping("/admin/partner/update/{id}")
    public String partnerUpdate(@PathVariable Long id, Model model){
        PartnerGetIdDto partnerGetIdDto = partnerService.partnerGetId(id);
        model.addAttribute("partner", partnerGetIdDto);
        return "/dashboard/partner/update";
    }

    @PostMapping("/admin/partner/update/{id}")
    public String partnerUpdate(@PathVariable Long id, @ModelAttribute("partner")PartnerUpdateDto partnerUpdateDto){
        partnerService.updatePartner(partnerUpdateDto, id);
        return "redirect:/admin/partner";
    }

    @GetMapping("/admin/partner/delete/{id}")
    public String deletePartner(@PathVariable Long id){
        return "/dashboard/partner/delete";
    }

    @PostMapping("/admin/partner/delete/{id}")
    public String removePartner(@PathVariable Long id){
        partnerService.deletePartner(id);
        return "redirect:/admin/partner";
    }
}
