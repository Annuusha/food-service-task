package com.stackroute.foodieservice.exceptions;

public class RestaurantNotFoundException extends Exception {
    String message;

    public RestaurantNotFoundException() {
    }

    public RestaurantNotFoundException(String message) {
        super(message);
        this.message = message;
    }

}
