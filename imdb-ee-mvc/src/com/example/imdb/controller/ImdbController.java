package com.example.imdb.controller;

import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.imdb.entity.Movie;
import com.example.imdb.service.MovieService;
import com.example.imdb.view.CriteriaBean;

@WebServlet(urlPatterns = "/search")
public class ImdbController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject private CriteriaBean criteria;
	@Inject private MovieService movieSrv;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int from = extractInteger(request, "from");
		int to = extractInteger(request, "to");
		int genre = extractInteger(request, "genreId");
		criteria.setFromYear(from);
		criteria.setToYear(to);
		criteria.setGenre(genre);
		criteria.setGenreSelected(true);
		criteria.setYearRangeSelected(true);
		Collection<Movie> movies = 
				movieSrv.findAllMoviesByCriteria(
						criteria);
		criteria.setMovies(movies);
		request.getRequestDispatcher("search.jsp")
		       .forward(request, response);		
	}

	private int extractInteger(
		HttpServletRequest request, 
			String name) {
		try {
			return Integer.parseInt(request.getParameter(name));
		} catch (NumberFormatException e) {
		}
		return 1970;
	}

}
