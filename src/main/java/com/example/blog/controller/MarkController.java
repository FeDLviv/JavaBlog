package com.example.blog.controller;

import com.example.blog.entity.Mark;
import com.example.blog.repository.MarkRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mark")
@Api(description="Операції повязані з мітками до постів")
public class MarkController {

    @Autowired
    private MarkRepository markRepository;

    @GetMapping
    @ApiOperation(value = "Отримання всіх міток")
    public List<Mark> readPosts(){
        return markRepository.findAll();
    }

}
