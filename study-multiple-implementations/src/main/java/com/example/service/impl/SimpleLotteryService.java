package com.example.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.example.service.LotteryService;
import com.example.service.QualityLevel;
import com.example.service.QualityOfService;
import com.example.service.RandomNumberService;

@SuppressWarnings("unused")
@Service
public class SimpleLotteryService implements LotteryService {
	private RandomNumberService randomNumberService;
	@Value("${random.number.service}")
	private String randomNumberServiceName;

	@Autowired
	private ApplicationContext container;

	@Autowired
	@QualityOfService(QualityLevel.SIMPLE)
	@QualityOfService(QualityLevel.FAST)
	private List<RandomNumberService> randomServices;

	private int counter;

	@PostConstruct
	public void init() {
		randomServices.stream().map(Object::getClass).map(Class::getName).forEach(System.err::println);
		randomNumberService = container.getBean(randomNumberServiceName, RandomNumberService.class);
	}

	@Override
	public List<Integer> draw() {
		return IntStream.generate(this::generateRandom).distinct().limit(6).sorted().boxed()
				.collect(Collectors.toList());
	}

	public int generateRandom() {
//		int index = counter++ % randomServices.size();
//		randomNumberService = randomServices.get(index);
		return randomNumberService.generate(1, 50);
	}
}
