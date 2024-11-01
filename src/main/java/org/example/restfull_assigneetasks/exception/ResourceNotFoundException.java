package org.example.restfull_assigneetasks.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
       super(message);
    }

}
