package com.brecucoder.ordero.services.exceptions;

public abstract class OrderoException extends RuntimeException {

    public OrderoException(String message) {
        super(message);
    }

}