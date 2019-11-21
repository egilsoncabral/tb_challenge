package com.tbproject.challenge.validation;

import com.tbproject.challenge.enums.ErrorCodes;
import com.tbproject.challenge.exceptions.ApiException;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

@Component
public class RequestInputValidationImpl implements RequestInputValidation{

    private static final String DATE_PATTERN = "(\\d{4})-(\\d{2})-(\\d{2})$";

    private Map<String, ArrayList<String>> responseObj = new HashMap<String, ArrayList<String>>();

    private List<String> validateDate(String startTime, String endTime) throws ParseException {

        List<String> errorList = new ArrayList<>();
        if (startTime == null){
            errorList.add("Start time null");
        }
        if (endTime == null){
            errorList.add("End time null");
        }

        if (!Pattern.matches(DATE_PATTERN, startTime)){
            errorList.add("Start time must be as 2012-12-01.");
        }
        if (!Pattern.matches(DATE_PATTERN, endTime)){
            errorList.add("End time must be as 2012-12-01.");
        }
        if (errorList.isEmpty()){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date startTimeDate = formatter.parse(startTime);
            Date endTimeDate = formatter.parse(endTime);
            if (startTimeDate.after(endTimeDate)){
                errorList.add("Start time greater then end time.");
            }
        }

        return errorList;
    }

    private void hasErrors(List<String> errors) throws ApiException {
        if (errors.size() > 0) {
            responseObj.put(ErrorCodes.ERROR_DATA_VALIDATION.getCode(), (ArrayList<String>) errors);
            throw new ApiException(responseObj);
        }
    }

    @Override
    public void validateOperatorRequest(String startTime, String endTime) throws ParseException, ApiException {
        List<String> errors = validateDate(startTime, endTime);
        hasErrors(errors);
    }

    @Override
    public void validateVehicleRequest(String startTime, String endTime, String operator) throws ParseException, ApiException {
        List<String> errors = validateDate(startTime, endTime);
        if (operator == null){
            errors.add("Operator is null.");
        }
        hasErrors(errors);
    }

    @Override
    public void validatePositionRequest(String startTime, String endTime, String vehicleId) throws ParseException, ApiException {
        List<String> errors = validateDate(startTime, endTime);
        if (vehicleId == null){
            errors.add("Vehicle Id is null.");
        }
        hasErrors(errors);
    }
}
