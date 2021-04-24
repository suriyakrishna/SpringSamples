package com.kishan.springpractice.repos;

import com.kishan.springpractice.models.mongo.mflix.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MoviesRepo extends MongoRepository<Movie, String> {
}
