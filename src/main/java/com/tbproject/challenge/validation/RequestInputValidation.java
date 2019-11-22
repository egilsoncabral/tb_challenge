package com.tbproject.challenge.validation;

import com.tbproject.challenge.exceptions.ApiException;

import java.text.ParseException;
import java.util.List;

/**
 * Validator to requests params
 */
public interface RequestInputValidation {

    /**
     * @param startTime
     * @param endTime
     * @throws ParseException
     * @throws ApiException
     */
    void validateOperatorRequest(String startTime, String endTime) throws ParseException, ApiException;

    /**
     * @param startTime
     * @param endTime
     * @param operator
     * @throws ParseException
     * @throws ApiException
     */
    void validateVehicleRequest(String startTime, String endTime, String operator) throws ParseException, ApiException;

    /**
     * @param startTime
     * @param endTime
     * @param vehicleId
     * @throws ParseException
     * @throws ApiException
     */
    void validatePositionRequest(String startTime, String endTime, String vehicleId) throws ParseException, ApiException;

}
