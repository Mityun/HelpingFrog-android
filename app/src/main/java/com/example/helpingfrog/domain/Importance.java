package com.example.helpingfrog.domain;

public class Importance {

    private int id;

    private String name;

    public Importance(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Importance(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Importance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
