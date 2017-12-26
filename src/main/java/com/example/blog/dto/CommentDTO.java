package com.example.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class CommentDTO {

    private int id;

    private String text;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date datePublic;

    private String user;

}
