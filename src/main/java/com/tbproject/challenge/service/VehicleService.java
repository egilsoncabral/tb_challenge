package com.tbproject.challenge.service;

import com.tbproject.challenge.dto.OperatorResponse;
import com.tbproject.challenge.dto.VehiclePositionResponse;
import com.tbproject.challenge.dto.VehicleResponse;
import com.tbproject.challenge.dto.VehicleStopResponse;

import java.text.ParseException;
import java.util.List;

public interface VehicleService {

    List<OperatorResponse> getOperators(String startTime, String endTime) throws ParseException;

    List<VehicleResponse> getVehicles(String startTime, String endTime, String operator) throws ParseException;

    List<VehicleStopResponse> getVehiclesStoped(String startTime, String endTime, String fleet) throws ParseException;

    List<VehiclePositionResponse> getVehiclePosition(String startTime, String endTime, String vehicleId) throws ParseException;

}
