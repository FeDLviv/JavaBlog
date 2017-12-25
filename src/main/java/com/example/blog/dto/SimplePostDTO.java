package com.example.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class SimplePostDTO {

    private int id;

    private String title;

    private String text;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date datePublic;

}
