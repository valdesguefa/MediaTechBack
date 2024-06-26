package com.fstg.demo.exception;

public class EntityAlreadyExistException extends RuntimeException {

    public EntityAlreadyExistException() {
    }

    public EntityAlreadyExistException(String message) {
        super(message);
    }
}
