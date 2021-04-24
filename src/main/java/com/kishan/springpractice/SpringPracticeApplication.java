package com.kishan.springpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
 * For Reference:
 *
 * https://www.journaldev.com/17053/spring-jdbctemplate-example
 * */

/*
* Main application to run the Spring Application
* */

@SpringBootApplication
public class SpringPracticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringPracticeApplication.class, args);
    }

}
