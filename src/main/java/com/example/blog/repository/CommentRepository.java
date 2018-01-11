package com.example.blog.repository;

import com.example.blog.dto.CommentDTO;
import com.example.blog.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Integer> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "INSERT INTO comment (text, id_post, id_user) VALUES (:text, :idPost, :idUser)")
    void createComment(@Param("text") String text, @Param("idPost") int idPost, @Param("idUser") int idUser);

    @Query("SELECT new com.example.blog.dto.CommentDTO(c.id, c.text, c.datePublic, u.name) FROM Comment c INNER JOIN c.user u ORDER BY c.datePublic")
    List<CommentDTO> getList();

    @Query("SELECT new com.example.blog.dto.CommentDTO(c.id, c.text, c.datePublic, u.name) FROM Comment c INNER JOIN c.user u WHERE c.id = :id")
    CommentDTO getById(@Param("id") int id);

    @Query("SELECT new com.example.blog.dto.CommentDTO(c.id, c.text, c.datePublic, u.name) FROM Comment c INNER JOIN c.user u INNER JOIN c.post p WHERE p.id = :id")
    Page<CommentDTO> getListByPostId(@Param("id") int id, Pageable pageable);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE comment SET text = :text, public = :datePublic WHERE id_comment = :id")
    int updateComment(@Param("id") int id, @Param("text") String text, @Param("datePublic") Date datePublic);

}
