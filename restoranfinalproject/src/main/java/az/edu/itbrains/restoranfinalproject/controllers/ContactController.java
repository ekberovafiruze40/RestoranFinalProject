package az.edu.itbrains.restoranfinalproject.controllers;

import az.edu.itbrains.restoranfinalproject.dtos.contact.ContactDto;
import az.edu.itbrains.restoranfinalproject.services.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/contact")
    public String addContact(@ModelAttribute("contact")ContactDto contactDto){

        contactService.saveContact(contactDto);
        return "redirect:/contact";
    }
}
