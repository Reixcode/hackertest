package com.dimatica.hackertest.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;



import io.restassured.module.mockmvc.RestAssuredMockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class HackertestControllerTests {

	
	@Autowired
	private HackertestController controller;
	
	@BeforeEach
    void setup(){
    	MockitoAnnotations.openMocks(this);
    
    	RestAssuredMockMvc.standaloneSetup(	controller);
    }
	
	@Test
	void detectionTest () {
		
		
		RestAssuredMockMvc.given().queryParam("logLine","80.238.9.179,1336129472,SIGNIN_FAILURE,Will.Smith")
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.when()
		.get("/hackertest/detection")
		.then()
		.log().ifValidationFails()
		.statusCode(HttpStatus.OK.value());
		
	}

	@Test
	void calculateTimeTest () {
		RestAssuredMockMvc.given().queryParam("time1","Tue, 07 Feb 1984 12:34:56 +0700").queryParam("time2", "Tue, 07 Feb 1984 12:35:56 +0700")
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.when()
		.get("/hackertest/calculateTime")
		.then()
		.log().ifValidationFails()
		.statusCode(HttpStatus.OK.value());
		
	}
}
