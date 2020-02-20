package com.example.imdb;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.imdb.service.MovieService;

public class App {
	// -Dspring.profiles.active=test
	public static void main(String[] args) {
		ConfigurableApplicationContext container = 
				new AnnotationConfigApplicationContext(
						"com.example.imdb.config");
//				new ClassPathXmlApplicationContext(
//						"beans-min.xml");
		container.getBean(MovieService.class).findAllMoviesByYearRangeAndGenre("Drama", 1970, 1979)
				.forEach(System.out::println);
		System.out.println(container.getBean("genres"));
		container.getBeansOfType(Object.class)
		         .forEach((id,component)->{
		        	 System.out.println(id+": "+
		           component.getClass().getSimpleName());
		         });
		container.close();
	}
}
