package com.tbproject.challenge.service;

import com.tbproject.challenge.dto.OperatorResponse;
import com.tbproject.challenge.dto.VehiclePositionResponse;
import com.tbproject.challenge.dto.VehicleResponse;
import com.tbproject.challenge.dto.VehicleStopResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Override
    public List<OperatorResponse> getOperators(String startTime, String EndTime) {
        return null;
    }

    @Override
    public List<VehicleResponse> getVehicles(String startTime, String EndTime, String operator) {
        return null;
    }

    @Override
    public List<VehicleStopResponse> getVehiclesStoped(String startTime, String EndTime, String fleet) {
        return null;
    }

    @Override
    public List<VehiclePositionResponse> getVehiclePosition(String startTime, String EndTime, String vehicleId) {
        return null;
    }
}
