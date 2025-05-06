package com.sjmahavidyalaya.sj.controller;

import com.sjmahavidyalaya.sj.model.CollegeNews;
import com.sjmahavidyalaya.sj.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

//@RequestMapping("/api/news")
//public class newsConstroller {
//
//    @RequestMapping("/1")
//    public String checktheApp(){
//        return "it is working properly";
//    }
//
//}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // To allow React frontend access
public class NewsController {

    @Autowired
    private NewsService newsService;
    @GetMapping("/news")
    public List<CollegeNews> getAllNews() {
        return newsService.getAllNews();
    }

    @PostMapping("/news")
    public CollegeNews addNews(@RequestBody CollegeNews news, MultipartFile file) throws IOException {
        return newsService.saveNews(news ,file);
    }
    @PutMapping("/news/{id}")
    public ResponseEntity<String> updateNews(@PathVariable Long id, @RequestPart CollegeNews news,
                                                @RequestPart MultipartFile imageFile) {
        CollegeNews news1;
        try {
            news1 = newsService.updateNews(id, news, imageFile);
        } catch (Exception e) {
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
        if (news1 != null)
            return new ResponseEntity<>("updated", HttpStatus.OK);
        else return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable Long id) {
        newsService.deleteNews(id);
    }
}

