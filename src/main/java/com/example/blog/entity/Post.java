package com.example.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "post")
@JsonIgnoreProperties({"marks", "comments"})
@Data
public class Post {

    @Id
    @Column(name = "id_post")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;

    @Column(name = "public", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePublic;

    @ManyToMany
    @JoinTable(name = "post_mark", joinColumns = @JoinColumn(name = "id_post"), inverseJoinColumns = @JoinColumn(name = "id_mark"))
    private List<Mark> marks;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", datePublic=" + datePublic +
                '}';
    }

}
