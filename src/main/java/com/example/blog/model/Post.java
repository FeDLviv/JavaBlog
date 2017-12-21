package com.example.blog.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Post {

    @Id
    //@Column(name = "idPost")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String text;
    @Column(name = "public")
    private Date datePublic;

    @ManyToMany
    @JoinTable(name="postMark", joinColumns = @JoinColumn(name="idPost"), inverseJoinColumns = @JoinColumn(name="idMark"))
    private Set<Mark> marks;

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
