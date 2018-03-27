package com.brecucoder.ordero.api;

import com.brecucoder.ordero.services.exceptions.IllegalFieldFoundException;
import com.brecucoder.ordero.services.exceptions.UnknownResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = {"com.brecucoder.ordero"})
public class GlobalControllerAdvice {

    @ExceptionHandler(UnknownResourceException.class)
    public ResponseEntity<String> convertUnknownIdException(final UnknownResourceException exception) {
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalFieldFoundException.class)
    public ResponseEntity<String> convertIllegalFieldFoundException(final IllegalFieldFoundException exception) {
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

}