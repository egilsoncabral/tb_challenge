package com.tbproject.challenge.validation;

import com.tbproject.challenge.exceptions.ApiException;

import java.text.ParseException;
import java.util.List;

public interface RequestInputValidation {

    void validateOperatorRequest(String startTime, String endTime) throws ParseException, ApiException;

    void validateVehicleRequest(String startTime, String endTime, String operator) throws ParseException, ApiException;

    void validatePositionRequest(String startTime, String endTime, String vehicleId) throws ParseException, ApiException;

}
