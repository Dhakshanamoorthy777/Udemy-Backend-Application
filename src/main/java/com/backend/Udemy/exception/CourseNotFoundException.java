package com.backend.Udemy.exception;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(String message) {
        super(message);
    }

    public CourseNotFoundException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Course Not Found";
    }
}