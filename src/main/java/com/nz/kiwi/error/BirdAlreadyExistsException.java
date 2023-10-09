package com.nz.kiwi.error;

public class BirdAlreadyExistsException extends RuntimeException {

    public BirdAlreadyExistsException(String message) {
        super(message);
    }

}
