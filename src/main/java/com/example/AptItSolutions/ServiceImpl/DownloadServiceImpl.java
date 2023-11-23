package com.example.AptItSolutions.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AptItSolutions.Entity.Download;
import com.example.AptItSolutions.Repo.DownloadRepo;
import com.example.AptItSolutions.service.DownloadService;

import jakarta.transaction.Transactional;

@Service
public class DownloadServiceImpl implements DownloadService{
@Autowired
private DownloadRepo downloadRepo;
	@Override
	public Download saveDownload(Download download) {
	
		return downloadRepo.save(download);
	}
	@Override
	public List<Download> getAllDownloads() {
		
		return downloadRepo.findAll();
	}
	@Override
	public Download getDownloadById(int id) {
		
		return downloadRepo.findById(id).get();
	}
	  @Override
	    public Download updateDownload(int id, Download updatedDownload) {
	        Download existingDownload = downloadRepo.findById(id).orElse(null);
	        if (existingDownload != null) {
	            existingDownload.setTitle(updatedDownload.getTitle());
	            existingDownload.setDescription(updatedDownload.getDescription());
	            existingDownload.setFile(updatedDownload.getFile());
	            return downloadRepo.save(existingDownload);
	        }
	        return null;
	    }

	  @Override
		public void deleteDownloadNews(int id) {
			downloadRepo.deleteById(id);
			
		}
	  @Override
	  public void incrementDownloadCount(int id) {
		    Download download = downloadRepo.findById(id).orElse(null);
		    if (download != null) {
		        Integer count = download.getCount();
		        if (count == null) {
		            count = 0;
		        }
		        download.setCount(count + 1);
		        downloadRepo.save(download);
		    }
		}
	  
	  @Override
	    @Transactional
	    public Integer calculateTotalCount() {
	        return downloadRepo.findAll()
	                         .stream()
	                         .mapToInt(Download::getCount)
	                         .sum();
	    }
	  
	  

}
