package com.kishan.SpringPractice.repos;

import com.kishan.SpringPractice.models.mongo.mflix.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MoviesRepo extends MongoRepository<Movie, String> {
}
