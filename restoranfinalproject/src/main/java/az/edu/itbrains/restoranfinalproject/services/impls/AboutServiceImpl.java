package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.about.AboutDto;
import az.edu.itbrains.restoranfinalproject.models.About;
import az.edu.itbrains.restoranfinalproject.repositories.AboutRepository;
import az.edu.itbrains.restoranfinalproject.services.AboutService;
import org.springframework.stereotype.Service;

@Service
public class AboutServiceImpl implements AboutService {

    private final AboutRepository aboutRepository;

    public AboutServiceImpl(AboutRepository aboutRepository) {
        this.aboutRepository = aboutRepository;
    }

    @Override
    public AboutDto getAboutInfo() {

        About about = aboutRepository.findById(1L).orElseThrow();
        AboutDto aboutDto = new AboutDto();
        aboutDto.setId(about.getId());
        aboutDto.setTitle(about.getTitle());
        aboutDto.setSubTitle(about.getSubTitle());
        aboutDto.setIcon(about.getIcon());
        aboutDto.setDescription(about.getDescription());
        aboutDto.setYearsOfExperience(about.getYearsOfExperience());
        aboutDto.setPopularCount(about.getPopularCount());
        return aboutDto;
    }
}
