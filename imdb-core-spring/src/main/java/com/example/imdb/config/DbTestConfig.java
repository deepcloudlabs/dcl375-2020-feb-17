package com.example.imdb.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:database-test.properties"})
@Profile("test")
public class DbTestConfig {
	@Value("${database.hostname}") // SpEL
	private String hostname;
	@Value("${database.port}")
	private int port;
	@Value("${database.username}")
	private String username;
	@Value("${database.password}")
	private String password;
	
	@PostConstruct
	public void init() {
		System.out.println(hostname+":"+port);
	}
}
