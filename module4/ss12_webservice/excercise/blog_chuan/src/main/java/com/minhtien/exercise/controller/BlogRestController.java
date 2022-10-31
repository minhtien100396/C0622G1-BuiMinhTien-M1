package com.minhtien.exercise.controller;

import com.minhtien.exercise.model.Blog;
import com.minhtien.exercise.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blog/v1")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<Page<Blog>> getBlogList(@RequestParam(value = "page", defaultValue = "0") Integer page){
        Page<Blog> blogPage = blogService.findAll(PageRequest.of(page,5));
        if (blogPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage,HttpStatus.OK);
    }
    @GetMapping("/{id}/view")
    public ResponseEntity<Blog> viewBlog(@PathVariable(value = "id") Integer id){
        Blog blog = blogService.findById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }

    @GetMapping("/{idCatagory}")
    public ResponseEntity<Page<Blog>> getBlogByCatagory(@PathVariable(value = "idCatagory") Integer idCatagory,
                                                        @RequestParam(value = "page",defaultValue = "0") Integer page){
        Page<Blog> blogPage = blogService.findBlogByCatagory(idCatagory,PageRequest.of(page,5));
        if (blogPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage,HttpStatus.OK);
    }
}
