package com.tbproject.challenge.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tbproject.challenge.dto.OperatorResponse;
import com.tbproject.challenge.dto.VehiclePositionResponse;
import com.tbproject.challenge.dto.VehicleResponse;
import com.tbproject.challenge.dto.VehicleStopResponse;
import com.tbproject.challenge.model.Vehicle;
import com.tbproject.challenge.repository.VehicleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestVechicleService {

    @InjectMocks
    private VehicleService vehicleService = new VehicleServiceImpl();

    @Mock
    private VehicleRepository vehicleRepository;

    private File jsonFile;
    private List<Vehicle> vehicles;

    @Before
    public void setUp() throws Exception {
        jsonFile = new ClassPathResource("vehicles-mock.json").getFile();
        vehicles = stubVehicles();
        MockitoAnnotations.initMocks(this);
    }

    private List<Vehicle> stubVehicles() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(Files.readAllBytes(jsonFile.toPath()), objectMapper.getTypeFactory().constructCollectionType(List.class, Vehicle.class));
    }

    @Test
    public void testGetOperators() throws ParseException {
        when(vehicleRepository.findByTimeFrameBetween(anyObject(), anyObject())).thenReturn(vehicles);
        List<OperatorResponse> operatorList = vehicleService.getOperators("2012-12-01", "2013-01-31");
        assertTrue(operatorList.size() > 0);
    }

    @Test
    public void testGetVehicles() throws ParseException {
        when(vehicleRepository.findByTimeFrameBetweenAndOperator(anyObject(), anyObject(), anyString())).thenReturn(vehicles);
        List<VehicleResponse> vehicleList = vehicleService.getVehicles("2012-12-01", "2013-01-31", "RD");
        assertTrue(vehicleList.size() > 0);
    }

    @Test
    public void testGetVehicleAtStop() throws ParseException {
        when(vehicleRepository.findByTimeFrameBetweenAndOperator(anyObject(), anyObject(), anyString())).thenReturn(vehicles);
        List<VehicleStopResponse> vehicleList = vehicleService.getVehiclesStoped("2012-12-01", "2013-01-31", "RD");
        assertTrue(vehicleList.size() > 0);
    }

    @Test
    public void testGetVehiclePosition() throws ParseException {
        when(vehicleRepository.findByTimeFrameBetweenAndVehicleIdOrderByTimestamp(anyObject(), anyObject(), anyString())).thenReturn(vehicles);
        List<VehiclePositionResponse> vehiclePositionList = vehicleService.getVehiclePosition("2012-12-01", "2013-01-31", "40040");
        assertTrue(vehiclePositionList.size() > 0);
    }

}
