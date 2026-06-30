package com.backend.Udemy.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
        super();
    }

    @Override
    public String getMessage() {
        return "User Not Found";
    }
}