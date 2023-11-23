package com.example.AptItSolutions.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.example.AptItSolutions.Entity.Download;
import com.example.AptItSolutions.Repo.DownloadRepo;
import com.example.AptItSolutions.ServiceImpl.DownloadServiceImpl;

@RequestMapping("/api")
@RestController
public class DownloadController {

    @Autowired
    private DownloadServiceImpl downloadService;

    @Autowired
    private DownloadRepo downloadRepo;

    @GetMapping("/total-count")
    public Integer getTotalCount() {
        return downloadService.calculateTotalCount();
    }

    @PostMapping("/incrementDownloadCount/{id}")
    public ResponseEntity<String> incrementDownloadCount(@PathVariable("id") int id) {
        try {
            downloadService.incrementDownloadCount(id);
            return ResponseEntity.ok("Download count incremented successfully.");
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error incrementing download count: " + e.getMessage());
        }
    }

    @PostMapping("/upload")
    public Download uploadFile(@RequestParam("title") String title,
                               @RequestParam("description") String description,
                               @RequestParam("file") MultipartFile file) throws IOException {
        Download download = new Download();
        download.setTitle(title);
        download.setDescription(description);
        download.setFile(file.getBytes());
        download.setCount(0); // Set the count property to a default value

        // Extract file extension from the original file name, including the dot
        String fileType = getFileExtension(file.getOriginalFilename());
        download.setFileType(fileType);

        return downloadService.saveDownload(download);
    }

    // Define the getFileExtension method in your DownloadController class
    private String getFileExtension(String filename) {
        if (filename == null || filename.isEmpty() || !filename.contains(".")) {
            return "";
        }

        return filename.substring(filename.lastIndexOf(".")).toLowerCase(); // This includes the dot now
    }

    @GetMapping("/getall")
    public List<Download> getAllDownloads() {
        return downloadService.getAllDownloads();
    }

    @GetMapping("/download/{id}")
    public Download getDownloadById(@PathVariable int id) {
        return downloadService.getDownloadById(id);
    }

    @PutMapping("/updatedownload/{id}")
    public Download updateFile(@PathVariable int id,
                               @RequestParam("title") String title,
                               @RequestParam("description") String description,
                               @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        Download download = downloadService.getDownloadById(id);
        if (download == null) {
        }

        download.setTitle(title);
        download.setDescription(description);
        if (file != null) {
            download.setFile(file.getBytes());
        }

        return downloadService.updateDownload(id, download);
    }

    @GetMapping("/filetype/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable int id) {
        Download download = downloadService.getDownloadById(id);
        if (download == null) {
            return ResponseEntity.notFound().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/octet-stream")); // generic stream
        String filename = download.getTitle() + "." + download.getFileType();
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(filename).build());


        return new ResponseEntity<>(download.getFile(), headers, HttpStatus.OK);
    }

    @DeleteMapping("/deletebydownload/{id}")
    public void deleteScrollNews(@PathVariable int id) {
        downloadService.deleteDownloadNews(id);
    }
}
