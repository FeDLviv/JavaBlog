package com.example.blog.controller;

import com.example.blog.dto.NewPostDTO;
import com.example.blog.dto.PostDTO;
import com.example.blog.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@Api(description="Операції повязані з постами")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    @ApiOperation(value = "Додавання нового поста")
    public PostDTO createPost (@RequestBody NewPostDTO post) {
        return postService.createPost(post);
    }

    @GetMapping
    @ApiOperation(value = "Отримання всіх постів, сортованих по даті публікації, з коротким текстом")
     public List<PostDTO> readPosts(){
        return postService.readPosts();
    }

    @GetMapping(value="/{id}")
    @ApiOperation(value = "Отримання поста по ID")
    public PostDTO readPost(@PathVariable int id) {
        return postService.readPost(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation(value = "Оновлення поста по ID")
    public int updatePost(@RequestBody PostDTO post, @PathVariable int id) {
        return postService.updatePost(post, id);
    }

    @DeleteMapping
    @ApiOperation(value = "Видалення всіх постів")
    public void deletePosts() {
        postService.deletePosts();
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation(value = "Видалення поста по ID")
    public void deletePost(@PathVariable int id) {
        postService.deletePost(id);
    }

}
