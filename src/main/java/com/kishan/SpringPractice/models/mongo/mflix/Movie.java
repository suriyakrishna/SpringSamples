package com.kishan.SpringPractice.models.mongo.mflix;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

@Document(collection = "movies")
public class Movie {
    @Id
    private String id;
    private String plot;
    private ArrayList<String> genres;
    private Integer runtime;
    private ArrayList<String> cast;
    private Integer num_mflix_comments;
    private String title;
    private String fullplot;
    private ArrayList<String> countries;
    private Date released;
    private ArrayList<String> directors;
    private String rated;
    private Award awards;
    private String lastupdated;
    private Integer year;
    private Imdb imdb;
    private String type;
    private Tomatoes tomatoes;
    private Integer metacritic;
    private String poster;
    private ArrayList<String> writers;

    public Movie() {
    }

    public Movie(String id, String plot, ArrayList<String> genres, Integer runtime, ArrayList<String> cast, Integer num_mflix_comments, String title, String fullplot, ArrayList<String> countries, Date released, ArrayList<String> directors, String rated, Award awards, String lastupdated, Integer year, Imdb imdb, String type, Tomatoes tomatoes, Integer metacritic, String poster, ArrayList<String> writers) {
        this.id = id;
        this.plot = plot;
        this.genres = genres;
        this.runtime = runtime;
        this.cast = cast;
        this.num_mflix_comments = num_mflix_comments;
        this.title = title;
        this.fullplot = fullplot;
        this.countries = countries;
        this.released = released;
        this.directors = directors;
        this.rated = rated;
        this.awards = awards;
        this.lastupdated = lastupdated;
        this.year = year;
        this.imdb = imdb;
        this.type = type;
        this.tomatoes = tomatoes;
        this.metacritic = metacritic;
        this.poster = poster;
        this.writers = writers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }

    public Integer getNum_mflix_comments() {
        return num_mflix_comments;
    }

    public void setNum_mflix_comments(Integer num_mflix_comments) {
        this.num_mflix_comments = num_mflix_comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullplot() {
        return fullplot;
    }

    public void setFullplot(String fullplot) {
        this.fullplot = fullplot;
    }

    public ArrayList<String> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<String> countries) {
        this.countries = countries;
    }

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    public ArrayList<String> getDirectors() {
        return directors;
    }

    public void setDirectors(ArrayList<String> directors) {
        this.directors = directors;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public Award getAwards() {
        return awards;
    }

    public void setAwards(Award awards) {
        this.awards = awards;
    }

    public String getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(String lastupdated) {
        this.lastupdated = lastupdated;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Imdb getImdb() {
        return imdb;
    }

    public void setImdb(Imdb imdb) {
        this.imdb = imdb;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Tomatoes getTomatoes() {
        return tomatoes;
    }

    public void setTomatoes(Tomatoes tomatoes) {
        this.tomatoes = tomatoes;
    }

    public Integer getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(Integer metacritic) {
        this.metacritic = metacritic;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public ArrayList<String> getWriters() {
        return writers;
    }

    public void setWriters(ArrayList<String> writers) {
        this.writers = writers;
    }
}
