package com.backend.Udemy.exception;

public class InvalidCredentialsException extends RuntimeException {

    public InvalidCredentialsException(String message) {
        super(message);
    }

    public InvalidCredentialsException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Invalid Email or Password";
    }
}