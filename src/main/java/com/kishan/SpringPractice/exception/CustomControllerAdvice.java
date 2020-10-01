package com.kishan.SpringPractice.exception;

import com.mongodb.MongoException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RequestException.class)
    protected ResponseEntity<Object> handleGetEmployeeParameterException(
            RuntimeException ex, WebRequest request) {
        MyException myException = new MyException(ex.getMessage(), new Date());
        return handleExceptionInternal(ex, myException,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(MongoException.class)
    protected ResponseEntity<Object> handleMongoException(
            RuntimeException ex, WebRequest request) {
        MyException myException = new MyException(ex.getMessage(), new Date());
        return handleExceptionInternal(ex, myException,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleOtherException(
            RuntimeException ex, WebRequest request) {
        MyException myException = new MyException(ex.getMessage(), new Date());
        return handleExceptionInternal(ex, myException,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }




}
