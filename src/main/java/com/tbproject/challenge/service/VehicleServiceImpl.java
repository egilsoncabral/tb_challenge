package com.tbproject.challenge.service;

import com.tbproject.challenge.dto.OperatorResponse;
import com.tbproject.challenge.dto.VehiclePositionResponse;
import com.tbproject.challenge.dto.VehicleResponse;
import com.tbproject.challenge.dto.VehicleStopResponse;
import com.tbproject.challenge.model.Vehicle;
import com.tbproject.challenge.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * @param startTime
     * @param endTime
     * @return
     * @throws ParseException
     */
    @Override
    public List<OperatorResponse> getOperators(String startTime, String endTime) throws ParseException {
        List<Vehicle> vehicles = vehicleRepository.findByTimeFrameBetween(dateFormatter.parse(startTime), dateFormatter.parse(endTime));
        List<OperatorResponse> responseList = vehicles.stream().map((vehicle) -> {
            OperatorResponse operatorResponse = new OperatorResponse();
            operatorResponse.setOperator(vehicle.getOperator());
            return operatorResponse;
        }).collect(Collectors.toList());
        return new ArrayList<>(new HashSet<>(responseList));
    }

    /**
     * @param startTime
     * @param endTime
     * @param operator
     * @return
     * @throws ParseException
     */
    @Override
    public List<VehicleResponse> getVehicles(String startTime, String endTime, String operator) throws ParseException {
        List<Vehicle> vehicles = vehicleRepository.findByTimeFrameBetweenAndOperator(dateFormatter.parse(startTime),
                dateFormatter.parse(endTime), operator);
        List<VehicleResponse> responseList =  vehicles.stream().map((vehicle) -> {
            VehicleResponse vehicleResponse = new VehicleResponse();
            vehicleResponse.setVehicleId(vehicle.getVehicleId());
            return vehicleResponse;
        }).collect(Collectors.toList());
        return new ArrayList<>(new HashSet<>(responseList));
    }

    /**
     * @param startTime
     * @param endTime
     * @param fleet
     * @return
     * @throws ParseException
     */
    @Override
    public List<VehicleStopResponse> getVehiclesStoped(String startTime, String endTime, String fleet) throws ParseException {
        List<Vehicle> vehicles = vehicleRepository.findByTimeFrameBetweenAndOperator(dateFormatter.parse(startTime),
                dateFormatter.parse(endTime), fleet);
        List<Vehicle> vehiclesAtStop = vehicles.stream().filter((vehicle) -> vehicle.isAtStop()).collect(Collectors.toList());
        List<VehicleStopResponse> responseList = vehiclesAtStop.stream().map((vehicle) -> {
            VehicleStopResponse vehicleStopResponse = new VehicleStopResponse();
            vehicleStopResponse.setVehicleId(vehicle.getVehicleId());
            vehicleStopResponse.setAtStop(vehicle.isAtStop());
            return vehicleStopResponse;
        }).collect(Collectors.toList());
        return new ArrayList<>(new HashSet<>(responseList));
    }

    /**
     * @param startTime
     * @param endTime
     * @param vehicleId
     * @return
     * @throws ParseException
     */
    @Override
    public List<VehiclePositionResponse> getVehiclePosition(String startTime, String endTime, String vehicleId) throws ParseException {
        List<Vehicle> vehicles = vehicleRepository.findByTimeFrameBetweenAndVehicleIdOrderByTimestamp(dateFormatter.parse(startTime),
                dateFormatter.parse(endTime), vehicleId);
        List<VehiclePositionResponse> responseList = vehicles.stream().map((vehicle) -> {
            VehiclePositionResponse vehiclePositionResponse = new VehiclePositionResponse();
            vehiclePositionResponse.setLatitude(vehicle.getLatitude());
            vehiclePositionResponse.setLongitude(vehicle.getLongitude());
            return vehiclePositionResponse;
        }).collect(Collectors.toList());
        return new ArrayList<>(new HashSet<>(responseList));
    }
}
