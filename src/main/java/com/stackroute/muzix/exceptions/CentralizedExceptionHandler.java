package com.stackroute.muzix.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.stackroute.muzix")
public class CentralizedExceptionHandler {

    @ExceptionHandler(TrackAlreadyExistsException.class)
    public ResponseEntity<Object> myMessage(TrackAlreadyExistsException e) {
        System.out.println("inside Message method trackalreadyex");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity<Object> myMessage(TrackNotFoundException e) {
        System.out.println("inside Message method tracknotfound ");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> myMessage(Exception e) {
        return new ResponseEntity<>("Internal Server Error", HttpStatus.CONFLICT);
    }
}
