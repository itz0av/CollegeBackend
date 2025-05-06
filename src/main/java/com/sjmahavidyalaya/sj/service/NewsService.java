package com.sjmahavidyalaya.sj.service;
import com.sjmahavidyalaya.sj.model.CollegeNews;

import com.sjmahavidyalaya.sj.repo.NewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepo newsRepository;
    @Autowired
    private CloudinaryService cloudinaryService;
    public List<CollegeNews> getAllNews() {
        return newsRepository.findAll();
    }

    public CollegeNews saveNews(CollegeNews news, MultipartFile file) throws IOException {
        CollegeNews collegeNews = new CollegeNews();
        String imageUrl = cloudinaryService.uploadFile(file);
        collegeNews.setImageName(file.getOriginalFilename());
        collegeNews.setImageType(file.getContentType());
        collegeNews.setImageUrl(imageUrl);
        return newsRepository.save(news);
    }

    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }

    public CollegeNews updateNews(Long id, CollegeNews news, MultipartFile file) throws IOException {
        CollegeNews collegeNews = new CollegeNews();
        String imageUrl = cloudinaryService.uploadFile(file);
        collegeNews.setImageName(file.getOriginalFilename());
        collegeNews.setImageType(file.getContentType());
        collegeNews.setImageUrl(imageUrl);
        return newsRepository.save(news);
    }
}

