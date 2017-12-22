package com.example.blog.controller;

import com.example.blog.model.Comment;
import com.example.blog.repository.CommentRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
@Api(description="Операції повязані з коментарями до постів")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping(method= RequestMethod.GET)
    @ApiOperation(value = "Отримання всіх коментарів")
    public List<Comment> readComments(){
        return commentRepository.findAll();
    }

}
