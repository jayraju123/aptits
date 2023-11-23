package com.example.AptItSolutions.controller;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.AptItSolutions.Entity.Gallery;
import com.example.AptItSolutions.service.GalleryService;

import net.coobird.thumbnailator.Thumbnails; 




 
@RestController 
@RequestMapping("/imageapi") 
public class GalleryController { 
 
    private final GalleryService galleryService; 
 
    @Autowired 
    public GalleryController(GalleryService galleryService) { 
        this.galleryService = galleryService; 
    } 
 
    @GetMapping("/All") 
    public List<Gallery> getAllGalleryItems() { 
        return galleryService.getAllGalleryItems(); 
    } 
 
    @GetMapping("/getbyimage/{id}") 
    public ResponseEntity<Gallery> getGalleryItemById(@PathVariable("id") Long id) { 
        Gallery galleryItem = galleryService.getGalleryItemById(id); 
        if (galleryItem != null) { 
            return ResponseEntity.ok(galleryItem); 
        } 
        return ResponseEntity.notFound().build(); 
    } 
 
 


        @PostMapping("/image")
        public ResponseEntity<Gallery> createGalleryItem(@RequestParam("image") MultipartFile image,
                                                        @RequestParam("title") String title,
                                                        @RequestParam("description") String description,
                                                        @RequestParam("link") String link){
            try {
                byte[] imageData = image.getBytes();

                // Compress the image if its size exceeds 500KB
                if (imageData.length > 500 * 1024) {
                    BufferedImage originalImage = ImageIO.read(image.getInputStream());
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    String outputFormat = getImageOutputFormat(image.getContentType());
                    Thumbnails.of(originalImage).size(250, 250).outputFormat(outputFormat).outputQuality(1.0)
                            .toOutputStream(outputStream);
                    imageData = outputStream.toByteArray();

                    // If the compressed image is still larger than 500KB, reduce its quality
                    while (imageData.length > 500 * 1024) {
                        Thumbnails.of(new ByteArrayInputStream(imageData)).scale(0.9).outputQuality(0.9)
                                .toOutputStream(outputStream);
                        imageData = outputStream.toByteArray();
                        outputStream.reset();
                    }
                }

                Gallery galleryItem = new Gallery();
                galleryItem.setImage(imageData);
                galleryItem.setTitle(title); // Set the title
                galleryItem.setDescription(description); // Set the description
                galleryItem.setLink(link);

                Gallery savedGalleryItem = galleryService.saveGalleryItem(galleryItem);
                return ResponseEntity.status(HttpStatus.CREATED).body(savedGalleryItem);
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
       

        private String getImageOutputFormat(String contentType) {
            if (contentType != null && !contentType.isEmpty()) {
                if (contentType.contains("jpeg") || contentType.contains("jpg")) {
                    return "jpg";
                } else if (contentType.contains("png")) {
                    return "png";
                }
            }
            return "jpg"; // Default to JPG format if the content type is not available or unrecognized
        }
    

 
        @PutMapping("/image/{id}")
        public ResponseEntity<Gallery> updateGalleryItem(@PathVariable("id") Long id,
                                                        @RequestParam("image") MultipartFile image,
                                                        @RequestParam("title") String title,
                                                        @RequestParam("description") String description,
                                                        @RequestParam("link") String link)
                                                        {
            Gallery existingGalleryItem = galleryService.getGalleryItemById(id);
            if (existingGalleryItem != null) {
                try {
                    byte[] imageData = image.getBytes();

                    // Compress the image if its size exceeds 500KB
                    if (imageData.length > 500 * 1024) {
                        BufferedImage originalImage = ImageIO.read(image.getInputStream());
                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        String outputFormat = getImageOutputFormat1(image.getContentType());
                        Thumbnails.of(originalImage).size(250, 250).outputFormat(outputFormat).outputQuality(1.0)
                                .toOutputStream(outputStream);
                        imageData = outputStream.toByteArray();

                        // If the compressed image is still larger than 500KB, reduce its quality
                        while (imageData.length > 500 * 1024) {
                            Thumbnails.of(new ByteArrayInputStream(imageData)).scale(0.9).outputQuality(0.9)
                                    .toOutputStream(outputStream);
                            imageData = outputStream.toByteArray();
                            outputStream.reset();
                        }
                    }

                    existingGalleryItem.setImage(imageData);
                    existingGalleryItem.setTitle(title); // Set the title
                    existingGalleryItem.setDescription(description); // Set the description
                    existingGalleryItem.setLink(link);

                    Gallery updatedGalleryItem = galleryService.saveGalleryItem(existingGalleryItem);
                    return ResponseEntity.ok(updatedGalleryItem);
                } catch (IOException e) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
            }
            return ResponseEntity.notFound().build();
        }

        private String getImageOutputFormat1(String contentType) {
            if (contentType != null && !contentType.isEmpty()) {
                if (contentType.contains("jpeg") || contentType.contains("jpg")) {
                    return "jpg";
                } else if (contentType.contains("png")) {
                    return "png";
                }
            }
            return "jpg"; // Default to JPG format if the content type is not available or unrecognized
        }

    
    
    
    @DeleteMapping("deleteimage/{id}") 
    public ResponseEntity<Void> deleteGalleryItem(@PathVariable("id") Long id) { 
        Gallery galleryItem = galleryService.getGalleryItemById(id); 
        if (galleryItem != null) { 
            galleryService.deleteGalleryItem(galleryItem); 
            return ResponseEntity.noContent().build(); 
        } 
        return ResponseEntity.notFound().build(); 
    } 
}