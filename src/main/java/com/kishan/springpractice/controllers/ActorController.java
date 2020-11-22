package com.kishan.SpringPractice.controllers;

import com.kishan.SpringPractice.services.mysql.ActorDAOImpl;
import com.kishan.SpringPractice.models.mysql.ActorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/actor/id/{id}")
    public ActorModel getActor(@PathVariable(name = "id") int id) {
        return actorDAO.getActor(id);
    }

    @RequestMapping("/actor/firstName/{firstName}")
    public List<ActorModel> getActorByFirstName(@PathVariable(name = "firstName") String name) {
        return actorDAO.getActors(name);
    }


    @RequestMapping("/count")
    public String getCount() {
        return "Total number of actors is " + actorDAO.getCount();
    }


}
