package com.example.world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// http://localhost:9001/world/countries/list
@SpringBootApplication
public class WorldBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorldBootApplication.class, args);
	}

}
