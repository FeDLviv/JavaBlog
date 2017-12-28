package com.example.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCommentDTO {

    private int id;

    private String text;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date datePublic;

}
