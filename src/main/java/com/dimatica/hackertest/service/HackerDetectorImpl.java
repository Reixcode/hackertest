package com.dimatica.hackertest.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dimatica.hackertest.config.HackertestConfig;
import com.dimatica.hackertest.exceptions.BadRequestException;
import com.dimatica.hackertest.model.ItemLine;

@Service
public class HackerDetectorImpl implements HackerDetector{
	@Autowired
    private HackertestConfig dataApp;
	@Override
	public String parseLine(String line) {
		
		Path path = Paths.get("logActivity.txt");
		
		Long result =0L;
		ItemLine  inputLine= new ItemLine(line);
		Stream<String >stream = null;
		
		
		try {
			stream = Files.lines(path);
			result = stream.map(ItemLine::new).filter(p-> p.isSuspiciusIp(inputLine)).collect(Collectors.counting());
		}catch (IOException e) {
			throw new BadRequestException(e.getMessage());
		}finally {
			if (null != stream) 
			   stream.close();
		}
		
		return result>=dataApp.minutes() ? inputLine.getIp() : null;
	}
}
