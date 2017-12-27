package com.example.blog.service;

import com.example.blog.dto.NewUserDTO;
import com.example.blog.dto.UserDTO;
import com.example.blog.mapper.UserMapper;
import com.example.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(NewUserDTO user) {
        return UserMapper.INSTANCE.UserToUserDTO(userRepository.save(UserMapper.INSTANCE.NewUserDTOToUser(user)));
    }

    public List<UserDTO> readUsers() {
        return userRepository.getList();
    }

    public UserDTO readUser(int id) {
        return userRepository.getById(id);
    }

    public int updateUser(UserDTO user, int id) {
        return userRepository.updateUser(id, user.getName());
    }

    public void deleteUsers() {
        userRepository.deleteAll();
    }


    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
