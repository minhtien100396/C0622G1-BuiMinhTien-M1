package com.minhtien.exercise.controller;

import com.minhtien.exercise.model.Blog;
import com.minhtien.exercise.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/blog/v1")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> getBlogList(@PageableDefault(value = 2) Pageable pageable) {
        Page<Blog> blogPage = blogService.findAll(pageable);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        if (pageable.getPageNumber() > blogPage.getTotalPages()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage.getContent(), HttpStatus.OK);
    }

    @GetMapping("/{id}/view")
    public ResponseEntity<Blog> viewBlog(@PathVariable(value = "id") Integer id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/{idCatagory}")
    public ResponseEntity<Page<Blog>> getBlogByCatagory(@PathVariable(value = "idCatagory") Integer idCatagory,
                                                        @RequestParam(value = "page", defaultValue = "0") Integer page) {
        Page<Blog> blogPage = blogService.findBlogByCatagory(idCatagory, PageRequest.of(page, 5));
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> getBlogByAuthor(@PageableDefault(value = 2) Pageable pageable,
                                                      @RequestParam(value = "authorSearch") String authorSearch) {
        Page<Blog> blogList;
        if (authorSearch.equals("")) {
            blogList = blogService.findAll(pageable);
        } else {
            blogList = blogService.findByAuthor(authorSearch, pageable);
            if (blogList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(blogList.getContent(), HttpStatus.OK);
    }
}
