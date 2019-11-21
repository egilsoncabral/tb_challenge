package com.tbproject.challenge.repository;

import com.tbproject.challenge.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, Integer>{


    List findByTimeFrameBetween(String startTime, String endTime);

    List findByTimeFrameBetweenAndOperator(String startTime, String endTime, String operator);

    List findByTimeFrameBetweenAndVehicleIdOrderByTimestamp(String startTime, String endTime, String vehicleId);

}
