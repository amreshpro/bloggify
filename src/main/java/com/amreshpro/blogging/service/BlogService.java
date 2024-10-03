package com.amreshpro.blogging.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amreshpro.blogging.model.Blog;
import com.amreshpro.blogging.repository.BlogRepository;

/**
 * BlogService
 */

@Service
public class BlogService {

    BlogRepository blogRepository;

    BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

   public  List<Blog> getAllBlog() {
        return  blogRepository.findAll();

    }

    public Boolean saveBlogEntry(Blog blog) {

        blog.setDate(LocalDateTime.now());
        blogRepository.save(blog);

        return true;
    }

}