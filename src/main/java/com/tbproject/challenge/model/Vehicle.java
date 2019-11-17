package com.tbproject.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

    /*
	1356998445000000,7,0,00071003,2012-12-31,6106,D1,0,-6.231650,53.317768,0,7019,43004,3222,1
	*/
	/*
	Timestamp micro since 1970 01 01 00:00:00 GMT
	Line ID
	Direction
	Journey Pattern ID
	Time Frame (The start date of the production time table - in Dublin the production time table starts at 6am and ends at 3am)
	Vehicle Journey ID (A given run on the journey pattern)
	Operator (Bus operator, not the driver)
	Congestion [0=no,1=yes]
	Lon WGS84
	Lat WGS84
	Delay (seconds, negative if bus is ahead of schedule)
	Block ID (a section ID of the journey pattern)
	Vehicle ID
	Stop ID
	At Stop [0=no,1=yes]
	*/

@Data
@AllArgsConstructor
@Document(collection = "vehicle")
public class Vehicle {

    @Id
    private Integer id;
    private VehicleDetail vehicleDetail;

    public Vehicle(){

    }

}
