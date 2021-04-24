package com.kishan.springpractice.controllers;

import com.kishan.springpractice.models.mysql.ActorModel;
import com.kishan.springpractice.services.mysql.ActorDAOImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/")
    @ApiOperation(value = "Get all Actors", notes = "Returns all Actors", response = ActorModel[].class)
    public List<ActorModel> getAllActors() {
        return actorDAO.getAllActors();
    }

    @GetMapping("/actor/id/{id}")
    @ApiOperation(value = "Get actor by id", notes = "Returns Actor for given id", response = ActorModel.class)
    public ActorModel getActor(@ApiParam(value = "Id of the actor", required = true, example = "123") @PathVariable(name = "id") int id) {
        return actorDAO.getActor(id);
    }

    @GetMapping("/actor/firstName/{firstName}")
    @ApiOperation(value = "Get actors by firstName", notes = "Returns all Actor for a given firstName", response = ActorModel[].class)
    public List<ActorModel> getActorByFirstName(@ApiParam(value = "firstName of the Actor", required = true, example = "PENELOPE") @PathVariable(name = "firstName") String name) {
        return actorDAO.getActors(name);
    }

    @GetMapping("/count")
    @ApiOperation(value = "Count of Actors", notes = "Returns count of actor", response = String.class)
    public String getCount() {
        return "Total number of actors is " + actorDAO.getCount();
    }

}
