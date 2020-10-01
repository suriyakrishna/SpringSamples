package com.kishan.SpringPractice.services.mysql;

import com.kishan.SpringPractice.models.mysql.ActorModel;

import java.util.List;

/*
 * Database Access Object - Interface
 * */

public interface ActorDAO {
    public int getCount();

    public ActorModel getActor(int id);

    public List<ActorModel> getActors(String firstName);

    public List<ActorModel> getAllActors();
}
