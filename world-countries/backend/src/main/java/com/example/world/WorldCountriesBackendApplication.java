package com.example.world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 
 * @author Binnur Kurt (binnur.kurt@gmail.com)
 *
 */
@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackages = {
	"com.example.world.controller",
	"com.example.world.dao"
})
public class WorldCountriesBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorldCountriesBackendApplication.class, args);
	}
}
