package com.taller.report.exception;


@SuppressWarnings("serial")
public class ModelNotFoundException extends RuntimeException{

    public ModelNotFoundException(String message) {
        super(message);
    }
}
