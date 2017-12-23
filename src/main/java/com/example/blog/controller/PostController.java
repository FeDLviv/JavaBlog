package com.example.blog.controller;

import com.example.blog.model.Post;
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

    @RequestMapping(method=RequestMethod.POST)
    @ApiOperation(value = "Додавання нового поста")
    public Post createPost (@RequestBody Post post) {
        post.setDatePublic(new Date());
        return postRepository.save(post);
    }

    @RequestMapping(method= RequestMethod.GET)
    @ApiOperation(value = "Отримання всіх постів")
     public List<Post> readPosts(){
         return postRepository.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ApiOperation(value = "Отримання поста по ID")
    public Optional<Post> readPost(@PathVariable int id) {
        return postRepository.findById(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    @ApiOperation(value = "Оновлення поста по ID")
    public int updatePost(@RequestBody Post post, @PathVariable int id) {
        //System.out.println(post);
        //post.setDatePublic(new Date());
        return postRepository.updatePost(id, post.getTitle(), post.getText());
        //return postRepository.save(post);
    }

    @RequestMapping(method=RequestMethod.DELETE)
    @ApiOperation(value = "Видалення всіх постів")
    public void deletePosts() {
        postRepository.deleteAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ApiOperation(value = "Видалення поста по ID")
    public void deletePost(@PathVariable int id) {
        postRepository.deleteById(id);
    }

}
