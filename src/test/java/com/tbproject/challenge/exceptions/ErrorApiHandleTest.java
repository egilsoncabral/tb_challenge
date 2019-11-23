package com.tbproject.challenge.exceptions;

import com.tbproject.challenge.TbChallengeVehiclesApplication;
import com.tbproject.challenge.enums.ErrorCodes;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TbChallengeVehiclesApplication.class)
public class ErrorApiHandleTest {

    @Autowired
    private ErrorApiHandler errorApiHandler;
    private Map<String, ArrayList<String>> responseObj;

    @Before
    public void setUp() throws Exception {
        responseObj = new HashMap<String, ArrayList<String>>();
    }


    @Test
    public void testBuildErrorValidationResponse(){
        ArrayList<String> errorList = new ArrayList<>();
        errorList.add("error");
        responseObj.put(ErrorCodes.ERROR_DATA_VALIDATION.getCode(), errorList);
        ResponseEntity response = errorApiHandler.buildErrorValidationResponse(new ApiException(responseObj));
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void testbuildGeneralErrorResponse(){
        ResponseEntity response = errorApiHandler.buildGeneralErrorResponse(new Exception());
        assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

