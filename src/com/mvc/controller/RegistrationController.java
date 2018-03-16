package com.mvc.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.beans.RegisterBean;
import com.mvc.dao.RegisterDao;
public class RegistrationController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/Registration.jsp");
		rd.include(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String fname=request.getParameter("firstname");
	String lname=request.getParameter("lastname");
	String email=request.getParameter("email");
	String pass=request.getParameter("password");
	String staddr1=request.getParameter("streetaddress1");
	String staddr2=request.getParameter("streetaddress2");
	String city=request.getParameter("city");
	String state=request.getParameter("state");
	String country=request.getParameter("country");
	String zip=request.getParameter("zipcode");
	PrintWriter pw=response.getWriter();
if(fname.isEmpty() || lname.isEmpty() ||  email.isEmpty() || pass.isEmpty() || staddr1.isEmpty() || city.isEmpty() || state.isEmpty() || country.isEmpty() || zip.isEmpty() ) {
		
		pw.println("<p style='color:red'>Form is Invalid</p>");
		RequestDispatcher rd = request.getRequestDispatcher("/Registration.jsp");
		rd.include(request, response);
	}else {
		
	
	RegisterBean registerBean = new RegisterBean();
	registerBean.setFirstname(fname);
	registerBean.setLastname(lname);
	registerBean.setEmail(email);
	registerBean.setPassword(pass);
	registerBean.setStreetaddress1(staddr1);
	registerBean.setStreetaddress2(staddr2);
	registerBean.setCity(city);
	registerBean.setState(state);
	registerBean.setCountry(country);
	registerBean.setZipcode(zip);
	 RegisterDao registerDao = new RegisterDao();
	 String userRegistered = registerDao.registerUser(registerBean);
	
	
	System.out.println(userRegistered);
	
	if(userRegistered.equals("SUCCESS") ) {
		pw.println("<p style='color:green'>Registartion Successful, please login with email and password</p>");
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.include(request, response);
		
	}else {
		pw.println("<p style='color:red'>Form is Invalid</p>");
		RequestDispatcher rd = request.getRequestDispatcher("/Registration.jsp");
		rd.include(request, response);
	}
	}
	}
}