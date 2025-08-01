package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.gallery.*;
import az.edu.itbrains.restoranfinalproject.models.GalleryImage;
import az.edu.itbrains.restoranfinalproject.repositories.GalleryImageRepository;
import az.edu.itbrains.restoranfinalproject.services.GalleryImageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GalleryImageServiceImpl implements GalleryImageService {

    private final GalleryImageRepository galleryImageRepository;
    private final ModelMapper modelMapper;

    public GalleryImageServiceImpl(GalleryImageRepository galleryImageRepository, ModelMapper modelMapper) {
        this.galleryImageRepository = galleryImageRepository;
        this.modelMapper = modelMapper;
    }

//    @Override
//    public List<GalleryImageDto> getAllImages() {
//        List<GalleryImageDto> galleryImageDtos = galleryImageRepository.findAll().stream()
//                .map(galleryImage -> {
//                    GalleryImageDto galleryImageDto=new GalleryImageDto();
//
//                    galleryImageDto.setId(galleryImage.getId());
//                    galleryImageDto.setImageUrl(galleryImage.getImageUrl());
//                    return galleryImageDto;
//                }).collect(Collectors.toList());
//        return galleryImageDtos;
//    }



    @Override
    public List<GalleryImageDto> getAllImages() {
        List<GalleryImageDto> galleryImageDtos = galleryImageRepository.findAll().stream()
                .map(galleryImage -> modelMapper.map(galleryImage, GalleryImageDto.class)).toList();
        return galleryImageDtos;
    }

    @Override
    public List<GalleryGetAllDto> galleryGetAll() {
        List<GalleryGetAllDto> galleries=galleryImageRepository.findAll()
                .stream().map(galleryImage -> modelMapper.map(galleryImage, GalleryGetAllDto.class)).collect(Collectors.toList());
        return galleries;
    }

    @Override
    public GalleryGetIdDto galleryGetIdDto(Long id) {
        GalleryImage findGallery=galleryImageRepository.findById(id).orElseThrow();
        GalleryGetIdDto result = modelMapper.map(findGallery, GalleryGetIdDto.class);
        return result;
    }

    @Override
    public void createGallery(GalleryCreateDto galleryCreateDto) {
        GalleryImage gallery=new GalleryImage();
        gallery.setImageUrl(galleryCreateDto.getImageUrl());
        galleryImageRepository.save(gallery);
    }

    @Override
    public void updateGallery(GalleryUpdateDto galleryUpdateDto, Long id) {
        GalleryImage gallery = galleryImageRepository.findById(id).orElseThrow();
        gallery.setImageUrl(galleryUpdateDto.getImageUrl());
        galleryImageRepository.save(gallery);
    }

    @Override
    public void deleteGallery(Long id) {
        GalleryImage findGallery=galleryImageRepository.findById(id).orElseThrow();
        galleryImageRepository.delete(findGallery);
    }
}
