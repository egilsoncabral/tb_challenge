package com.tbproject.challenge.controller;

import com.tbproject.challenge.dto.*;
import com.tbproject.challenge.exceptions.ApiException;
import com.tbproject.challenge.exceptions.ErrorApiHandler;
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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * Main rest controller 
 */
@RestController
@Api(tags = {"Vehicle API"}, value = "Vehicle API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-18T23:54:00.718Z")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private ErrorApiHandler errorApiHandler;

    @Autowired
    private RequestInputValidation requestInputValidation;

    private final HttpServletRequest request;

    @Autowired
    public VehicleController(HttpServletRequest request) {
        this.request = request;
    }

    @ApiOperation(value = "Returns a list of running operators.", nickname = "operators", notes = "Returns a list of running operators.", response = OperatorResponse.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A list of operators.", response = OperatorResponse.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @RequestMapping(value = "/operators",
            produces = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.GET)
    public ResponseEntity operators(@ApiParam(value = "Start time (2012-12-31)." ,required=true) @RequestHeader(value="start-time", required=true) String startTime, @ApiParam(value = "End time (2013-01-31)." ,required=true) @RequestHeader(value="end-time", required=true) String endTime){
        try{
            requestInputValidation.validateOperatorRequest(startTime, endTime);
            return new ResponseEntity(vehicleService.getOperators(startTime, endTime), HttpStatus.OK);
        } catch (ApiException api){
            return errorApiHandler.buildErrorValidationResponse(api);
        } catch (Exception e){
            return errorApiHandler.buildGeneralErrorResponse(e);
        }

    }

    @ApiOperation(value = "Returns a list of vehicles", nickname = "vehicles", notes = "Returns a list of vehicles", response = VehicleResponse.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A list of vehicles ids.", response = VehicleResponse.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @RequestMapping(value = "/vehicles",
            produces = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.GET)
    public ResponseEntity vehicles(@ApiParam(value = "Start time (2012-12-31)." ,required=true) @RequestHeader(value="start-time", required=true) String startTime,@ApiParam(value = "End time (2013-01-31)." ,required=true) @RequestHeader(value="end-time", required=true) String endTime,@ApiParam(value = "An operator (RD)" ,required=true) @RequestHeader(value="operator", required=true) String operator)  {
        try{
            requestInputValidation.validateVehicleRequest(startTime, endTime, operator);
            return new ResponseEntity<List<VehicleResponse>>(vehicleService.getVehicles(startTime, endTime, operator), HttpStatus.OK);
        } catch (ApiException api){
            return errorApiHandler.buildErrorValidationResponse(api);
        } catch (Exception e){
            return errorApiHandler.buildGeneralErrorResponse(e);
        }
    }

    @ApiOperation(value = "Return which vehicles are at a stop.", nickname = "vehicleAtStop", notes = "Return which vehicles are at a stop.", response = VehicleStopResponse.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A list of vehicles at a Stop.", response = VehicleStopResponse.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @RequestMapping(value = "/vehiclesAtStop",
            produces = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.GET)
    public ResponseEntity vehicleAtStop(@ApiParam(value = "Start time (2012-12-31)." ,required=true) @RequestHeader(value="start-time", required=true) String startTime,@ApiParam(value = "End time (2013-01-31)." ,required=true) @RequestHeader(value="end-time", required=true) String endTime,@ApiParam(value = "A fleet (RD)" ,required=true) @RequestHeader(value="fleet", required=true) String fleet)  {
        try{
            requestInputValidation.validateVehicleRequest(startTime, endTime, fleet);
            return new ResponseEntity(vehicleService.getVehiclesStoped(startTime, endTime, fleet), HttpStatus.OK);
        } catch (ApiException api){
            return errorApiHandler.buildErrorValidationResponse(api);
        } catch (Exception e){
            return errorApiHandler.buildGeneralErrorResponse(e);
        }

    }

    @ApiOperation(value = "Return the trace of that vehicle", nickname = "vehicleTrace", notes = "Return the trace of that vehicle", response = VehiclePositionResponse.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A list of GPS entries of that vehicle.", response = VehiclePositionResponse.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @RequestMapping(value = "/vehicleTrace",
            produces = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.GET)
    public ResponseEntity vehicleTrace(@ApiParam(value = "Start time (2012-12-31)." ,required=true) @RequestHeader(value="start-time", required=true) String startTime,@ApiParam(value = "End time (2013-01-31)." ,required=true) @RequestHeader(value="end-time", required=true) String endTime,@ApiParam(value = "A vehicle id (123445)" ,required=true) @RequestHeader(value="vehicleId", required=true) String vehicleId) {
        try{
            requestInputValidation.validatePositionRequest(startTime, endTime, vehicleId);
            return new ResponseEntity(vehicleService.getVehiclePosition(startTime, endTime, vehicleId), HttpStatus.OK);
        } catch (ApiException api){
            return errorApiHandler.buildErrorValidationResponse(api);
        } catch (Exception e){
            return errorApiHandler.buildGeneralErrorResponse(e);
        }
    }

}
