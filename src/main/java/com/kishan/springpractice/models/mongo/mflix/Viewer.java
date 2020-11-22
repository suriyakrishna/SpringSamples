package com.kishan.springpractice.models.mongo.mflix;

public class Viewer {
    private Double rating;
    private Long numReviews;
    private Integer meter;

    public Viewer() {
    }

    public Viewer(Double rating, Long numReviews, Integer meter) {
        this.rating = rating;
        this.numReviews = numReviews;
        this.meter = meter;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Long getNumReviews() {
        return numReviews;
    }

    public void setNumReviews(Long numReviews) {
        this.numReviews = numReviews;
    }

    public Integer getMeter() {
        return meter;
    }

    public void setMeter(Integer meter) {
        this.meter = meter;
    }

}
