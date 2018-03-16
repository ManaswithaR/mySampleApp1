package com.mvc.controller;

import java.io.IOException;

import com.mvc.beans.LoginBean;
import com.mvc.beans.MovieBean;
import com.mvc.dao.LoginDao;
import com.mvc.dao.MovieDao;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.include(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
		// HttpSession session= request.getSession();
		// HttpSession session= request.getSession(true);
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		LoginBean loginbean =new LoginBean();
		loginbean.setEmail(email);
		loginbean.setPassword(password);
		LoginDao loginDao =new LoginDao();
		String validateUser=loginDao.loginUser(loginbean);
		//System.out.print(loginbean.getUname());
		PrintWriter out=response.getWriter();
		if( validateUser.equals("SUCCESS")) {
			// ArrayList<MovieBean> mList = MovieDao.movieList();
			 HttpSession session= request.getSession(true);
			 session.setAttribute("email", email);
			 session.setAttribute("pass", password);
			 session.setAttribute("userId", loginbean.getUserId());
			 session.setAttribute("username", loginbean.getUname());
			 System.out.println(session.getAttribute("userId"));
			 
			 response.sendRedirect(request.getContextPath() + "/home");
		}else {
			out.println("<p style='color:red'>login failed</p>");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.include(request, response);
		}
	}



}
