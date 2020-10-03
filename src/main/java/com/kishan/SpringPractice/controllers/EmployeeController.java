package com.kishan.SpringPractice.controllers;

import com.kishan.SpringPractice.models.mongo.Employee;
import com.kishan.SpringPractice.services.mongo.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public long getCount() {
        return employeeService.getCount();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Employee> getById(@RequestParam(name = "id", required = false) String id,
                                  @RequestParam(name = "firstName", required = false) String firstName,
                                  @RequestParam(name = "lastName", required = false) String lastName,
                                  @RequestParam(name = "age", required = false) String age) {
        return employeeService.findEmployee(id, firstName, lastName, age);
    }

    @RequestMapping(value = "/firstName/{firstName}", method = RequestMethod.GET)
    public List<Employee> getByfirstName(@PathVariable(name = "firstName", required = true) String firstName) {
        return employeeService.getByFirstName(firstName);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void insertEmployee(@RequestBody @Validated Employee employee) {
        employeeService.insertEmployee(employee);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void updateEmployee(@RequestBody @Validated Employee employee) {
        employeeService.updateEmployee(employee);
    }


}
