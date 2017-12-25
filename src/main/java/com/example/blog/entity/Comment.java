package com.example.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="comment")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_comment")
    private int id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;

    @Column(name = "public", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date datePublic;

    @OneToOne
    @JoinColumn(name="id_user")
    private User user;

    @OneToOne
    @JoinColumn(name="id_post")
    private Post post;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", datePublic=" + datePublic +
                ", user=" + user +
                ", post=" + post +
                '}';
    }

}
