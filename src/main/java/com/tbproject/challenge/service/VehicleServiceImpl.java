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
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<OperatorResponse> getOperators(String startTime, String endTime) {
        List<Vehicle> vehicles = vehicleRepository.findByTimeFrameBetween(startTime, endTime);
        return vehicles.stream().map((vehicle) -> {
            OperatorResponse operatorResponse = new OperatorResponse();
            operatorResponse.setOperator(vehicle.getOperator());
            return operatorResponse;
        }).collect(Collectors.toList());
    }

    @Override
    public List<VehicleResponse> getVehicles(String startTime, String endTime, String operator) {
        List<Vehicle> vehicles = vehicleRepository.findByTimeFrameBetweenAndOperator(startTime,endTime, operator);
        return vehicles.stream().map((vehicle) -> {
            VehicleResponse vehicleResponse = new VehicleResponse();
            vehicleResponse.setVehicleId(vehicle.getVehicleId());
            return vehicleResponse;
        }).collect(Collectors.toList());
    }

    @Override
    public List<VehicleStopResponse> getVehiclesStoped(String startTime, String endTime, String fleet) {
        List<Vehicle> vehicles = vehicleRepository.findByTimeFrameBetweenAndOperator(startTime,endTime, fleet);
        return vehicles.stream().map((vehicle) -> {
            VehicleStopResponse vehicleStopResponse = new VehicleStopResponse();
            vehicleStopResponse.setVehicleId(vehicle.getVehicleId());
            vehicleStopResponse.setAtStop(vehicle.isAtStop());
            return vehicleStopResponse;
        }).collect(Collectors.toList());
    }

    @Override
    public List<VehiclePositionResponse> getVehiclePosition(String startTime, String endTime, String vehicleId) {
        List<Vehicle> vehicles = vehicleRepository.findByTimeFrameBetweenAndVehicleIdOrderByTimestamp(startTime,endTime, vehicleId);
        return vehicles.stream().map((vehicle) -> {
            VehiclePositionResponse vehiclePositionResponse = new VehiclePositionResponse();
            vehiclePositionResponse.setLatitude(vehicle.getLatitude());
            vehiclePositionResponse.setLongitude(vehicle.getLongitude());
            return vehiclePositionResponse;
        }).collect(Collectors.toList());
    }
}
