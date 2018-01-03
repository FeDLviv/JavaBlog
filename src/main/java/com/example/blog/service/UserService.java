package com.example.blog.service;

import com.example.blog.dto.NewUserDTO;
import com.example.blog.dto.UserDTO;
import com.example.blog.entity.User;
import com.example.blog.mapper.UserMapper;
import com.example.blog.repository.RoleRepository;
import com.example.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void createUser(NewUserDTO user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        User temp = UserMapper.INSTANCE.NewUserDTOToUser(user);
        temp.setRoles(new ArrayList<>());
        temp.getRoles().add(roleRepository.findByName("ROLE_USER"));
        userRepository.save(temp);
    }

    public List<UserDTO> readUsers() {
        return userRepository.getList();
    }

    public UserDTO readUser(int id) {
        return userRepository.getById(id);
    }

    public int updateUser(NewUserDTO user, int id) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return userRepository.updateUser(id, user.getName(), encoder.encode(user.getPassword()));
    }

    public void deleteUsers() {
        userRepository.deleteAll();
    }


    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
