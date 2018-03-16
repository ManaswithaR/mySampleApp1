package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.beans.MovieBean;
import com.mvc.beans.ProductBean;
import com.mvc.dao.MovieDao;
import com.mvc.dao.ProductDao;

public class WelcomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
			rd.include(request, response);
	
	}

}
