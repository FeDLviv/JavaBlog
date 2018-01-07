package com.example.blog.controller;

import com.example.blog.config.ResourceNotFoundException;
import com.example.blog.config.RestAuthentication;
import com.example.blog.dto.NewUserDTO;
import com.example.blog.entity.User;
import com.example.blog.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/security")
public class SecurityController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    @ApiOperation(value = "Вхід користувача")
    public void login(@RequestBody NewUserDTO user) {
        User temp = userRepository.findByName(user.getName()).orElseThrow(() -> new ResourceNotFoundException());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(user.getPassword(), temp.getPassword())) {
            SecurityContextHolder.getContext().setAuthentication(new RestAuthentication(temp));
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @GetMapping("/logout")
    @ApiOperation(value = "Вихід користувача")
    public void logout() {
        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
    }

}
