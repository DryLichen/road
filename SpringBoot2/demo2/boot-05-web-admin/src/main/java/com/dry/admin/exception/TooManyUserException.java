package com.dry.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Too many users!")
public class TooManyUserException extends RuntimeException{
    public TooManyUserException(String message){
        super(message);
    }
}
