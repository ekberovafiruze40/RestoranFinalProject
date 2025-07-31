package az.edu.itbrains.restoranfinalproject.controllers.dashboard;

import az.edu.itbrains.restoranfinalproject.dtos.gallery.GalleryCreateDto;
import az.edu.itbrains.restoranfinalproject.dtos.gallery.GalleryGetAllDto;
import az.edu.itbrains.restoranfinalproject.dtos.gallery.GalleryGetIdDto;
import az.edu.itbrains.restoranfinalproject.dtos.gallery.GalleryUpdateDto;
import az.edu.itbrains.restoranfinalproject.services.GalleryImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GalleryController {

    private final GalleryImageService galleryImageService;

    public GalleryController(GalleryImageService galleryImageService) {
        this.galleryImageService = galleryImageService;
    }

    @GetMapping("/admin/gallery")
    public String gallery(Model model){
        List<GalleryGetAllDto> result=galleryImageService.galleryGetAll();
        model.addAttribute("galleryImages", result);
        return "/dashboard/gallery/index";
    }

    @GetMapping("/admin/gallery/create")
    public String galleryCreate(Model model){
        return "/dashboard/gallery/create";
    }

    @PostMapping("/admin/gallery/create")
    public String createGallery(@ModelAttribute("galleryImage")GalleryCreateDto galleryCreateDto){
        galleryImageService.createGallery(galleryCreateDto);
        return "redirect:/admin/gallery";
    }

    @GetMapping("/admin/gallery/update/{id}")
    public String galleryUpdate(@PathVariable Long id, Model model){
        GalleryGetIdDto galleryGetIdDto=galleryImageService.galleryGetIdDto(id);
        model.addAttribute("galleryImage", galleryGetIdDto);
        return "/dashboard/gallery/update";
    }

    @PostMapping("/admin/gallery/update/{id}")
    public String galleryUpdate(@PathVariable Long id, @ModelAttribute("galleryImage")GalleryUpdateDto galleryUpdateDto){
        galleryImageService.updateGallery(galleryUpdateDto, id);
        return "redirect:/admin/gallery";
    }

    @GetMapping("/admin/gallery/delete/{id}")
    public String deleteGallery(@PathVariable Long id){
        return "/dashboard/gallery/delete";
    }

    @PostMapping("/admin/gallery/delete/{id}")
    public String removeGallery(@PathVariable Long id){
        galleryImageService.deleteGallery(id);
        return "redirect:/admin/gallery";
    }
}
