package com.nz.kiwi.error;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

@ControllerAdvice
public class ValidationExceptionHandler {

    /**
     * For an invalid input, spring framework will throw an
     * MethodArgumentNotValidException exception
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValidInput(MethodArgumentNotValidException e) {
        Map<String, String> errorMap = e.getAllErrors()
                .stream()
                .collect(Collectors.toMap(x -> ((FieldError) x).getField(),
                        b -> b.getDefaultMessage(), (p, q) -> p, LinkedHashMap::new));
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

/*
    @ExceptionHandler(value= DataIntegrityViolationException.class)
    public ResponseEntity<Object> duplicateInput(DataIntegrityViolationException e, WebRequest request) {
        String bodyOfResponse = "You tried to save a object with existing name";
        return handleExceptionIntneral(e.getMessage(), bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
*/


}
