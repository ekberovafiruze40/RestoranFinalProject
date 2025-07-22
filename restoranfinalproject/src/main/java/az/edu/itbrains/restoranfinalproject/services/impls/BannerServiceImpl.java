package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.banner.BannerDto;
import az.edu.itbrains.restoranfinalproject.models.Banner;
import az.edu.itbrains.restoranfinalproject.repositories.BannerRepository;
import az.edu.itbrains.restoranfinalproject.services.BannerService;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService {


    private final BannerRepository bannerRepository;

    public BannerServiceImpl(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    @Override
    public BannerDto getBannerInfo() {
        Banner banner = bannerRepository.findById(1L).orElseThrow();
        BannerDto bannerDto = new BannerDto();
        bannerDto.setId(banner.getId());
        bannerDto.setTitle(banner.getTitle());
        bannerDto.setDescription(banner.getDescription());
        bannerDto.setImageUrl(banner.getImageUrl());
        return bannerDto;
    }
}
