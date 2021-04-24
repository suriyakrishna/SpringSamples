package com.kishan.springpractice.repos;

import com.kishan.springpractice.models.mongo.Employee;
import com.kishan.springpractice.models.mongo.mflix.Comment;
import com.kishan.springpractice.models.mongo.mflix.CommentResponse;
import com.kishan.springpractice.models.mongo.mflix.Movie;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class SpringMongoOperations {
    private MongoOperations mongoOperations;

    @Autowired
    public SpringMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public long getCount() {
        Query query = new Query();
        return mongoOperations.count(query, Employee.class);
    }

    public List<Employee> findEmployee(String id, String firstName, String lastName, String age) {
        Query query = new Query();
        if (id != null)
            query.addCriteria(Criteria.where("_id").is(id));
        if (firstName != null)
            query.addCriteria(Criteria.where("firstName").is(firstName));
        if (lastName != null)
            query.addCriteria(Criteria.where("lastName").is(lastName));
        if (age != null)
            query.addCriteria(Criteria.where("age").is(Integer.parseInt(age)));
        return mongoOperations.find(query, Employee.class);
    }

    public List<Employee> findByFirstName(String firstName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").is(firstName));
        return mongoOperations.find(query, Employee.class);
    }

    public void insertRecord(Employee employee) {
        mongoOperations.insert(employee);
    }

    public void updateRecord(Employee employee, String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update = new Update();
        if (employee.getFirstName() != null)
            update.set("firstName", employee.getFirstName());
        if (employee.getLastName() != null)
            update.set("lastName", employee.getLastName());
        if (employee.getAge() != null)
            update.set("age", employee.getAge());
        mongoOperations.updateFirst(query, update, Employee.class);
    }

    public long getMoviesCount() {
        Query query = new Query();
        return mongoOperations.count(query, Movie.class);
    }

    public Movie findRandomMovie() {
        Query query = new Query();
        query.addCriteria(Criteria.where("type").is("movie"));
        return mongoOperations.findOne(query, Movie.class);
    }

    public List<Movie> findByGenre(String genre) {
        Query query = new Query();
        query.addCriteria(Criteria.where("genres").all(Collections.singletonList(genre)));
        query.limit(10);
        return mongoOperations.find(query, Movie.class);
    }

    public List<Movie> findTopTenMovieByYear(int year) {
        Query query = new Query();
        query.addCriteria(Criteria.where("year").is(year));
        query.addCriteria(Criteria.where("runtime").exists(true));
        query.with(Sort.by(Sort.Direction.ASC, "runtime"));
        query.limit(10);
        return mongoOperations.find(query, Movie.class);
    }

    public Movie findMovieById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(new ObjectId(id)));
        return mongoOperations.findOne(query, Movie.class);
    }

    public List<Comment> findCommentsByMovieId(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("movie_id").is(new ObjectId(id)));
        List<CommentResponse> comments = new ArrayList<>();
        return mongoOperations.find(query, Comment.class);
    }

    public Movie findMovieByTitle(String title) {
        Query query = new Query();
        query.addCriteria(Criteria.where("title").is(title));
        return mongoOperations.findOne(query, Movie.class);
    }


}
