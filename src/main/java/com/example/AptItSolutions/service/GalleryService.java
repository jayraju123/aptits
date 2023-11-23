package com.example.AptItSolutions.service;

import java.util.List;

import com.example.AptItSolutions.Entity.Gallery;

public interface GalleryService 
{
    List<Gallery> getAllGalleryItems();

    Gallery getGalleryItemById(Long id);

    Gallery saveGalleryItem(Gallery galleryItem);

    void deleteGalleryItem(Gallery galleryItem);
}
