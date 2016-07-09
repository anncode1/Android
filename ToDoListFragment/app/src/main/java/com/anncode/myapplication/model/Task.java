package com.anncode.myapplication.model;

/**
 * Created by anahisalgado on 09/07/16.
 */
public class Task {
    private String name;
    private String image;

    public Task(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
