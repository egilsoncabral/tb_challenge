package com.tbproject.challenge.exceptions;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Custom exception to treat business validation errors
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-18T23:54:00.718Z")

public class ApiException extends Exception{
    private Map<String, ArrayList<String>> responseObj;

    public ApiException(Map<String, ArrayList<String>> erros) {
        this.responseObj = erros;
    }

    public Map<String, ArrayList<String>> getResponseObj() {
        return this.responseObj;
    }

    public void setResponseObj(Map<String, ArrayList<String>> responseObj) {
        this.responseObj = responseObj;
    }
}
