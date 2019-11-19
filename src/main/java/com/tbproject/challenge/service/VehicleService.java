package com.tbproject.challenge.service;

import com.tbproject.challenge.dto.OperatorResponse;
import com.tbproject.challenge.dto.VehiclePositionResponse;
import com.tbproject.challenge.dto.VehicleResponse;
import com.tbproject.challenge.dto.VehicleStopResponse;

import java.util.List;

public interface VehicleService {

    List<OperatorResponse> getOperators(String startTime, String EndTime);

    List<VehicleResponse> getVehicles(String startTime, String EndTime, String operator);

    List<VehicleStopResponse> getVehiclesStoped(String startTime, String EndTime, String fleet);

    List<VehiclePositionResponse> getVehiclePosition(String startTime, String EndTime, String vehicleId);

}
