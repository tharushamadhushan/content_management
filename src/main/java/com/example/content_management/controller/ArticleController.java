package com.example.content_management.controller;

import com.example.content_management.dto.ArticleDTO;
import com.example.content_management.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:63342") // Adjust the allowed origin as needed
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/health")
    public String healthTest(){
        return "Articles Health work";
    }

    @PostMapping
    public ArticleDTO saveArticle(@RequestBody ArticleDTO article) {
        return articleService.saveArticle(article);
    }

    @GetMapping
    public List<ArticleDTO> getAllArticle() {
        return articleService.getAllArticles();
    }

    @DeleteMapping(value = "/{authorId}")
    public void deleteArticle(@PathVariable ("authorId") String id){
        articleService.deleteArticle(id);
    }

    @PatchMapping
    public void update(@RequestBody ArticleDTO articleDTO) throws ChangeSetPersister.NotFoundException {
        articleService.updateArticle(articleDTO.getAuthorId(),articleDTO);
    }
}
