package com.fstg.demo.exception;

import lombok.Data;

@Data
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {}

    public EntityNotFoundException(String message) {
        super(message);
    }
}
