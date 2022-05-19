package com.example.helpingfrog.domain;

import java.util.List;

public class Task {

    private int id;

    private String name;

    private Author author;

    private Importance importance;

    private List<Comment> commentList;

    public Task(int id, String name, Author author, Importance importance, List<Comment> commentList) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.importance = importance;
        this.commentList = commentList;
    }

    public Task(String name, Author author, Importance importance, List<Comment> commentList) {
        this.name = name;
        this.author = author;
        this.importance = importance;
        this.commentList = commentList;
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

    public List<Comment> getCommentList() {
        return commentList;
    }
}

