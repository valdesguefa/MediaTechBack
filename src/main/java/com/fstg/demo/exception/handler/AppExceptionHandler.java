package com.fstg.demo.exception.handler;

import com.fstg.demo.exception.EntityAlreadyExistException;
import com.fstg.demo.shared.ErrorMessage;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings({"SpringAutowiredFieldsWarningInspection", "NullableProblems"})
@RestControllerAdvice
@Slf4j
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(AppExceptionHandler.class);



    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatusCode status,
                                                                  WebRequest request) {
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>("kjdkjfd dkjfdkjf dkdjfdkjf", status);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatusCode status, WebRequest request) {
        Map<String, List<String>> body = new HashMap<>();
        log.info("bonjour toi :(");

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException e) {

        logger.error(e.getMessage(), e);


        ErrorMessage errorMessage = ErrorMessage.builder().
        message(e.getMessage()).code(404).timestamp(new Date()).build();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {EntityAlreadyExistException.class})
    public ResponseEntity<Object> entityAlreadyExistException(EntityAlreadyExistException e) {
        logger.error(e.getMessage(), e);

        ErrorMessage errorMessage = ErrorMessage.builder().
                message(e.getMessage()).code(409).timestamp(new Date()).build();
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }


}
