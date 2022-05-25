package com.example.helpingfrog.domain;

import java.io.Serializable;
import java.util.List;

public class Task implements Serializable {

    private int id;

    private String name;

    private Author author;

    private Importance importance;


    public Task(int id, String name, Author author, Importance importance) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.importance = importance;
    }

    public Task(String name, Author author, Importance importance) {
        this.name = name;
        this.author = author;
        this.importance = importance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public Importance getImportance() {
        return importance;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", importance=" + importance +
                '}';
    }
}

