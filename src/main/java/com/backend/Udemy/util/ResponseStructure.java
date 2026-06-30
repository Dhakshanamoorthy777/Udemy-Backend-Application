package com.backend.Udemy.util;

import java.time.LocalDateTime;

public class ResponseStructure<T> {

    private T data;
    private LocalDateTime timeStamp;
    private String message;
    private int statusCode;

    public ResponseStructure() {
        this.timeStamp = LocalDateTime.now();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}