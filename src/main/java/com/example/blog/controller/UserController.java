package com.example.blog.controller;

import com.example.blog.model.User;
import com.example.blog.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(description="Операції повязані з користувачами")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method= RequestMethod.GET)
    @ApiOperation(value = "Отримання всіх користувачів")
    public List<User> readUsers(){
        return userRepository.findAll();
    }
}
