package com.kishan.springpractice.controllers;

import com.kishan.springpractice.models.mongo.mflix.CommentResponse;
import com.kishan.springpractice.models.mongo.mflix.Movie;
import com.kishan.springpractice.models.mongo.mflix.MovieResponse;
import com.kishan.springpractice.services.mongo.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public long getCount() {
        return movieService.getCount();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Movie getMovieById(@PathVariable(name = "id") String id) {
        return movieService.getMovieById(id);
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public Movie getRandomMovie() {
        return movieService.getRandomMovie();
    }

    @RequestMapping(value = "/genre/{genre}", method = RequestMethod.GET)
    public List<MovieResponse> getByGenre(@PathVariable(name = "genre") String genre) {
        return movieService.getMoviesByGenre(genre);
    }

    @RequestMapping(value = "/top10/year/{year}", method = RequestMethod.GET)
    public List<MovieResponse> getTopTenByGenre(@PathVariable(name = "year") int year) {
        return movieService.getTopTenMovieByYear(year);
    }

    @GetMapping(value = "/comments/movieId/{movieId}")
    public List<CommentResponse> getCommentsByMovieId(@PathVariable(name = "movieId") String movieId) {
        return movieService.getMovieCommentsByMovieId(movieId);
    }

    @GetMapping(value = "/comments/movieTitle/{movieTitle}")
    public List<CommentResponse> getCommentsByMovieTitle(@PathVariable(name = "movieTitle") String movieTitle) {
        return movieService.getMovieCommentsByMovieTitle(movieTitle);
    }
}

