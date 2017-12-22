package com.example.blog.repository;

import com.example.blog.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer>{

    List<Comment> findAll();

}
