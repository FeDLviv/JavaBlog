package com.example.blog.repository;

import com.example.blog.dto.PostIdAndTitle;
import com.example.blog.model.Post;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

    List<Post> findAll();

    @Query("SELECT new com.example.blog.dto.PostIdAndTitle(p.id, p.title) FROM Post p")
    List<PostIdAndTitle> getList();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE post SET title = :title, text = :text, public = :datePublic WHERE id_post = :id")
    int updatePost(@Param("id") int id, @Param("title") String title, @Param("text") String text, @Param("datePublic") Date datePublic);

    //@Query(nativeQuery = true, value = "SELECT id_post, text FROM post ")
    //List<Object[]> test()1;

    //@Query("Select p.id FROM Post p")
    //List<PostProjection> test2();

    //@Query("SELECT new com.example.blog.model.Post(p.id, p.title) FROM Post p")
    //List<Post> test3();

}