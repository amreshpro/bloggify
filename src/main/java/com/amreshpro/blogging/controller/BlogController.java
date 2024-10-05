package com.amreshpro.blogging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.amreshpro.blogging.model.Blog;
import com.amreshpro.blogging.repository.BlogRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogRepository blogRepository;

    private final String IMAGE_DIRECTORY = "uploads"; // Specify your image directory

    @PostMapping
    public ResponseEntity<Blog> createBlog(
        @RequestParam String title,
        @RequestParam String description,
        @RequestParam MultipartFile imageFile
    ) {
        String imageUrl = saveImageFile(imageFile);
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setDescription(description);
        blog.setImageUrl(imageUrl);
        Blog savedBlog = blogRepository.save(blog);
        return new ResponseEntity<>(savedBlog, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    private String saveImageFile(MultipartFile imageFile) {
        try {
            String imagePath = IMAGE_DIRECTORY + File.separator + imageFile.getOriginalFilename();
            Path path = Paths.get(imagePath);
            Files.write(path, imageFile.getBytes());
            return imagePath;
        } catch (IOException e) {
            throw new RuntimeException("Failed to save image file: " + e.getMessage());
        }
    }
}
