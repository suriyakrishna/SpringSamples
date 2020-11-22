package com.kishan.springpractice;

import com.kishan.springpractice.repos.SpringMongoOperations;
import com.kishan.springpractice.exception.RequestException;
import com.kishan.springpractice.models.mongo.Employee;
import com.kishan.springpractice.services.mongo.EmployeeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Test for Employee Service")
public class EmployeeServiceTests {
    @Mock
    private SpringMongoOperations springMongoOperations;

    private EmployeeService employeeService;

    private List<Employee> employeeList;


    @BeforeAll
    void setUp() {
        initMocks(this);
        employeeService = new EmployeeService(springMongoOperations);
        employeeList = new ArrayList<>();
        employeeList.add(new Employee("1", "Ram", "Kumar", 12));
        employeeList.add(new Employee("2", "Suresh", "Kumar", 12));
        employeeList.add(new Employee("2", "Dinesh", "Kumar", 13));
    }

    @Test
    @DisplayName("Employee Collection count")
    void count() {
        long expectedCount = 1;
        doReturn(expectedCount).when(springMongoOperations).getCount();
        long actualCount = employeeService.getCount();
        verify(springMongoOperations).getCount();
        assertThat(expectedCount, is(actualCount));
    }

    @Test
    @DisplayName("findEmployee method should throw exception for null inputs")
    void findEmployeeFail() {
        assertThrows(RequestException.class, () -> employeeService.findEmployee(null, null, null, null));
    }

    @Test
    @DisplayName("findEmployee method should return employee list")
    void findEmployee() {
        List<Employee> expected = employeeList.subList(0, 1);
        doReturn(expected).when(springMongoOperations).findEmployee(any(String.class), nullable(String.class), nullable(String.class), nullable(String.class));
        List<Employee> actual = employeeService.findEmployee("1", null, null, null);
        verify(springMongoOperations).findEmployee("1", null, null, null);
        assertThat(expected, is(actual));
    }

    @Test
    @DisplayName("getEmployee By firstname method should return employee list")
    void getEmployeeByFirstName() {
        List<Employee> expected = employeeList.subList(1, 2);
        doReturn(expected).when(springMongoOperations).findByFirstName(any(String.class));
        List<Employee> actual = employeeService.getByFirstName("Suresh");
        verify(springMongoOperations).findByFirstName("Suresh");
        assertThat(expected, is(actual));
    }

    @Test
    @DisplayName("Insert Employee")
    void insertEmployee() {
        employeeService.insertEmployee(employeeList.get(0));
    }

    @Test
    @DisplayName("Update Employee")
    void updateEmployee() {
        employeeService.updateEmployee(employeeList.get(1), "1");
    }

}
