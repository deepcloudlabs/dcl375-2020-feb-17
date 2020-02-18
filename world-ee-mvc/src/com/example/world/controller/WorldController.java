package com.example.world.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.world.dao.CountryDao;
import com.example.world.entity.Country;

// http://localhost:4040/world/list

@WebServlet(urlPatterns = "/list")
public class WorldController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject private CountryDao countryDao;   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("home.jsp")
		       .forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String continent = 
	    		request.getParameter("continent");
	    List<Country> countries = 
	    		countryDao.findCountriesByContinent(
	    				continent);
	    System.out.println(countryDao.getClass());
	    // JSP: ${countries}
	    request.setAttribute("countries", countries);
	    request.getRequestDispatcher("home.jsp")
	           .forward(request, response);
	}

}






