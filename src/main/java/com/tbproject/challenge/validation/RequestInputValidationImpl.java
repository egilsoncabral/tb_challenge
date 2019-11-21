package com.tbproject.challenge.validation;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RequestInputValidationImpl implements RequestInputValidation{

    private static final String DATE_PATTERN = "(\\d{4})-(\\d{2})-(\\d{2})$";

    private List<String> validateDate(String startTime, String endTime){
        List<String> errorList = new ArrayList<>();
        if (startTime == null){
            errorList.add("Start time null");
        }
        if (endTime == null){
            errorList.add("End time null");
        }
        if (new Date(Long.valueOf(startTime)).after(new Date(Long.valueOf(endTime)))){
            errorList.add("Start time greater then end time.");
        }
        if (!Pattern.matches(DATE_PATTERN, startTime)){
            errorList.add("Start time must be as 2012-12-01.");
        }
        if (!Pattern.matches(DATE_PATTERN, endTime)){
            errorList.add("End time must be as 2012-12-01.");
        }
        return errorList;
    }

    @Override
    public List<String> validateOperatorRequest(String startTime, String endTime) {
        return validateDate(startTime, endTime);
    }

    @Override
    public List<String> validateVehicleRequest(String startTime, String endTime, String operator) {
        List<String> errors = validateDate(startTime, endTime);
        if (operator == null){
            errors.add("Operator is null.");
        }
        return errors;
    }

    @Override
    public List<String> validatePositionRequest(String startTime, String endTime, String vehicleId) {
        List<String> errors = validateDate(startTime, endTime);
        if (vehicleId == null){
            errors.add("Vehicle Id is null.");
        }
        return errors;
    }
}
