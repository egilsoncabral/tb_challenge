package com.tbproject.challenge.config;

import com.tbproject.challenge.model.Vehicle;
import com.tbproject.challenge.model.VehicleDetail;
import org.springframework.batch.item.ItemProcessor;

import java.text.SimpleDateFormat;

public class DataProcessor implements ItemProcessor<VehicleDetail, Vehicle> {
    @Override
    public Vehicle process(VehicleDetail vehicleDetail) throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setAtStop(vehicleDetail.isAtStop());
        vehicle.setBlockId(vehicleDetail.getBlockId());
        vehicle.setCongestion(vehicleDetail.isCongestion());
        vehicle.setTimeFrame(new SimpleDateFormat("yyyy-MM-dd").parse(vehicleDetail.getTimeFrame()));
        vehicle.setDelay(vehicleDetail.getDelay());
        vehicle.setDirection(vehicleDetail.getDirection());
        vehicle.setJourneyPatternId(vehicleDetail.getJourneyPatternId());
        vehicle.setLatitude(vehicleDetail.getLatitude());
        vehicle.setLongitude(vehicleDetail.getLongitude());
        vehicle.setLineId(vehicleDetail.getLineId());
        vehicle.setOperator(vehicleDetail.getOperator());
        vehicle.setStopId(vehicleDetail.getStopId());
        vehicle.setTimestamp(vehicle.getTimestamp());
        vehicle.setVehicleId(vehicleDetail.getVehicleId());
        vehicle.setVehicleJourneyId(vehicleDetail.getVehicleJourneyId());

        return vehicle;
    }
}
