package com.tbproject.challenge.dto;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-18T23:54:00.718Z")

public class ApiException extends Exception{
    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ApiException(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiException(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }
}
