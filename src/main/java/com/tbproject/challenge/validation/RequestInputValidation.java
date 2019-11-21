package com.tbproject.challenge.validation;

import java.util.List;

public interface RequestInputValidation {

    List validateOperatorRequest(String startTime, String endTime);

    List validateVehicleRequest(String startTime, String endTime, String operator);

    List validatePositionRequest(String startTime, String endTime, String vehicleId);

}
