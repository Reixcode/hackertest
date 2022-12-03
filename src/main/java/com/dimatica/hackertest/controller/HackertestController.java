package com.dimatica.hackertest.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.dimatica.hackertest.service.HackerDetectorImpl;
import com.dimatica.hackertest.utils.Utils;

@RestController
@RequestMapping("/hackertest")
public class HackertestController {
	
	@Autowired
	HackerDetectorImpl hackerDetector;
	
	
	@GetMapping("/detection")
	public ResponseEntity<String> detection (@Valid @RequestParam(value = "logLine", required = true) String logLine){
		return new ResponseEntity<>(hackerDetector.parseLine(logLine), HttpStatus.OK);
	}

	@GetMapping("/calculateTime")
	public ResponseEntity<Long> calculateTime (@Valid @RequestParam(value = "time1", required = true) String time1, @Valid @RequestParam(value = "time2", required = true) String time2){

			return new ResponseEntity<>(Utils.timeCalculate(time1, time2) ,HttpStatus.OK);
	
	}

}
