package az.edu.itbrains.restoranfinalproject.controllers;

import az.edu.itbrains.restoranfinalproject.dtos.about.AboutDto;
import az.edu.itbrains.restoranfinalproject.dtos.banner.BannerDto;
import az.edu.itbrains.restoranfinalproject.dtos.category.CategoryDto;
import az.edu.itbrains.restoranfinalproject.dtos.contact.ContactInfoDto;
import az.edu.itbrains.restoranfinalproject.dtos.drink.DrinkDto;
import az.edu.itbrains.restoranfinalproject.dtos.gallery.GalleryImageDto;
import az.edu.itbrains.restoranfinalproject.dtos.menuItem.MenuItemDto;
import az.edu.itbrains.restoranfinalproject.dtos.ourTeam.OurTeamDto;
import az.edu.itbrains.restoranfinalproject.dtos.partner.PartnerDto;
import az.edu.itbrains.restoranfinalproject.dtos.price.PriceDto;
import az.edu.itbrains.restoranfinalproject.dtos.service.ServiceDto;
import az.edu.itbrains.restoranfinalproject.dtos.testimonial.TestimonialDto;
import az.edu.itbrains.restoranfinalproject.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashSet;


import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final AboutService aboutService;
    private final GalleryImageService galleryImageService;
    private final ServiceService service;
    private final BannerService bannerService;
    private final OurTeamService ourTeamService;
    private final CategoryService categoryService;
    private final PriceService priceService;
    private final MenuItemService menuItemService;
    private final TestimonialService testimonialService;
    private final BookingService bookingService;
    private final ContactInfoService contactInfoService;
    private final PartnerService partnerService;
    private final DrinkService drinkService;

    public HomeController(AboutService aboutService, GalleryImageService galleryImageService, ServiceService service, BannerService bannerService, OurTeamService ourTeamService, CategoryService categoryService, PriceService priceService, MenuItemService menuItemService, TestimonialService testimonialService, BookingService bookingService, ContactInfoService contactInfoService, FooterService footerService, PartnerService partnerService, DrinkService drinkService) {
        this.aboutService = aboutService;
        this.galleryImageService = galleryImageService;
        this.service = service;
        this.bannerService = bannerService;
        this.ourTeamService = ourTeamService;
        this.categoryService = categoryService;
        this.priceService = priceService;
        this.menuItemService = menuItemService;
        this.testimonialService = testimonialService;
        this.bookingService = bookingService;
        this.contactInfoService = contactInfoService;
        this.partnerService = partnerService;
        this.drinkService = drinkService;
    }

    @GetMapping("/")
    public String index(Model model){
        AboutDto aboutDto = aboutService.getAboutInfo();
        model.addAttribute("about", aboutDto);

        List<GalleryImageDto> galleryImages=galleryImageService.getAllImages();
        model.addAttribute("galleryImages", galleryImages);

        List<ServiceDto> services=service.getAllServices();
        model.addAttribute("services", services);

        BannerDto bannerDto = bannerService.getBannerInfo();
        model.addAttribute("banner", bannerDto);

        List<OurTeamDto> teams=ourTeamService.getAllTeam();
        model.addAttribute("teams", teams);

        List<CategoryDto> categories=categoryService.getAllCategories();
        model.addAttribute("categories", categories);

        List<PriceDto> prices=priceService.getAllPrices();
        model.addAttribute("prices", prices);

        List<MenuItemDto> menuItems = menuItemService.getAllMenuItems();
        model.addAttribute("menuItems", menuItems);

        Set<CategoryDto> uniqueCategories = menuItems.stream()
                .map(MenuItemDto::getCategory) // hər menuItem-dən category-ni çıxar
                .collect(Collectors.toCollection(LinkedHashSet::new)); // təkrarsız və sıralı

        model.addAttribute("uniqueCategories", uniqueCategories);

        List<TestimonialDto> testimonials=testimonialService.getAllTestimonials();
        model.addAttribute("testimonials", testimonials);


        return "/index";
    }



    @GetMapping("/about")
    public String about(Model model){
        AboutDto aboutDto = aboutService.getAboutInfo();
        model.addAttribute("about", aboutDto);

        List<GalleryImageDto> galleryImages=galleryImageService.getAllImages();
        model.addAttribute("galleryImages", galleryImages);


        List<OurTeamDto> teams=ourTeamService.getAllTeam();
        model.addAttribute("teams", teams);

        return "/about";
    }

    @GetMapping("/service")
    public String service(Model model){
        List<ServiceDto> services=service.getAllServices();
        model.addAttribute("services", services);
        return "/service";
    }

    @GetMapping("/menu")
    public String menu(@RequestParam(name="categoryId", required=false) Long categoryId, Model model) {
        List<CategoryDto> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);

        List<PriceDto> prices = priceService.getAllPrices();
        model.addAttribute("prices", prices);

        List<MenuItemDto> allMenuItems = menuItemService.getAllMenuItems();

        // Təkrarsız kateqoriyalar
        Set<CategoryDto> uniqueCategories = allMenuItems.stream()
                .map(MenuItemDto::getCategory)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        model.addAttribute("uniqueCategories", uniqueCategories);

        // Seçilmiş kateqoriyaya uyğun menu items
        List<MenuItemDto> menuItems;
        if(categoryId != null) {
            Long finalCategoryId = categoryId;
            menuItems = allMenuItems.stream()
                    .filter(item -> Objects.equals(item.getCategory().getId(), finalCategoryId))
                    .collect(Collectors.toList());
        } else {
            menuItems = allMenuItems.stream()
                    .filter(item -> Objects.equals(item.getCategory().getId(),
                            uniqueCategories.iterator().next().getId()))
                    .collect(Collectors.toList());
            categoryId = uniqueCategories.iterator().next().getId();
        }

        model.addAttribute("menuItems", menuItems);
        model.addAttribute("selectedCategoryId", categoryId);

        return "/menu";
    }


    @GetMapping("/drink")
    public String drink(@RequestParam(name = "search", required = false) String search, Model model){
        List<DrinkDto> drinks;
        if (search == null || search.isEmpty()) {
            drinks = drinkService.getAllDrinks();
        } else {
            drinks = drinkService.getDrinksByName(search);
        }
        model.addAttribute("drinks", drinks);
        model.addAttribute("search", search); // input-da yazını saxlamaq üçün
        return "/drink";
    }

    @GetMapping("/booking")
    public String booking(Model model){
        model.addAttribute("bookings", bookingService.getAllBookings());
        return "/booking";
    }

    @GetMapping("/team")
    public String team(Model model){
        List<OurTeamDto> teams=ourTeamService.getAllTeam();
        model.addAttribute("teams", teams);
        return "/team";
    }

    @GetMapping("/testimonial")
    public String testimonial(Model model){
        List<TestimonialDto> testimonials=testimonialService.getAllTestimonials();
        model.addAttribute("testimonials", testimonials);
        return "/testimonial";
    }

    @GetMapping("/partner")
    public String partner(Model model){
        List<PartnerDto> partners=partnerService.getAllPartners();
        model.addAttribute("partners", partners);
        return "/partner";
    }

    @GetMapping("/contact")
    public String contact(Model model){
        ContactInfoDto contactInfoDto = contactInfoService.getContactInfo();
        model.addAttribute("contactInfo", contactInfoDto);
        return "/contact";
    }


}
