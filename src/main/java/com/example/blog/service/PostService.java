package com.example.blog.service;

import com.example.blog.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    public List<Post> getPosts(){
        List<Post> posts = new ArrayList<Post>();
        posts.add(new Post(1L, "Tutorial spring", "More text..."));
        posts.add(new Post(1L, "About Ant", "More text..."));
        posts.add(new Post(1L, "Java Collections", "More text..."));
        return posts;
    }
}
