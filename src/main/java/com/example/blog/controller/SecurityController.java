package com.example.blog.controller;

import com.example.blog.config.RestAuthentication;
import com.example.blog.dto.NewUserDTO;
import com.example.blog.entity.User;
import com.example.blog.exception.AuthenticationException;
import com.example.blog.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/security")
@Api(description = "Операції повязані з авторизацією/деавторизацією")
public class SecurityController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    @ApiOperation(value = "Вхід користувача")
    public void login(@RequestBody NewUserDTO user) {
        User temp = userRepository.findByName(user.getName()).orElseThrow(() -> new AuthenticationException());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(user.getPassword(), temp.getPassword())) {
            SecurityContextHolder.getContext().setAuthentication(new RestAuthentication(temp));
        } else {
            throw new AuthenticationException();
        }
    }

    @GetMapping("/logout")
    @ApiOperation(value = "Вихід користувача")
    public void logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        //SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
    }

}
