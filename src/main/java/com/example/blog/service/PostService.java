package com.example.blog.service;

import com.example.blog.mapper.PostMapper;
import com.example.blog.dto.NewPostDTO;
import com.example.blog.dto.PostDTO;
import com.example.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostDTO createPost(NewPostDTO post) {
        return PostMapper.INSTANCE.PostToPostDTO(postRepository.save(PostMapper.INSTANCE.NewPostDTOToPost(post)));
    }

    public List<PostDTO> readPosts() {
        return postRepository.getList();
    }

    public PostDTO readPost(int id) {
        return postRepository.getById(id);
    }

    public int updatePost(PostDTO post, int id) {
        return postRepository.updatePost(id, post.getTitle(), post.getText(), post.getDatePublic());
        //return postRepository.save(post);
    }

    public void deletePosts() {
        postRepository.deleteAll();
    }

    public void deletePost(int id) {
        postRepository.deleteById(id);
    }

}
