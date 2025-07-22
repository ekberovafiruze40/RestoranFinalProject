package az.edu.itbrains.restoranfinalproject.controllers;

import az.edu.itbrains.restoranfinalproject.dtos.footer.FooterDto;
import az.edu.itbrains.restoranfinalproject.services.FooterService;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalModelAttributeController {

    private final FooterService footerService;

    public GlobalModelAttributeController(FooterService footerService) {
        this.footerService = footerService;
    }

    @ModelAttribute("footer")
    public FooterDto populateFooter(){
        return footerService.getFooterInfo();
    }
}
