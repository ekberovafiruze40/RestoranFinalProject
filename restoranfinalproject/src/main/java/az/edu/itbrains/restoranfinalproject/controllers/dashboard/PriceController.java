package az.edu.itbrains.restoranfinalproject.controllers.dashboard;

import az.edu.itbrains.restoranfinalproject.dtos.price.PriceCreateDto;
import az.edu.itbrains.restoranfinalproject.dtos.price.PriceGetAllDto;
import az.edu.itbrains.restoranfinalproject.dtos.price.PriceGetIdDto;
import az.edu.itbrains.restoranfinalproject.dtos.price.PriceUpdateDto;
import az.edu.itbrains.restoranfinalproject.services.PriceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/admin/price")
    public String price(Model model){
        List<PriceGetAllDto> result = priceService.priceGetAll();
        model.addAttribute("prices", result);
        return "/dashboard/price/index";
    }

    @GetMapping("/admin/price/create")
    public String priceCreate(Model model){
        return "/dashboard/price/create";
    }

    @PostMapping("/admin/price/create")
    public String createPrice(@ModelAttribute("price")PriceCreateDto priceCreateDto){
        priceService.createPrice(priceCreateDto);
        return "redirect:/admin/price";
    }

    @GetMapping("/admin/price/update/{id}")
    public String updatePrice(@PathVariable Long id, Model model){
        PriceGetIdDto priceGetIdDto=priceService.priceGetIdDto(id);
        model.addAttribute("price", priceGetIdDto);
        return "/dashboard/price/update";
    }

    @PostMapping("/admin/price/update/{id}")
    public String updatePrice(@PathVariable Long id, @ModelAttribute("price") PriceUpdateDto priceUpdateDto){
        priceService.updatePrice(priceUpdateDto, id);
        return "redirect:/admin/price";
    }

    @GetMapping("/admin/price/delete/{id}")
    public String deletePrice(@PathVariable Long id){
        return "/dashboard/price/delete";
    }

    @PostMapping("/admin/price/delete/{id}")
    public String removePrice(@PathVariable Long id){
        priceService.deletePrice(id);
        return "redirect:/admin/price";
    }

}
