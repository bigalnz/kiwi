package com.nz.kiwi.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Test class - work to be done - should return error message if bird is not found
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BirdNotFoundExceptionHandler {

    public class UserNotFoundException extends RuntimeException {
/*        public BirdNotFoundException(String message) {
            super(message);
        }
        public BirdNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }*/
    }


}
