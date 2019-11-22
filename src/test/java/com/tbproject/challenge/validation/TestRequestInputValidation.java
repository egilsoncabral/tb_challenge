package com.tbproject.challenge.validation;

import com.tbproject.challenge.exceptions.ApiException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRequestInputValidation {

    @Autowired
    private RequestInputValidation requestInputValidation;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testValidateOperatorRequest() throws ParseException, ApiException {
        exceptionRule.expect(ApiException.class);
        requestInputValidation.validateOperatorRequest("2012201", "2013-01-31");
    }

    @Test
    public void testValidateVehicleRequest() throws ParseException, ApiException {
        exceptionRule.expect(ApiException.class);
        requestInputValidation.validateVehicleRequest("2012-02-01", "20130131", "RD");
    }

    @Test
    public void testValidateVehiclePositionRequest() throws ParseException, ApiException {
        exceptionRule.expect(ApiException.class);
        requestInputValidation.validatePositionRequest("2012-02-01", "2013-01-31", "");
    }

}
