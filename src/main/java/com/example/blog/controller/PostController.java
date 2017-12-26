package com.example.blog.controller;

import com.example.blog.dto.NewPostDTO;
import com.example.blog.dto.PostDTO;
import com.example.blog.entity.Post;
import com.example.blog.repository.PostRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
@Api(description="Операції повязані з постами")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostMapping
    @ApiOperation(value = "Додавання нового поста")
    public Post createPost (@RequestBody NewPostDTO post) {
        Post temp = new Post();
        temp.setTitle(post.getTitle());
        temp.setText(post.getText());
        temp.setDatePublic(new Date());
        return postRepository.save(temp);
    }

    @GetMapping
    @ApiOperation(value = "Отримання всіх постів, сортованих по даті публікації, з коротким текстом")
     public List<PostDTO> readPosts(){
        return postRepository.getList();
    }

    @GetMapping(value="/{id}")
    @ApiOperation(value = "Отримання поста по ID")
    public PostDTO readPost(@PathVariable int id) {
        return postRepository.getById(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation(value = "Оновлення поста по ID")
    public int updatePost(@RequestBody PostDTO post, @PathVariable int id) {
        return postRepository.updatePost(id, post.getTitle(), post.getText(), post.getDatePublic());
        //return postRepository.save(post);
    }

    @DeleteMapping
    @ApiOperation(value = "Видалення всіх постів")
    public void deletePosts() {
        postRepository.deleteAll();
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation(value = "Видалення поста по ID")
    public void deletePost(@PathVariable int id) {
        postRepository.deleteById(id);
    }

}
