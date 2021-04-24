package com.kishan.springpractice.controllers;

import com.kishan.springpractice.models.mongo.Employee;
import com.kishan.springpractice.services.mongo.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @ApiOperation(value = "Count employees", notes = "Returns count of the employees", response = String.class)
    public String getCount() {
        return "Total number of employees is " + employeeService.getCount();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Get employees for given input parameters", notes = "Returns list of employees for a given input params. Any one of the argument should be mandatory", response = Employee[].class)
    public List<Employee> getByInputParam(@ApiParam(value = "Employee's id", example = "123") @RequestParam(name = "id", required = false) String id,
                                          @ApiParam(value = "Employee's firstName", example = "Ram") @RequestParam(name = "firstName", required = false) String firstName,
                                          @ApiParam(value = "Employee's lastName", example = "Kumar") @RequestParam(name = "lastName", required = false) String lastName,
                                          @ApiParam(value = "Employee's age", example = "12") @RequestParam(name = "age", required = false) String age) {
        return employeeService.findEmployee(id, firstName, lastName, age);
    }

    @RequestMapping(value = "/firstName/{firstName}", method = RequestMethod.GET)
    @ApiOperation(value = "Get employees by firstName", notes = "Returns list of employees for a given firstName")
    public List<Employee> getByfirstName(@ApiParam(value = "Employee's firstName", required = true, example = "Ram") @PathVariable(name = "firstName", required = true) String firstName) {
        return employeeService.getByFirstName(firstName);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ApiOperation(value = "Insert employee record")
    public void insertEmployee(@RequestBody @Validated Employee employee) {
        employeeService.insertEmployee(employee);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update employee record by employee id")
    public void updateEmployeeById(@RequestBody @Validated Employee employee, @ApiParam(value = "Employee's id", required = true, example = "RamKumar") @PathVariable(name = "id") String id) {
        employeeService.updateEmployee(employee, id);
    }


}
