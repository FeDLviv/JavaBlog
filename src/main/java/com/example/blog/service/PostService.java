package com.example.blog.service;

import com.example.blog.dto.MarkDTO;
import com.example.blog.dto.NewPostDTO;
import com.example.blog.dto.PostDTO;
import com.example.blog.entity.Mark;
import com.example.blog.entity.Post;
import com.example.blog.mapper.MarkMapper;
import com.example.blog.mapper.PostMapper;
import com.example.blog.repository.MarkRepository;
import com.example.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private MarkRepository markRepository;

    public PostDTO createPost(NewPostDTO post) {
        return PostMapper.INSTANCE.PostToPostDTO(postRepository.save(PostMapper.INSTANCE.NewPostDTOToPost(post)));
    }

    public void createMarkToPost(int idPost, int idMark) {
        Post post = postRepository.findById(idPost).get();
        Mark mark = markRepository.findById(idMark).get();
        post.getMarks().add(mark);
        postRepository.save(post);
    }

    public Page<PostDTO> readPosts(Pageable pagination) {
        return postRepository.getList(pagination);
    }

    public PostDTO readPost(int id) {
        return postRepository.getById(id);
    }

    public List<MarkDTO> readMarksByPostId(int id) {
        Post temp = postRepository.findById(id).get();
        return MarkMapper.INSTANCE.MarkToMarkDTO(temp.getMarks());
    }

    public List<PostDTO> readPostByMarkId(int id) {
        return postRepository.getListByMarkId(id);
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

    public void deleteMarkFromPost(int idPost, int idMark) {
        Post post = postRepository.findById(idPost).get();
        Mark mark = markRepository.findById(idMark).get();
        post.getMarks().remove(mark);
        postRepository.save(post);
    }
}
