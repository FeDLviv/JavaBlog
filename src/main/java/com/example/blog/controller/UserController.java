package com.example.blog.controller;

import com.example.blog.dto.NewUserDTO;
import com.example.blog.dto.UserDTO;
import com.example.blog.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@Api(description = "Операції повязані з користувачами")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ApiOperation(value = "Додавання нового користувача")
    public UserDTO createPost(@RequestBody NewUserDTO user) {
        return userService.createUser(user);
    }

    @GetMapping
    @ApiOperation(value = "Отримання всіх користувачів, сотрованих по назві")
    public List<UserDTO> readUsers() {
        return userService.readUsers();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Отримання користувача по ID")
    public UserDTO readUser(@PathVariable int id) {
        return userService.readUser(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Оновлення користувача по ID")
    public int updateUser(@RequestBody UserDTO post, @PathVariable int id) {
        return userService.updateUser(post, id);
    }

    @DeleteMapping
    @ApiOperation(value = "Видалення всіх користувачів")
    public void deleteUsers() {
        userService.deleteUsers();
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Видалення користувача по ID")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

}
