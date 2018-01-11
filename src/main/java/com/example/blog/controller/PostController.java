package com.example.blog.controller;

import com.example.blog.dto.MarkDTO;
import com.example.blog.dto.NewPostDTO;
import com.example.blog.dto.PostDTO;
import com.example.blog.service.PostService;
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
@RequestMapping("/api/v1/posts")
@Api(description = "Операції повязані з постами")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    @ApiOperation(value = "Додавання нового поста")
    public PostDTO createPost(@RequestBody NewPostDTO post) {
        return postService.createPost(post);
    }

    @PostMapping(value = "/{idPost}/marks/{idMark}")
    @ApiOperation(value = "Додавання мітки до поста, ID поста та мітки задаються")
    public void createMarkToPost(@PathVariable int idPost, @PathVariable int idMark) {
        postService.createMarkToPost(idPost, idMark);
    }

    @GetMapping
    @ApiOperation(value = "Отримання всіх постів, з коротким текстом")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "int", paramType = "query",
                    value = "Номер сторінки, яку відобразити (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "int", paramType = "query",
                    value = "Кількість записів на сторінці."),
            @ApiImplicitParam(name = "sort", dataType = "string", allowMultiple = true,
                    paramType = "query",
                    value = "Критерій сортування у форматі: property(,asc|desc). За замовчуванням, йде сортування по зростанню. Є підтримка для декількох параметрів сортування.")
    })
    public List<PostDTO> readPosts(@ApiIgnore Pageable pagination) {
        return postService.readPosts(pagination).getContent();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Отримання поста по ID")
    public PostDTO readPost(@PathVariable int id) {
        return postService.readPost(id);
    }

    @GetMapping(value = "/{id}/marks")
    @ApiOperation(value = "Отримання міток для статті, ID статті задається")
    public List<MarkDTO> readMarksByPostId(@PathVariable int id) {
        return postService.readMarksByPostId(id);
    }

    @GetMapping(value = "marks/{id}")
    @ApiOperation(value = "Отримання всіх постів, з конкретною міткою, ID мітки задається")
    public List<PostDTO> readPostsByMarkId(@PathVariable int id) {
        return postService.readPostByMarkId(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Оновлення поста по ID")
    public int updatePost(@RequestBody PostDTO post, @PathVariable int id) {
        return postService.updatePost(post, id);
    }

    @DeleteMapping
    @ApiOperation(value = "Видалення всіх постів")
    public void deletePosts() {
        postService.deletePosts();
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Видалення поста по ID")
    public void deletePost(@PathVariable int id) {
        postService.deletePost(id);
    }

    @DeleteMapping(value = "/{idPost}/marks{idMark}")
    @ApiOperation(value = "Видалення мітки з поста, ID поста та мітки задаються")
    public void deleteMarkFromPost(@PathVariable int idPost, @PathVariable int idMark) {
        postService.deleteMarkFromPost(idPost, idMark);
    }

}
