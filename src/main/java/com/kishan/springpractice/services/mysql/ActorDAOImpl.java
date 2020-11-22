package com.kishan.SpringPractice.services.mysql;

import com.kishan.SpringPractice.models.mysql.ActorMapper;
import com.kishan.SpringPractice.models.mysql.ActorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;


/*
 * Database Access Object - Implementation
 * */

@Component
public class ActorDAOImpl implements ActorDAO {
    private JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_ACTOR = "SELECT * FROM actor WHERE actor_id = ?";
    private final String SQL_GET_COUNT = "SELECT COUNT(*) FROM actor";
    private final String SQL_GET_ACTORS_BY_FIRST_NAME = "SELECT * FROM actor WHERE first_name = ?";
    private final String SQL_GET_ALL = "SELECT * FROM actor";

    @Autowired
    public ActorDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getCount() {
        return jdbcTemplate.queryForObject(SQL_GET_COUNT, Integer.class);
    }

    @Override
    public List<ActorModel> getAllActors() {
        return jdbcTemplate.query(SQL_GET_ALL, new ActorMapper());
    }

    @Override
    public List<ActorModel> getActors(String firstName) {
        return jdbcTemplate.query(SQL_GET_ACTORS_BY_FIRST_NAME, new Object[]{firstName}, new ActorMapper());
    }

    @Override
    public ActorModel getActor(int id) {
        return jdbcTemplate.queryForObject(SQL_FIND_ACTOR, new Object[]{id}, new ActorMapper());
    }
}
