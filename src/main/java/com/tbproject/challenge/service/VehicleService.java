package com.tbproject.challenge.service;

import com.tbproject.challenge.dto.OperatorResponse;
import com.tbproject.challenge.dto.VehiclePositionResponse;
import com.tbproject.challenge.dto.VehicleResponse;
import com.tbproject.challenge.dto.VehicleStopResponse;

import java.util.List;

public interface VehicleService {

    List<OperatorResponse> getOperators(String startTime, String endTime);

    List<VehicleResponse> getVehicles(String startTime, String endTime, String operator);

    List<VehicleStopResponse> getVehiclesStoped(String startTime, String endTime, String fleet);

    List<VehiclePositionResponse> getVehiclePosition(String startTime, String endTime, String vehicleId);

}
