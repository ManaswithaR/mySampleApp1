package com.mvc.dao;
import java.sql.Connection;
import java.sql.Statement;

import org.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mvc.beans.LoginBean;
import com.mvc.beans.RegisterBean;
import com.mvc.util.DBConnection;

public class LoginDao{
	 public String loginUser(LoginBean LoginBean) {

		 String email=LoginBean.getEmail();
		 String pass=LoginBean.getPassword();
		 
		 Connection con = null;
		 Statement statement = null;
		 ResultSet resultSet = null;
		 
		 
		 try
		 {
		 con = DBConnection.createConnection();
		 statement = con.createStatement();
		 resultSet = statement.executeQuery("select * from user");
		 while(resultSet.next()) // Until next row is present otherwise it return false
		 {
		 String emailDB = resultSet.getString("email"); //fetch the values present in database
		 String passwordDB = resultSet.getString("password");
		 String UId= Integer.toString(resultSet.getInt("id"));
		// String userName=resultSet.getString("firstname") +" "+resultSet.getString("lastname");
		 LoginBean.setUserId(UId);
		 String userName=resultSet.getString("firstname") +" "+resultSet.getString("lastname");
		 LoginBean.setUname(userName);
		   if(email.equals(emailDB) && pass.equals(passwordDB))
		   {
		      return "SUCCESS"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
		   }
		 }
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 return "Invalid user credentials"; // Just returning appropriate message otherwise
		 }
	 public RegisterBean getUser(int userId) {
		RegisterBean rb=new RegisterBean();
//		 String email=rb.getEmail();
//		 String pass=rb.getPassword();
//		 String firstName=rb.getFirstname();
//		 String lastName=rb.getLastname();
//		 String staddr1=rb.getStreetaddress1();
//		 String staddr2=rb.getStreetaddress2();
//		 String city=rb.getCity();
//		 String state=rb.getState();
//		 String country=rb.getCountry();
//		 String zip=rb.getZipcode();
		 
		 Connection con = null;
		 Statement statement = null;
		 ResultSet resultSet = null;
		 
		 
		 try
		 {
		 con = DBConnection.createConnection();
		 statement = con.createStatement();
		 resultSet = statement.executeQuery("select * from user where user.id="+userId);
		 while(resultSet.next()) // Until next row is present otherwise it return false
		 {
		 String emailDB = resultSet.getString("email"); //fetch the values present in database
		 String passwordDB = resultSet.getString("password");
		 String Uid= Integer.toString(resultSet.getInt("id"));
		 rb.setUserID(Uid);
		 rb.setFirstname(resultSet.getString("firstname"));
		 rb.setLastname(resultSet.getString("lastname"));
		 rb.setStreetaddress1(resultSet.getString("streetaddress1"));
		 rb.setStreetaddress2(resultSet.getString("streetaddress2"));
		 rb.setCity(resultSet.getString("city"));
		 rb.setState(resultSet.getString("state"));
		 rb.setCountry(resultSet.getString("country"));
		 rb.setZipcode(resultSet.getString("zipcode"));
		 return rb;
		 }
		
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		// // Just returning appropriate message otherwise
		return rb;
		
}
}