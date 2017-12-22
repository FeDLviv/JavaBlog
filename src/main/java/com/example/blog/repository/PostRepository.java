package com.example.blog.repository;

import com.example.blog.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

    List<Post> findAll();

    //test
    @Query(value="Select p.text from Post p")
    List<String> getText();

}