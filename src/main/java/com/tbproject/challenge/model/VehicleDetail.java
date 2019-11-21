package com.tbproject.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class VehicleDetail{
    private long timestamp;
    private String lineId;
    private String direction;
    private String journeyPatternId;
    private String timeFrame;
    private String vehicleJourneyId;
    private String operator;
    private boolean congestion;
    private String longitude;
    private String latitude;
    private Double delay;
    private String blockId;
    private String vehicleId;
    private String stopId;
    private boolean atStop;

    public VehicleDetail(){

    }

}
