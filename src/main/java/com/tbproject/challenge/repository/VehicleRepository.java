package com.tbproject.challenge.repository;

import com.tbproject.challenge.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, Integer>{


    List findByTimeFrameBetween(Date startTime, Date endTime);

    List findByTimeFrameBetweenAndOperator(Date startTime, Date endTime, String operator);

    List findByTimeFrameBetweenAndVehicleIdOrderByTimestamp(Date startTime, Date endTime, String vehicleId);

}
