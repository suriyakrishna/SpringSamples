package com.kishan.springpractice.models.mongo.mflix;

import java.util.Date;

public class CommentResponse {
    private String name;
    private String email;
    private String text;
    private Date date;

    public CommentResponse() {
    }

    public CommentResponse(String name, String email, String text, Date date) {
        this.name = name;
        this.email = email;
        this.text = text;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

