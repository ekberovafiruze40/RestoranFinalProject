package az.edu.itbrains.restoranfinalproject.controllers;

import az.edu.itbrains.restoranfinalproject.dtos.contact.*;
import az.edu.itbrains.restoranfinalproject.services.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/admin/contact")
    public String contact(Model model){
        List<ContactGetAllDto> contactGetAllDto = contactService.getAllContact();
        model.addAttribute("contacts", contactGetAllDto);
        return "/dashboard/contact/index";
    }

    @GetMapping("/admin/contact/create")
    public String contactCreate(){
        return "/dashboard/contact/create";
    }

    @PostMapping("/admin/contact/create")
    public String contactCreate(@ModelAttribute("contact")ContactCreateDto contactCreateDto){
        contactService.createContact(contactCreateDto);
        return "redirect:/admin/contact";
    }

    @GetMapping("/admin/contact/update/{id}")
    public String contactUpdate(@PathVariable Long id, Model model){
        ContactGetIdDto contactGetIdDto = contactService.getContactId(id);
        model.addAttribute("contact", contactGetIdDto);
        return "/dashboard/contact/update";
    }

    @PostMapping("/admin/contact/update/{id}")
    public String contactUpdate(@PathVariable Long id, @ModelAttribute("contact")ContactUpdateDto contactUpdateDto){
        contactService.updateContact(contactUpdateDto, id);
        return "redirect:/admin/contact";
    }

    @GetMapping("/admin/contact/delete/{id}")
    public String contactDelete(@PathVariable Long id){
        return "/dashboard/contact/delete";
    }

    @PostMapping("/admin/contact/delete/{id}")
    public String contactRemove(@PathVariable Long id){
        contactService.deleteContact(id);
        return "redirect:/admin/contact";
    }


}
