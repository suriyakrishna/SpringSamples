package com.kishan.SpringPractice.models.actor;

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
