package com.example.blog.repository;

import com.example.blog.model.Post;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

    List<Post> findAll();

    @Modifying
    @Transactional
    @Query("UPDATE Post p SET p.title = :title, p.text = :text WHERE p.id = :id")
    int updatePost(@Param("id") int id, @Param("title") String title, @Param("text") String text);

}