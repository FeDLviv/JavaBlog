package com.example.blog.controller;

import com.example.blog.model.Mark;
import com.example.blog.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mark")
public class MarkController {

    @Autowired
    private MarkRepository markRepository;

    @RequestMapping(name="/mark", method= RequestMethod.GET)
    public List<Mark> posts(){
        return markRepository.findAll();
    }

}
