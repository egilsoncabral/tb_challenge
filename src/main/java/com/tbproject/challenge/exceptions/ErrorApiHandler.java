package com.tbproject.challenge.exceptions;

import org.springframework.http.ResponseEntity;

public interface ErrorApiHandler {

    ResponseEntity<Object> buildErrorValidationResponse(Object error);

    ResponseEntity<Object> buildGeneralErrorResponse(Object error);
}
