package com.dimatica.hackertest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class HackertestConfig {
	@Value("${hackertest.minutes:minutes}")
	private Long minutes;
	
	@Bean
	public Long minutes () {
		return minutes;
	}
}
