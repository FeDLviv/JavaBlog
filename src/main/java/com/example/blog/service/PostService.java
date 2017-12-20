package com.example.blog.service;

import com.example.blog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Post> getPosts(){
        return jdbcTemplate.query("SELECT * FROM Post", new BeanPropertyRowMapper(Post.class));
    }

}
