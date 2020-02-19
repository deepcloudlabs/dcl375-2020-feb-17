package com.example.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.service.QualityLevel;
import com.example.service.QualityOfService;
import com.example.service.RandomNumberService;

@Service
@QualityOfService(QualityLevel.SIMPLE)
public class SimpleRandomNumberService implements RandomNumberService {
	private Random random = new Random();

	@Override
	public int generate(int min, int max) {
		System.err.println("SimpleRandomNumberService::generate");
		return random.nextInt(max-min+1)+min;
	}

}
