package com.training.domain;

public class InvalidBetTypeException extends Exception {
    public InvalidBetTypeException(String message) {
        super(message);
    }
}