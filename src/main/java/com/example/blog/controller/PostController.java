package com.example.blog.controller;

import com.example.blog.model.Post;
import com.example.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping(method=RequestMethod.POST)
    public Post createPost (@RequestBody Post post) {
        post.setDatePublic(new Date());
        return postRepository.save(post);
    }

    @RequestMapping(method= RequestMethod.GET)
     public List<Post> readPosts(){
         return postRepository.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Optional<Post> readPost(@PathVariable int id) {
        return postRepository.findById(id);
    }

//    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
//    public @ResponseBody Post updatePost(@RequestBody Post post, @PathVariable int id) {
//        return postRepository.save(post);
//    }

    @RequestMapping(method=RequestMethod.DELETE)
    public void deletePosts() {
        postRepository.deleteAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void deletePost(@PathVariable int id) {
        postRepository.deleteById(id);
    }

}
