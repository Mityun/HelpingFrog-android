package com.example.helpingfrog.domain;

public class State {

    private String name; // название
    private String capital;  // столица
    private int flagResource; // ресурс флага

    public State(int flag){
        this.flagResource=flag;
    }

    public int getFlagResource() {
        return this.flagResource;
    }

    public void setFlagResource(int flagResource) {
        this.flagResource = flagResource;
    }
}