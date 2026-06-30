package com.backend.Udemy.exception;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String message) {
        super(message);
    }

    public EmailAlreadyExistsException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Email Already Registered";
    }
}