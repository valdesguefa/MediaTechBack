package com.fstg.demo.exception.handler;

import com.fstg.demo.exception.EntityAlreadyExistException;
import com.fstg.demo.shared.ErrorMessage;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.View;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {

    private final View error;

    public AppExceptionHandler(View error) {
        this.error = error;
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException e) {
        ErrorMessage errorMessage = ErrorMessage.builder().
        message(e.getMessage()).code(404).timestamp(new Date()).build();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {EntityAlreadyExistException.class})
    public ResponseEntity<Object> entityAlreadyExistException(EntityAlreadyExistException e) {
        ErrorMessage errorMessage = ErrorMessage.builder().
                message(e.getMessage()).code(409).timestamp(new Date()).build();
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value={MethodArgumentNotValidException.class})
    public ResponseEntity<Object> HandleMethodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> errors = new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach(err->errors.put(err.getField(), err.getDefaultMessage()));

        return new ResponseEntity<>(errors, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
