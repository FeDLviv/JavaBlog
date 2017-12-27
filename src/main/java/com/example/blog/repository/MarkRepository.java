package com.example.blog.repository;

import com.example.blog.dto.MarkDTO;
import com.example.blog.entity.Mark;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MarkRepository extends CrudRepository<Mark, Integer> {

    @Query("SELECT new com.example.blog.dto.MarkDTO(m.id, m.name) FROM Mark m ORDER BY m.name")
    List<MarkDTO> getList();

    @Query("SELECT new com.example.blog.dto.MarkDTO(m.id, m.name) FROM Mark m WHERE m.id = :id")
    MarkDTO getById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE mark SET name = :name WHERE id_mark = :id")
    int updateMark(@Param("id") int id, @Param("name") String name);

}
