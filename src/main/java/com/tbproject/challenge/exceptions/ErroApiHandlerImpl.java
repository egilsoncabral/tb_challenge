package com.tbproject.challenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Handler responsable to treat error responses
 */
@Component
public class ErroApiHandlerImpl implements ErrorApiHandler {

    /**
     * @param error
     * @return
     */
    @Override
    public ResponseEntity<Object> buildErrorValidationResponse(Object error) {
        Map<String, String> systemError = new HashMap();

        try {
            ApiException apiException = (ApiException)error;
            systemError.put("error", apiException.getResponseObj().toString());

            if (apiException.getResponseObj().toString() == null || apiException.getResponseObj().toString().isEmpty()) {
                systemError.put("error", "\n" +
                        "An internal error has occurred");
                return new ResponseEntity(systemError, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception var7) {
            systemError.put("error", "\n" +
                    "An internal error performing buildErrorValidationResponse");
            return new ResponseEntity(systemError, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(systemError, HttpStatus.BAD_REQUEST);
    }

    /**
     * @param error
     * @return
     */
    @Override
    public ResponseEntity<Object> buildGeneralErrorResponse(Object error) {
        Map<String, String> systemError = new HashMap();

        try {
            Exception exceptionError = (Exception) error;
            if (exceptionError.getMessage() != null) {
                systemError.put("error", exceptionError.getMessage());
            } else if (exceptionError.getCause() != null) {
                systemError.put("error", exceptionError.getCause().toString());
            } else {
                systemError.put("error", "\n" +
                        "An internal error has occurred");
            }

        } catch (Exception var7) {
            systemError.put("error", "Internal error performing buildGeneralErrorResponse");
            return new ResponseEntity(systemError, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(systemError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
