package com.kishan.SpringPractice;

import com.kishan.SpringPractice.controllers.HelloController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Value;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Test for Hello Controller")
public class HelloControllerTests {
    private HelloController helloController;

    @Value("${db.username}")
    private String userName;

    @BeforeAll
    void setUp() {
        helloController = new HelloController();
    }

    @Test
    @DisplayName("getHello")
    void getHello() {
        String expected = "Welcome to Spring " + userName;
        String actual = helloController.getHello();
        assertThat(expected, is(actual));
    }
}
