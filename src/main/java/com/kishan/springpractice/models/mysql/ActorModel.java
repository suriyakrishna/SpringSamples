package com.kishan.springpractice.models.mysql;

/*
 * ActorModel for the Database Object
 * */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

@ApiModel(description = "Actor Model")
public class ActorModel {

    @Id
    @ApiModelProperty(value = "Actor's id")
    private int id;
    @ApiModelProperty(value = "Actor's First Name")
    private String firstName;
    @ApiModelProperty(value = "Actor's Last Name")
    private String lastName;

    public ActorModel() {

    }

    public ActorModel(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
