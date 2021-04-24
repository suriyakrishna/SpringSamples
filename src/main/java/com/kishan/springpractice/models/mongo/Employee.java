package com.kishan.springpractice.models.mongo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiResponse;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employee")
@ApiModel(description = "Employee Model Definition")
public class Employee {

    @Id
    @ApiModelProperty(value = "Employee's id")
    private String id;
    @ApiModelProperty(value = "Employee's firstName")
    private String firstName;
    @ApiModelProperty(value = "Employee's lastName")
    private String lastName;
    @ApiModelProperty(value = "Employee's age")
    private Integer age;

    public Employee() {

    }

    public Employee(String id, String firstName, String lastName, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
