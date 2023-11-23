package com.example.AptItSolutions.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AptItSolutions.Entity.Download;

public interface DownloadRepo extends JpaRepository<Download, Integer> {

}
