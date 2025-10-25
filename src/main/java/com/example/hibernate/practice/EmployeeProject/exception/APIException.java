package com.example.hibernate.practice.EmployeeProject.exception;

public class APIException extends RuntimeException {
    public APIException(String message) {
        super(message);
    }
}
