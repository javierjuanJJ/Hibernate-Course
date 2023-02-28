package com.example.projecthibernatejpa_springboot.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UserException extends Exception {
    public UserException(String message) {
        super(message);
    }

    public UserException(Exception e) {
        super(e);
    }
}
