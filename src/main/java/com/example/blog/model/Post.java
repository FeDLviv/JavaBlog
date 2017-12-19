package com.example.blog.model;

public class Post {

    private int id;
    private String title;
    private String text;

    public Post(){}

    public Post(int id, String title, String text){
        this.id = id;
        this.title  = title;
        this.text = text;
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

    public String toString() {
        return "Post {id="+id+", title="+title+", text="+text+"}";
    }
}
