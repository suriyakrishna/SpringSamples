package com.kishan.springpractice.repos;

import com.kishan.springpractice.models.mongo.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product, String> {
}
