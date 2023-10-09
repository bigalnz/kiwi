package com.nz.kiwi.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> notFound(EntityNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DatabaseUniqueConstraintException.class)
    public ResponseEntity<?> uniqueNameException(DatabaseUniqueConstraintException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

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

    @ExceptionHandler(BirdAlreadyExistsException.class)
    public ResponseEntity<?> nameAlreadyExists(BirdAlreadyExistsException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
