package com.tbproject.challenge.controller;

import com.tbproject.challenge.dto.OperatorResponse;
import com.tbproject.challenge.dto.VehiclePositionResponse;
import com.tbproject.challenge.dto.VehicleResponse;
import com.tbproject.challenge.dto.VehicleStopResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Collections;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class VehicleControllerTest extends AbstractTest{

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getOperatorsList() throws Exception {
        String uri = "/operators";
        MultiValueMap<String, String> hearders = new LinkedMultiValueMap<String, String>();
        hearders.put("start-time", Collections.singletonList("2012-12-01"));
        hearders.put("end-time", Collections.singletonList("2013-01-31"));
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE).headers(new HttpHeaders(hearders))).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        OperatorResponse[] operatorlist = super.mapFromJson(content, OperatorResponse[].class);
        assertTrue(operatorlist.length > 0);
    }

    @Test
    public void getVehiclesList() throws Exception {
        String uri = "/vehicles";
        MultiValueMap<String, String> hearders = new LinkedMultiValueMap<String, String>();
        hearders.put("start-time", Collections.singletonList("2012-12-01"));
        hearders.put("end-time", Collections.singletonList("2013-01-31"));
        hearders.put("operator", Collections.singletonList("RD"));
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE).headers(new HttpHeaders(hearders))).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        VehicleResponse[] vehiclelist = super.mapFromJson(content, VehicleResponse[].class);
        assertTrue(vehiclelist.length > 0);
    }

    @Test
    public void getVehicleAtStopList() throws Exception {
        String uri = "/vehiclesAtStop";
        MultiValueMap<String, String> hearders = new LinkedMultiValueMap<String, String>();
        hearders.put("start-time", Collections.singletonList("2012-12-01"));
        hearders.put("end-time", Collections.singletonList("2013-01-31"));
        hearders.put("fleet", Collections.singletonList("RD"));
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE).headers(new HttpHeaders(hearders))).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        VehicleStopResponse[] vehicleAtStoplist = super.mapFromJson(content, VehicleStopResponse[].class);
        assertTrue(vehicleAtStoplist.length > 0);
    }

    @Test
    public void getVehicleTracesList() throws Exception {
        String uri = "/vehicleTrace";
        MultiValueMap<String, String> hearders = new LinkedMultiValueMap<String, String>();
        hearders.put("start-time", Collections.singletonList("2012-12-01"));
        hearders.put("end-time", Collections.singletonList("2013-01-31"));
        hearders.put("vehicleId", Collections.singletonList("40040"));
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE).headers(new HttpHeaders(hearders))).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        VehiclePositionResponse[] vehiclePositionlist = super.mapFromJson(content, VehiclePositionResponse[].class);
        assertTrue(vehiclePositionlist.length > 0);
    }

}
