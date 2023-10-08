package com.nz.kiwi.error;

public class DatabaseUniqueConstraintException extends RuntimeException {

    public DatabaseUniqueConstraintException(String message) {
        super(message);
    }
}
