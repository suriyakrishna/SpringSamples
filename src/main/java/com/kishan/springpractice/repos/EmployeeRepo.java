package com.kishan.SpringPractice.repos;

import com.kishan.SpringPractice.models.mongo.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository<Employee, String> {
}
