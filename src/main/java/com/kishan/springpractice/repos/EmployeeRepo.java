package com.kishan.springpractice.repos;

import com.kishan.springpractice.models.mongo.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository<Employee, String> {
}
