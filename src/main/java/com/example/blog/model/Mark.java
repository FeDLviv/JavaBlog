package com.example.blog.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Mark {

    @Id
    @Column(name = "id_mark")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
