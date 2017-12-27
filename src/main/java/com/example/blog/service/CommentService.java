package com.example.blog.service;

import com.example.blog.dto.CommentDTO;
import com.example.blog.dto.NewCommentDTO;
import com.example.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void createComment(NewCommentDTO comment) {
        commentRepository.createComment(comment.getText(), comment.getIdPost(), comment.getIdUser());
    }

    public List<CommentDTO> readComments() {
        return commentRepository.getList();
    }

    public CommentDTO readComment(int id) {
        return commentRepository.getById(id);
    }

    public int updateComment(CommentDTO comment, int id) {
        return commentRepository.updateComment(id, comment.getText(), comment.getDatePublic());
    }

    public void deleteComments() {
        commentRepository.deleteAll();
    }


    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }
}

