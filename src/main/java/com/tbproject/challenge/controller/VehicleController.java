package com.tbproject.challenge.controller;

import com.tbproject.challenge.dto.OperatorResponse;
import com.tbproject.challenge.dto.VehiclePositionResponse;
import com.tbproject.challenge.dto.VehicleResponse;
import com.tbproject.challenge.dto.VehicleStopResponse;
import com.tbproject.challenge.service.VehicleService;
import com.tbproject.challenge.validation.RequestInputValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;


@RestController
//@RequestMapping(value = "/api/")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-18T23:54:00.718Z")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private RequestInputValidation requestInputValidation;

    private final HttpServletRequest request;

    @Autowired
    public VehicleController(HttpServletRequest request) {
        this.request = request;
    }

    @ApiOperation(value = "Returns a list of running operators.", nickname = "operators", notes = "Returns a list of running operators.", response = OperatorResponse.class, responseContainer = "List", tags={ "Operators", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A list of operators.", response = OperatorResponse.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @RequestMapping(value = "/operators",
            produces = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.GET)
    public ResponseEntity<List<OperatorResponse>> operators(@ApiParam(value = "Start time (2012-12-31)." ,required=true) @RequestHeader(value="start-time", required=true) String startTime, @ApiParam(value = "End time (2013-01-31)." ,required=true) @RequestHeader(value="end-time", required=true) String endTime) {
        List<String> errorList = new ArrayList<>();
        errorList = requestInputValidation.validateOperatorRequest(startTime, endTime);
        return new ResponseEntity<List<OperatorResponse>>(vehicleService.getOperators(startTime, endTime), HttpStatus.OK);

    }

    @ApiOperation(value = "Returns a list of vehicles", nickname = "vehicles", notes = "Returns a list of vehicles", response = VehicleResponse.class, responseContainer = "List", tags={ "Vehicles", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A list of vehicles ids.", response = VehicleResponse.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @RequestMapping(value = "/vehicles",
            produces = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.GET)
    public ResponseEntity<List<VehicleResponse>> vehicles(@ApiParam(value = "Start time (2012-12-31)." ,required=true) @RequestHeader(value="start-time", required=true) String startTime,@ApiParam(value = "End time (2013-01-31)." ,required=true) @RequestHeader(value="end-time", required=true) String endTime,@ApiParam(value = "An operator (RD)" ,required=true) @RequestHeader(value="operator", required=true) String operator) {
        List<String> errorList = new ArrayList<>();
        errorList = requestInputValidation.validateVehicleRequest(startTime, endTime, operator);
        return new ResponseEntity<List<VehicleResponse>>(vehicleService.getVehicles(startTime, endTime, operator), HttpStatus.OK);

    }

    @ApiOperation(value = "Return which vehicles are at a stop.", nickname = "vehicleAtStop", notes = "Return which vehicles are at a stop.", response = VehicleStopResponse.class, responseContainer = "List", tags={ "Vehicles at a Stop", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A list of vehicles at a Stop.", response = VehicleStopResponse.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @RequestMapping(value = "/vehiclesAtStop",
            produces = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.GET)
    public ResponseEntity<List<VehicleStopResponse>> vehicleAtStop(@ApiParam(value = "Start time (2012-12-31)." ,required=true) @RequestHeader(value="start-time", required=true) String startTime,@ApiParam(value = "End time (2013-01-31)." ,required=true) @RequestHeader(value="end-time", required=true) String endTime,@ApiParam(value = "A fleet (RD)" ,required=true) @RequestHeader(value="fleet", required=true) String fleet) {
        List<String> errorList = new ArrayList<>();
        errorList = requestInputValidation.validateVehicleRequest(startTime, endTime, fleet);
        return new ResponseEntity<List<VehicleStopResponse>>(vehicleService.getVehiclesStoped(startTime, endTime, fleet), HttpStatus.OK);

    }

    @ApiOperation(value = "Return the trace of that vehicle", nickname = "vehicleTrace", notes = "Return the trace of that vehicle", response = VehiclePositionResponse.class, responseContainer = "List", tags={ "Trace of a vehicle", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A list of GPS entries of that vehicle.", response = VehiclePositionResponse.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @RequestMapping(value = "/vehicleTrace",
            produces = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.GET)
    public ResponseEntity<List<VehiclePositionResponse>> vehicleTrace(@ApiParam(value = "Start time (2012-12-31)." ,required=true) @RequestHeader(value="start-time", required=true) String startTime,@ApiParam(value = "End time (2013-01-31)." ,required=true) @RequestHeader(value="end-time", required=true) String endTime,@ApiParam(value = "A vehicle id (123445)" ,required=true) @RequestHeader(value="vehicleId", required=true) String vehicleId) {
        return new ResponseEntity<List<VehiclePositionResponse>>(vehicleService.getVehiclePosition(startTime, endTime, vehicleId), HttpStatus.OK);
    }

}
