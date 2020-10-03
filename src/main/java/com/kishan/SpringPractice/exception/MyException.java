package com.kishan.SpringPractice.exception;

import java.util.Date;

public class MyException {
    private String errorMessage;
    private Date date;

    public MyException() {
    }

    public MyException(String errorMessage, Date date) {
        this.errorMessage = errorMessage;
        this.date = date;
    }


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
