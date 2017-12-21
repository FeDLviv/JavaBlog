package com.example.blog.controller;

import com.example.blog.model.Post;
import com.example.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
public class RController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping(name="/post", method= RequestMethod.GET)
     public List<Post> posts(){
        //return postService.getPosts();
        return postRepository.findAll();
    }

}
