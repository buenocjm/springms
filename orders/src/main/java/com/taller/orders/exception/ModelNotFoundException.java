package com.taller.orders.exception;

@SuppressWarnings("serial")
public class ModelNotFoundException extends RuntimeException{

    public ModelNotFoundException(String message) {
        super(message);
    }

}
