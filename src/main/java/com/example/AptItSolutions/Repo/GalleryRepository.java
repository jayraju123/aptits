package com.example.AptItSolutions.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AptItSolutions.Entity.Gallery;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery, Long> {
}
