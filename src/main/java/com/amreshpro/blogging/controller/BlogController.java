package com.amreshpro.blogging.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amreshpro.blogging.model.Blog;
import com.amreshpro.blogging.service.BlogService;

/**
 * BlogController
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    BlogService blogService;

    BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlog() {
        List<Blog> blogList = blogService.getAllBlog();
        return blogList.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE)
                : new ResponseEntity<>(blogList, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<String> saveBlogEntry(Blog blog) {
        Boolean isSaved = blogService.saveBlogEntry(blog);
        if (isSaved) {
            return new ResponseEntity<>("Blog saved Successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to save blog", HttpStatus.NOT_ACCEPTABLE);

        }
    }

}