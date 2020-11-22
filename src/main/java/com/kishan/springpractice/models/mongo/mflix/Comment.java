package com.kishan.springpractice.models.mongo.mflix;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "comments")
public class Comment {
    @Id
    private String id;
    private String name;
    private String email;
    @Field("movie_id")
    private String movieId;
    private String text;
    private Date date;

    public Comment() {
    }

    public Comment(String id, String name, String email, String movieId, String text, Date date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.movieId = movieId;
        this.text = text;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
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
