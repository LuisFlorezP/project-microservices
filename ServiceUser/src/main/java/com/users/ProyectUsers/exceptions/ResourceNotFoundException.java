package com.users.ProyectUsers.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Resource not found in the service.");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
