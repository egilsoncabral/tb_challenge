package com.tbproject.challenge.service;

import com.tbproject.challenge.dto.OperatorResponse;
import com.tbproject.challenge.dto.VehiclePositionResponse;
import com.tbproject.challenge.dto.VehicleResponse;
import com.tbproject.challenge.dto.VehicleStopResponse;
import com.tbproject.challenge.model.Vehicle;
import com.tbproject.challenge.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<OperatorResponse> getOperators(String startTime, String endTime) {
        List<Vehicle> vehicles = vehicleRepository.findByTimeFrameBetween(startTime, endTime);
        List<OperatorResponse> operatorResponses = new ArrayList<>();
        OperatorResponse operatorResponse = new OperatorResponse();
        for (Vehicle vehicle: vehicles) {
            operatorResponse.setOperator(vehicle.getOperator());
            operatorResponses.add(operatorResponse);
        }

        return operatorResponses;
    }

    @Override
    public List<VehicleResponse> getVehicles(String startTime, String endTime, String operator) {
        List<Vehicle> vehicles = vehicleRepository.findByTimeFrameBetweenAndOperator(startTime,endTime, operator);
        List<VehicleResponse> vehicleResponses = new ArrayList<>();
        VehicleResponse vehicleResponse = new VehicleResponse();
        for (Vehicle vehicle: vehicles) {
            vehicleResponse.setVehicleId(vehicle.getVehicleId());
            vehicleResponses.add(vehicleResponse);
        }

        return vehicleResponses;
    }

    @Override
    public List<VehicleStopResponse> getVehiclesStoped(String startTime, String endTime, String fleet) {
        List<Vehicle> vehicles = vehicleRepository.findByTimeFrameBetweenAndOperator(startTime,endTime, fleet);
        List<VehicleStopResponse> vehicleStopResponses = new ArrayList<>();
        VehicleStopResponse vehicleStopResponse = new VehicleStopResponse();
        for (Vehicle vehicle: vehicles) {
            vehicleStopResponse.setVehicleId(vehicle.getVehicleId());
            vehicleStopResponse.setAtStop(vehicle.isAtStop());
            vehicleStopResponses.add(vehicleStopResponse);
        }

        return vehicleStopResponses;
    }

    @Override
    public List<VehiclePositionResponse> getVehiclePosition(String startTime, String endTime, String vehicleId) {
        List<Vehicle> vehicles = vehicleRepository.findByTimeFrameBetweenAndVehicleIdOrderByTimestamp(startTime,endTime, vehicleId);
        List<VehiclePositionResponse> vehiclePositionResponses = new ArrayList<>();
        VehiclePositionResponse vehiclePositionResponse = new VehiclePositionResponse();
        for (Vehicle vehicle: vehicles) {
            vehiclePositionResponse.setLatitude(vehicle.getLatitude());
            vehiclePositionResponse.setLongitude(vehicle.getLongitude());
            vehiclePositionResponses.add(vehiclePositionResponse);
        }

        return vehiclePositionResponses;
    }
}
