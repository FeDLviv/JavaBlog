package com.example.blog.repository;

import com.example.blog.dto.UserDTO;
import com.example.blog.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByName(String name);

    @Query("SELECT new com.example.blog.dto.UserDTO(u.id, u.name) FROM User u ORDER BY u.name")
    List<UserDTO> getList();

    @Query("SELECT new com.example.blog.dto.UserDTO(u.id, u.name) FROM User u WHERE u.id = :id")
    UserDTO getById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE user SET name = :name, password = :password WHERE id_user = :id")
    int updateUser(@Param("id") int id, @Param("name") String name, @Param("password") String password);

}
