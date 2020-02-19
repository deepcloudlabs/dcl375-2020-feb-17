package com.example.service.impl;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

import com.example.service.QualityLevel;
import com.example.service.QualityOfService;
import com.example.service.RandomNumberService;

@Service
@QualityOfService(QualityLevel.SECURE)
public class SecureRandomNumberService implements RandomNumberService {
	private SecureRandom secureRandom = new SecureRandom();

	@Override
	public int generate(int min, int max) {
		System.err.println("SecureRandomNumberService::generate");
		return secureRandom.nextInt(max - min + 1) + min;
	}

}
