package com.github.kasparpartel.workouttrackerrestapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmailExistsException extends ResponseStatusException {
    public EmailExistsException(String errorMessage) {
        super(HttpStatus.BAD_REQUEST, errorMessage);
    }
}
