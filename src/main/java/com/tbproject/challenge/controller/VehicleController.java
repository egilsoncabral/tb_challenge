package com.tbproject.challenge.controller;

import com.tbproject.challenge.dto.OperatorResponse;
import com.tbproject.challenge.dto.VehiclePositionResponse;
import com.tbproject.challenge.dto.VehicleResponse;
import com.tbproject.challenge.dto.VehicleStopResponse;
import com.tbproject.challenge.service.VehicleService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
@Api(value="Bus GPS API")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/operators")
    @Operation(summary = "Returns a list of running operators.", description = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A list of operators.", content = @Content(array = @ArraySchema(schema = @Schema(implementation = OperatorResponse.class)))),
            @ApiResponse(responseCode = "400", description = "Validation error."),
            @ApiResponse(responseCode = "404", description = "Server offline."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    public List<OperatorResponse> operatorsGet(@NotNull @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
                                               @RequestHeader("start-time")
                                               @Parameter(description = "Start time (2012-12-31).") String startTime,
                                               @NotNull @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
                                               @RequestHeader("end-time")
                                               @Parameter(description = "End time (2013-01-31).") String endTime
    ) {
        return vehicleService.getOperators(startTime, endTime);
    }

    @GetMapping("/vehicles")
    @Operation(summary = "Returns a list of vehicles.", description = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A list of vehicles ids.", content = @Content(array = @ArraySchema(schema = @Schema(implementation = VehicleResponse.class)))),
            @ApiResponse(responseCode = "400", description = "Validation error."),
            @ApiResponse(responseCode = "404", description = "Server offline."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    public List<VehicleResponse> vehiclesGet(@NotNull @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
                                             @RequestHeader("start-time")
                                             @Parameter(description = "Start time (2012-12-31).") String startTime,
                                             @NotNull @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$") @RequestHeader("end-time")
                                             @Parameter(description = "End time (2013-01-31).") String endTime,
                                             @NotNull @RequestHeader("operator")
                                             @Parameter(description = "An operator") String operator
    ) {
        return vehicleService.getVehicles(startTime, endTime, operator);
    }

    @RequestMapping(value = "/vehicle/stop", method = RequestMethod.GET)
    @Operation(summary = "Return which vehicles are at a stop.", description = "", tags={  })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A list of vehicles at a Stop.", content = @Content(array = @ArraySchema(schema = @Schema(implementation = VehicleStopResponse.class)))),
            @ApiResponse(responseCode = "400", description = "Validation error."),
            @ApiResponse(responseCode = "404", description = "Server offline."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    public List<VehicleStopResponse> vehiclesAtStopGet(@NotNull @Pattern(regexp="^\\d{4}-\\d{2}-\\d{2}$")
                                                       @RequestHeader("start-time")
                                                       @Parameter(description = "Start time (2012-12-31).") String startTime,
                                                       @NotNull @Pattern(regexp="^\\d{4}-\\d{2}-\\d{2}$")
                                                       @RequestHeader("end-time")
                                                       @Parameter(description = "End time (2013-01-31).") String endTime,
                                                       @NotNull
                                                       @RequestHeader("fleet")
                                                       @Parameter(description = "A fleet") String fleet
    ) {
        return vehicleService.getVehiclesStoped(startTime, endTime, fleet);
    }

    @RequestMapping(value = "/vehicle/trace", method = RequestMethod.GET)
    @Operation(summary = "Return the trace of that vehicle (GPS entries, ordered by timestamp)", description = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The trace of that vehicle", content = @Content(schema = @Schema(implementation = VehiclePositionResponse.class))),
            @ApiResponse(responseCode = "400", description = "Validation error."),
            @ApiResponse(responseCode = "404", description = "Server offline."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    public VehiclePositionResponse vehicleTraceGet(@NotNull @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
                                                   @RequestHeader("start-time")
                                                   @Parameter(description = "Start time (2012-12-31).") String startTime,
                                                   @NotNull @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
                                                   @RequestHeader("end-time")
                                                   @Parameter(description = "End time (2013-01-31).") String endTime,
                                                   @NotNull @RequestHeader("vehicleId")
                                                   @Parameter(description = "A vehicle id") String vehicleId) {
        return vehicleService.getVehiclePosition(startTime, endTime, vehicleId);
    }

}
