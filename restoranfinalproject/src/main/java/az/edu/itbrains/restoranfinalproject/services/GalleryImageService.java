package az.edu.itbrains.restoranfinalproject.services;

import az.edu.itbrains.restoranfinalproject.dtos.gallery.GalleryImageDto;

import java.util.List;

public interface GalleryImageService {
    List<GalleryImageDto> getAllImages();
}
