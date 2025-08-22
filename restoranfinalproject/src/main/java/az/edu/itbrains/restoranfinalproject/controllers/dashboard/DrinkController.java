package az.edu.itbrains.restoranfinalproject.controllers.dashboard;

import az.edu.itbrains.restoranfinalproject.dtos.drink.DrinkCreateDto;
import az.edu.itbrains.restoranfinalproject.dtos.drink.DrinkGetAllDto;
import az.edu.itbrains.restoranfinalproject.dtos.drink.DrinkGetIdDto;
import az.edu.itbrains.restoranfinalproject.dtos.drink.DrinkUpdateDto;
import az.edu.itbrains.restoranfinalproject.services.DrinkService;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DrinkController {

    private final DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping("/admin/drink")
    public String drink(Model model){
        List<DrinkGetAllDto> drinkGetAllDto = drinkService.drinkGetAll();
        model.addAttribute("drinks", drinkGetAllDto);
        return "/dashboard/drink/index";
    }

    @GetMapping("/admin/drink/create")
    public String createDrink(Model model){
        return "/dashboard/drink/create";
    }

    @PostMapping("/admin/drink/create")
    public String drinkCreate(@ModelAttribute("drink")DrinkCreateDto drinkCreateDto) {
        drinkService.createDrink(drinkCreateDto);
        return "redirect:/admin/drink";
    }

    @GetMapping("/admin/drink/update/{id}")
    public String updateDrink(@PathVariable Long id, Model model) {
        DrinkGetIdDto drinkGetIdDto = drinkService.drinkGetIdDto(id);
        model.addAttribute("drink", drinkGetIdDto);
        return "/dashboard/drink/update";
    }

    @PostMapping("/admin/drink/update/{id}")
    public String updateDrink(@PathVariable Long id, @ModelAttribute("drink")DrinkUpdateDto drinkUpdateDto) {
        drinkService.updateDrink(drinkUpdateDto, id);
        return "redirect:/admin/drink";
    }

    @GetMapping("/admin/drink/delete/{id}")
    public String deleteDrink(@PathVariable Long id){
        return "dashboard/drink/delete";
    }

    @PostMapping("/admin/drink/delete/{id}")
    public String removeDrink(@PathVariable Long id){
        drinkService.deleteDrink(id);
        return "redirect:/admin/drink";
    }
}
