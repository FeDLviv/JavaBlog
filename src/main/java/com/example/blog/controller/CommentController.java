package com.example.blog.controller;

import com.example.blog.dto.CommentDTO;
import com.example.blog.dto.NewCommentDTO;
import com.example.blog.dto.UpdateCommentDTO;
import com.example.blog.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@Api(description = "Операції повязані з коментарями до постів")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    @ApiOperation(value = "Додавання нового коментаря")
    public void createComment(@RequestBody NewCommentDTO comment) {
        commentService.createComment(comment);
    }

    @GetMapping
    @ApiOperation(value = "Отримання всіх коментарів, сортованих по даті публікації")
    public List<CommentDTO> readComments() {
        return commentService.readComments();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Отримання коментаря по ID")
    public CommentDTO readComment(@PathVariable int id) {
        return commentService.readComment(id);
    }

    @GetMapping(value = "posts/{id}")
    @ApiOperation(value = "Отримання всіх коментарів, для конкретного поста, ID поста задається")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "int", paramType = "query",
                    value = "Номер сторінки, яку відобразити (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "int", paramType = "query",
                    value = "Кількість записів на сторінці."),
            @ApiImplicitParam(name = "sort", dataType = "string", allowMultiple = true,
                    paramType = "query",
                    value = "Критерій сортування у форматі: property(,asc|desc). За замовчуванням, йде сортування по зростанню. Є підтримка для декількох параметрів сортування.")
    })
    public List<CommentDTO> readCommentsByPostId(@PathVariable int id, @ApiIgnore Pageable pageable) {
        return commentService.readCommentsByPostId(id, pageable).getContent();
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Оновлення коментаря по ID")
    public int updateComment(@RequestBody UpdateCommentDTO comment, @PathVariable int id) {
        return commentService.updateComment(comment, id);
    }

    @DeleteMapping
    @ApiOperation(value = "Видалення всіх коментарів")
    public void deleteComments() {
        commentService.deleteComments();
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Видалення коментаря по ID")
    public void deleteComment(@PathVariable int id) {
        commentService.deleteComment(id);
    }

}
