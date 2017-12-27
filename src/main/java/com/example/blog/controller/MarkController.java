package com.example.blog.controller;

import com.example.blog.dto.MarkDTO;
import com.example.blog.dto.NewMarkDTO;
import com.example.blog.service.MarkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mark")
@Api(description = "Операції повязані з мітками до постів")
public class MarkController {

    @Autowired
    private MarkService markService;

    @PostMapping
    @ApiOperation(value = "Додавання нової мітки")
    public MarkDTO createMark(@RequestBody NewMarkDTO mark) {
        return markService.createMark(mark);
    }

    @GetMapping
    @ApiOperation(value = "Отримання всіх міток, сортованих по назві")
    public List<MarkDTO> readMarks() {
        return markService.readMarks();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Отримання мітки по ID")
    public MarkDTO readMark(@PathVariable int id) {
        return markService.readMark(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Оновлення мітки по ID")
    public int updateMark(@RequestBody MarkDTO post, @PathVariable int id) {
        return markService.updateMark(post, id);
    }

    @DeleteMapping
    @ApiOperation(value = "Видалення всіх міток")
    public void deleteMarks() {
        markService.deleteMarks();
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Видалення мітки по ID")
    public void deleteЬфкл(@PathVariable int id) {
        markService.deleteMark(id);
    }

}
