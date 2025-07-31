package az.edu.itbrains.restoranfinalproject.services;

import az.edu.itbrains.restoranfinalproject.dtos.gallery.*;

import java.util.List;

public interface GalleryImageService {
    List<GalleryImageDto> getAllImages();

    List<GalleryGetAllDto> galleryGetAll();

    GalleryGetIdDto galleryGetIdDto(Long id);

    void createGallery(GalleryCreateDto galleryCreateDto);
    void updateGallery(GalleryUpdateDto galleryUpdateDto, Long id);
    void deleteGallery(Long id);
}
