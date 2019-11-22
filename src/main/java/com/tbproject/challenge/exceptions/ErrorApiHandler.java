package com.tbproject.challenge.exceptions;

import org.springframework.http.ResponseEntity;

public interface ErrorApiHandler {

    /**
     * Treat the returns when is a validation errors
     * @param error
     * @return Error responses
     */
    ResponseEntity<Object> buildErrorValidationResponse(Object error);

    /**
     * Treat the returns when is a general error
     * @param error
     * @return Error responses
     */
    ResponseEntity<Object> buildGeneralErrorResponse(Object error);
}
