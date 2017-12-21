package com.example.blog.model;

import javax.persistence.*;
import java.util.Date;

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

    public Post(){}

    public Post(int id, String title, String text, Date datePublic){
        this.id = id;
        this.title  = title;
        this.text = text;
        this.datePublic = datePublic;
    }

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

    public String toString() {
        return "Post {id="+id+", title="+title+", text="+text+", datePublic="+datePublic+"}";
    }
}
