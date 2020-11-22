package com.kishan.springpractice.services.mongo;

import com.kishan.springpractice.components.mongo.SpringMongoOperations;
import com.kishan.springpractice.models.mongo.mflix.Comment;
import com.kishan.springpractice.models.mongo.mflix.CommentResponse;
import com.kishan.springpractice.models.mongo.mflix.Movie;
import com.kishan.springpractice.models.mongo.mflix.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MovieService {
    private SpringMongoOperations springMongoOperations;

    @Autowired
    public MovieService(SpringMongoOperations springMongoOperations) {
        this.springMongoOperations = springMongoOperations;
    }

    public long getCount() {
        return springMongoOperations.getMoviesCount();
    }

    public Movie getRandomMovie() {
        return springMongoOperations.findRandomMovie();
    }

    public List<MovieResponse> getMoviesByGenre(String genre) {
        List<MovieResponse> responses = new ArrayList<>();
        List<Movie> movies = springMongoOperations.findByGenre(genre);
        for (Movie movie : movies) {
            responses.add(new MovieResponse(movie.getTitle(), movie.getGenres(), movie.getYear(), movie.getRuntime()));
        }
        return responses;
    }

    public List<MovieResponse> getTopTenMovieByYear(int year) {
        List<MovieResponse> responses = new ArrayList<>();
        List<Movie> movies = springMongoOperations.findTopTenMovieByYear(year);
        for (Movie movie : movies) {
            responses.add(new MovieResponse(movie.getTitle(), movie.getGenres(), movie.getYear(), movie.getRuntime()));
        }
        return responses;
    }

    public Movie getMovieById(String id) {
        return springMongoOperations.findMovieById(id);
    }

    public List<CommentResponse> getMovieCommentsByMovieId(String id) {
        List<Comment> mongoComments = springMongoOperations.findCommentsByMovieId(id);
        List<CommentResponse> comments = new ArrayList<>();
        for (Comment comment : mongoComments) {
            comments.add(new CommentResponse(comment.getName(), comment.getEmail(), comment.getText(), comment.getDate()));
        }
        return comments;
    }

    public List<CommentResponse> getMovieCommentsByMovieTitle(String title) {
        Movie movie = springMongoOperations.findMovieByTitle(title);
        if (movie == null) {
            return Collections.emptyList();
        }
        List<Comment> mongoComments = springMongoOperations.findCommentsByMovieId(movie.getId());
        List<CommentResponse> comments = new ArrayList<>();
        for (Comment comment : mongoComments) {
            comments.add(new CommentResponse(comment.getName(), comment.getEmail(), comment.getText(), comment.getDate()));
        }
        return comments;
    }

}
