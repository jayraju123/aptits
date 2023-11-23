package com.example.AptItSolutions.service;

import java.util.List;

import com.example.AptItSolutions.Entity.Download;

public interface DownloadService {
    Download saveDownload(Download download);
    List<Download> getAllDownloads();
    Download getDownloadById(int id);
    Download updateDownload(int id, Download download);
    void deleteDownloadNews(int id);
    void incrementDownloadCount(int id);
    Integer calculateTotalCount();
}
