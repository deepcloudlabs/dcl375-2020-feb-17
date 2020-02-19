package com.example.imdb.config;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.imdb.entity.Genre;
import com.example.imdb.service.MovieService;

@Configuration
@ComponentScan(basePackages = "com.example.imdb")
public class AppConfig {
	@Autowired private MovieService movieSrv;
    @Bean
    public Collection<String> genres(){
    	return movieSrv.findAllGenres()
    			       .stream()
    			       .map(Genre::getName)
    			       .sorted()
    			       .collect(Collectors.toList());
    }
}
