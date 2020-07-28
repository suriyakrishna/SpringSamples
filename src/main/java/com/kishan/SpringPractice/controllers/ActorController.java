package com.kishan.SpringPractice.controllers;

import com.kishan.SpringPractice.models.actor.ActorDAOImpl;
import com.kishan.SpringPractice.models.actor.ActorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
* RestController to control the action provided by the users
* */

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    ActorDAOImpl actorDAO;

    @RequestMapping("/")
    public List<ActorModel> getAllActors() {
        return actorDAO.getAllActors();
    }

    @RequestMapping("/actor")
    public ActorModel getActor(@RequestParam(name = "id") int id) {
        return actorDAO.getActor(id);
    }

    @RequestMapping("/actorFirstName")
    public List<ActorModel> getActorByFirstName(@RequestParam(name = "first_name") String name) {
        return actorDAO.getActors(name);
    }


    @RequestMapping("/actorsCount")
    public String getCount() {
        return "Total number of actors is " + actorDAO.getCount();
    }


}
