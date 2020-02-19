package com.example;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.service.LotteryService;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext container =
			new AnnotationConfigApplicationContext(
					AppConfig.class);
		List<Integer> numbers = 
			container.getBean(LotteryService.class)
		         .draw();
		System.out.println(numbers);
		container.close();
	}
}
