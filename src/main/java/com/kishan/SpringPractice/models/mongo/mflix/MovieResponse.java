package com.kishan.SpringPractice.models.mongo.mflix;

import java.util.ArrayList;

public class MovieResponse {
    private String movieName;
    private ArrayList<String> genres;
    private Integer year;
    private Integer runtime;

    public MovieResponse() {
    }

    public MovieResponse(String movieName, ArrayList<String> genres, Integer year, Integer runtime) {
        this.movieName = movieName;
        this.genres = genres;
        this.year = year;
        this.runtime = runtime;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }
}
