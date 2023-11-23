package com.example.AptItSolutions.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.AptItSolutions.Entity.Gallery;
import com.example.AptItSolutions.Repo.GalleryRepository;
import com.example.AptItSolutions.service.GalleryService;

@Service
public class GalleryServiceImpl implements GalleryService {

    private final GalleryRepository galleryRepository;

    @Autowired
    public GalleryServiceImpl(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    @Override
    public List<Gallery> getAllGalleryItems() {
        return galleryRepository.findAll();
    }

    @Override
    public Gallery getGalleryItemById(Long id) {
        Optional<Gallery> galleryItemOptional = galleryRepository.findById(id);
        return galleryItemOptional.orElse(null);
    }

    @Override
    public Gallery saveGalleryItem(Gallery galleryItem) {
        return galleryRepository.save(galleryItem);
    }

    @Override
    public void deleteGalleryItem(Gallery galleryItem) {
        galleryRepository.delete(galleryItem);
    }
}
