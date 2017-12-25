package com.example.blog.repository;

import com.example.blog.entity.Mark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends CrudRepository<Mark, Integer> {

    List<Mark> findAll();

}
