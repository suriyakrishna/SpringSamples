package com.kishan.springpractice;

import com.kishan.springpractice.components.mongo.SpringMongoOperations;
import com.kishan.springpractice.models.mongo.mflix.Comment;
import com.kishan.springpractice.models.mongo.mflix.CommentResponse;
import com.kishan.springpractice.models.mongo.mflix.Movie;
import com.kishan.springpractice.models.mongo.mflix.MovieResponse;
import com.kishan.springpractice.services.mongo.MovieService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Test for Movie Service")
public class MovieServiceTests {
    @Mock
    private SpringMongoOperations springMongoOperations;

    private MovieService movieService;

    private Movie movie;

    private List<Movie> movies;

    private Comment comment;

    private List<Comment> comments;

    @BeforeAll
    void setUp() {
        initMocks(this);
        movie = new Movie();
        movie.setId("123");
        movie.setTitle("Hello");
        movie.setRuntime(100);
        movie.setYear(1995);
        movies = new ArrayList<>();
        movies.add(movie);

        comment = new Comment();
        comment.setEmail("ram@test.com");
        comment.setMovieId("123");
        comment.setId("12");
        comment.setText("Test Comment");
        comments = new ArrayList<>();
        comments.add(comment);
        movieService = new MovieService(springMongoOperations);
    }

    @Test
    @DisplayName("Movie Collection Count")
    void getCount() {
        long expected = 1;
        doReturn(expected).when(springMongoOperations).getMoviesCount();
        long actual = movieService.getCount();
        verify(springMongoOperations).getMoviesCount();
        assertThat(expected, is(actual));
    }

    @Test
    @DisplayName("Get Random movie should return Movie Object")
    void getRandomMovie() {
        doReturn(movie).when(springMongoOperations).findRandomMovie();
        Movie actual = movieService.getRandomMovie();
        verify(springMongoOperations).findRandomMovie();
        assertThat(movie, is(actual));
    }


    @Test
    @DisplayName("Should get Movie Responses")
    void getMovieResponsesByGenre() {
        doReturn(movies).when(springMongoOperations).findByGenre(any(String.class));
        List<MovieResponse> actual = movieService.getMoviesByGenre("Action");
        verify(springMongoOperations).findByGenre("Action");
        assertAll(
                () -> assertThat(movies.get(0).getTitle(), is(actual.get(0).getMovieName())),
                () -> assertThat(movies.get(0).getGenres(), is(actual.get(0).getGenres())),
                () -> assertThat(movies.get(0).getYear(), is(actual.get(0).getYear())),
                () -> assertThat(movies.get(0).getRuntime(), is(actual.get(0).getRuntime()))
        );
    }

    @Test
    @DisplayName("Should get Top 10 Movies for a given year")
    void getTopTen10MoviesByYear() {
        doReturn(movies).when(springMongoOperations).findTopTenMovieByYear(any(int.class));
        List<MovieResponse> actual = movieService.getTopTenMovieByYear(1995);
        verify(springMongoOperations).findTopTenMovieByYear(1995);
        assertAll(
                () -> assertThat(movies.get(0).getTitle(), is(actual.get(0).getMovieName())),
                () -> assertThat(movies.get(0).getGenres(), is(actual.get(0).getGenres())),
                () -> assertThat(movies.get(0).getYear(), is(actual.get(0).getYear())),
                () -> assertThat(movies.get(0).getRuntime(), is(actual.get(0).getRuntime()))
        );
    }

    @Test
    @DisplayName("Should Return Movie")
    void getMovieById() {
        Movie expected = movies.get(0);
        doReturn(expected).when(springMongoOperations).findMovieById(any(String.class));
        Movie actual = movieService.getMovieById("123");
        verify(springMongoOperations).findMovieById("123");
        assertThat(expected, is(actual));
    }

    @Test
    @DisplayName("Should Return Empty Comments when title not found")
    void getMovieCommentsByTitleNotExists() {
        doReturn(null).when(springMongoOperations).findMovieByTitle(any(String.class));
        List<CommentResponse> actual = movieService.getMovieCommentsByMovieTitle("hello");
        verify(springMongoOperations).findMovieByTitle("hello");
        assertTrue(actual.isEmpty());
    }

    @Test
    @DisplayName("Should return Comments when title found")
    void getMovieCommentsByTitleExists() {
        Comment expected = comments.get(0);
        doReturn(movies.get(0)).when(springMongoOperations).findMovieByTitle(any(String.class));
        doReturn(comments).when(springMongoOperations).findCommentsByMovieId(any(String.class));
        List<CommentResponse> actual = movieService.getMovieCommentsByMovieTitle("123");
        verify(springMongoOperations).findMovieByTitle("123");
        verify(springMongoOperations).findCommentsByMovieId("123");
        assertAll(
                () -> assertThat(expected.getDate(), is(actual.get(0).getDate())),
                () -> assertThat(expected.getEmail(), is(actual.get(0).getEmail())),
                () -> assertThat(expected.getName(), is(actual.get(0).getName())),
                () -> assertThat(expected.getText(), is(actual.get(0).getText()))
        );
    }

    @Test
    @DisplayName("Should return Comments when id found")
    void getMovieCommentsById() {
        doReturn(comments).when(springMongoOperations).findCommentsByMovieId(any(String.class));
        List<CommentResponse> actual = movieService.getMovieCommentsByMovieId("12345");
        verify(springMongoOperations).findCommentsByMovieId("12345");
        assertAll(
                () -> assertThat(comments.get(0).getDate(), is(actual.get(0).getDate())),
                () -> assertThat(comments.get(0).getEmail(), is(actual.get(0).getEmail())),
                () -> assertThat(comments.get(0).getName(), is(actual.get(0).getName())),
                () -> assertThat(comments.get(0).getText(), is(actual.get(0).getText()))
        );
    }



}

