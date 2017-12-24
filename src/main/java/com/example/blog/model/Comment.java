package com.example.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="comment")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDatePublic() {
        return datePublic;
    }

    public void setDatePublic(Date datePublic) {
        this.datePublic = datePublic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

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
