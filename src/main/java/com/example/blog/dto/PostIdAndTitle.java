package com.example.blog.dto;

public class PostIdAndTitle {

    private int id;
    private String title;

    public PostIdAndTitle(int id, String title){
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
