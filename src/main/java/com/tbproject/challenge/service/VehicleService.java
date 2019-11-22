package com.tbproject.challenge.service;

import com.tbproject.challenge.dto.OperatorResponse;
import com.tbproject.challenge.dto.VehiclePositionResponse;
import com.tbproject.challenge.dto.VehicleResponse;
import com.tbproject.challenge.dto.VehicleStopResponse;

import java.text.ParseException;
import java.util.List;

/**
 * Service responsable to apply the business rules and return the datas responses
 */
public interface VehicleService {

    /**
     * @param startTime
     * @param endTime
     * @return List<OperatorResponse>
     * @throws ParseException
     */
    List<OperatorResponse> getOperators(String startTime, String endTime) throws ParseException;

    /**
     * @param startTime
     * @param endTime
     * @param operator
     * @return List<VehicleResponse>
     * @throws ParseException
     */
    List<VehicleResponse> getVehicles(String startTime, String endTime, String operator) throws ParseException;

    /**
     * @param startTime
     * @param endTime
     * @param fleet
     * @return List<VehicleStopResponse>
     * @throws ParseException
     */
    List<VehicleStopResponse> getVehiclesStoped(String startTime, String endTime, String fleet) throws ParseException;

    /**
     * @param startTime
     * @param endTime
     * @param vehicleId
     * @return List<VehiclePositionResponse>
     * @throws ParseException
     */
    List<VehiclePositionResponse> getVehiclePosition(String startTime, String endTime, String vehicleId) throws ParseException;

}
