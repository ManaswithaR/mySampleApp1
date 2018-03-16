package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.beans.MovieBean;
import com.mvc.dao.MovieDao;

public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(true);
		if(request.getSession(false) != null) {
		 RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
			rd.include(request, response);
		}else {
			 response.sendRedirect(request.getContextPath() + "/login");
		}
	}
	  protected void doPost(HttpServletRequest request,
	            HttpServletResponse response)
	            throws ServletException, IOException {
	        
	    }
	

	

}
