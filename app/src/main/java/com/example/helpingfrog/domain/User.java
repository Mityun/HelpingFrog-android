package com.example.helpingfrog.domain;

import java.util.Objects;

public class User {

    private int id;

    private String login;

    private String password;

    private int passwordHash;

    private int totalHours;

    public User(int id, String login, String password, int totalHours) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.totalHours = totalHours;
        this.passwordHash = password.hashCode();
    }

    public User(String login, String password, int totalHours) {
        this.login = login;
        this.password = password;
        this.totalHours = totalHours;
    }

    public void Login(int id, String login) {
        this.id = id;
        this.login = login;
    }

    public void Login(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public String getPassword() {
        return password;
    }

    public int getPasswordHash() {
        return passwordHash;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + this.password.hashCode() + '\'' +
                ", totalHours='" + totalHours + '\'' +
                '}';
    }
}
