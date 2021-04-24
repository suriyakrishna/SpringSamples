package com.kishan.springpractice.models.mongo.mflix;

public class Imdb {
    private Double rating;
    private Long votes;
    private Integer id;

    public Imdb() {
    }

    public Imdb(Double rating, Long votes, Integer id) {
        this.rating = rating;
        this.votes = votes;
        this.id = id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Long getVotes() {
        return votes;
    }

    public void setVotes(Long votes) {
        this.votes = votes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
