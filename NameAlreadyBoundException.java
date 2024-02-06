package com.task.api.repository;

public class NameAlreadyBoundException extends RuntimeException {

    public NameAlreadyBoundException(String message) {
        super(message);
    }
}
