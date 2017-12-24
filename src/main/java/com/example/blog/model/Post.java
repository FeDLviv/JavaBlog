package com.example.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="post")
@JsonIgnoreProperties({"marks", "comments"})
public class Post{

    @Id
    @Column(name = "id_post")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;

    @Column(name = "public", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date datePublic;

    @ManyToMany(mappedBy = "posts")
    private Set<Mark> marks;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

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
