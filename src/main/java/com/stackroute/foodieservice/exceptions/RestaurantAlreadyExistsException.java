package com.stackroute.foodieservice.exceptions;

public class RestaurantAlreadyExistsException extends Exception {
    private String message;

    public RestaurantAlreadyExistsException() {
    }

    public RestaurantAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
    }

