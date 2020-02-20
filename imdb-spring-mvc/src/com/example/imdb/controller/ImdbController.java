package com.example.imdb.controller;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

import com.example.imdb.entity.Genre;
import com.example.imdb.entity.Movie;
import com.example.imdb.service.MovieService;
import com.example.imdb.view.CriteriaBean;

@Controller
@RequestScope
@RequestMapping("search")
public class ImdbController {
	@Autowired
	private MovieService movieSrv;

	@ModelAttribute("genres") // ${genres}
	public Collection<Genre> getAllGenres() {
		return movieSrv.findAllGenres();
	}

	@GetMapping
	public String home() {
		return "search";
	}

	@PostMapping
	public String search(
	@ModelAttribute("imdb") CriteriaBean criteria) {
		Comparator<Movie> comparator = 
				comparing(Movie::getTitle);
		if ("year".equals(criteria.getAction())) {
			comparator = comparing(Movie::getYear);
		}
		Collection<Movie> movies = 
				movieSrv.findAllMoviesByCriteria(criteria)
				.stream().sorted(comparator)
				.collect(toList());
		criteria.setMovies(movies);
		return "search";
	}
}
