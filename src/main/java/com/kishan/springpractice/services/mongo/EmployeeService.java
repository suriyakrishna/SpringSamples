package com.kishan.springpractice.services.mongo;

import com.kishan.springpractice.configs.SpringMongoOperations;
import com.kishan.springpractice.exception.RequestException;
import com.kishan.springpractice.models.mongo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private SpringMongoOperations springMongoOperations;

    @Autowired
    public EmployeeService(SpringMongoOperations springMongoOperations) {
        this.springMongoOperations = springMongoOperations;
    }

    public long getCount() {
        return springMongoOperations.getCount();
    }

    public List<Employee> findEmployee(String id, String firstName, String lastName, String age) {
        if (id == null && firstName == null && lastName == null && age == null) {
            throw new RequestException("Atleast one parameter should be supplied with value");
        }
        return springMongoOperations.findEmployee(id, firstName, lastName, age);
    }

    public List<Employee> getByFirstName(String firstName) {
        return springMongoOperations.findByFirstName(firstName);
    }

    public void insertEmployee(Employee employee) {
        springMongoOperations.insertRecord(employee);
    }

    public void updateEmployee(Employee employee, String id) {
        springMongoOperations.updateRecord(employee, id);
    }
}
