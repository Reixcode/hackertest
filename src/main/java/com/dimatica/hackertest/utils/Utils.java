package com.dimatica.hackertest.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.Date;

import javax.mail.internet.MailDateFormat;

import com.dimatica.hackertest.exceptions.BadRequestException;


public class Utils {
	private Utils() {}
	
	public static Long timeCalculate (String date1 , String date2 ) {
		SimpleDateFormat sdf2 = new MailDateFormat ();
		
	
		try {
			Date date3 =sdf2.parse(date1);
			Date date4 = sdf2.parse(date2);
			LocalDateTime instant = date3.toInstant()
				      .atZone(ZoneId.systemDefault())
				      .toLocalDateTime();
			
			LocalDateTime instant2 = date4.toInstant()
				      .atZone(ZoneId.systemDefault())
				      .toLocalDateTime();
			return Math.abs(Duration.between(instant2,instant).toMinutes());
		} catch (ParseException e) {
			throw new BadRequestException(e.getMessage());
		}

		

	}


}
