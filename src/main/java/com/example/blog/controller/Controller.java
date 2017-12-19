package com.example.blog.controller;

import com.example.blog.model.Post;
import com.example.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String index(){
        return "My blog!!!";
    }

    @RequestMapping(name="/posts", method= RequestMethod.GET)
    public List<Post> posts(){
        return postService.getPosts();
    }
}
