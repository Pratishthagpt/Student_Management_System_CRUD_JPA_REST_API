package com.pratishtha.dev.Student_Management_System_CRUD_JPA.exception;


public class InvalidStudentException extends RuntimeException{
    public InvalidStudentException(String message) {
        super(message);
    }
}
