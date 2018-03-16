package com.mvc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mvc.util.DBConnection;
import com.mvc.beans.RegisterBean;
public class RegisterDao {
	 public String registerUser(RegisterBean registerBean)
	 {
	 String fname = registerBean.getFirstname();
	 String lname = registerBean.getLastname();
	 String email = registerBean.getEmail();
	 String password = registerBean.getPassword();
	 String strtaddr1 =registerBean.getStreetaddress1();
	 String strtaddr2 =registerBean.getStreetaddress2();
	 String city=registerBean.getCity();
	 String state = registerBean.getState();
	 String country = registerBean.getCountry();
	 String zip= registerBean.getZipcode();
	 
	 Connection con = null;
	 PreparedStatement preparedStatement = null;
	 try
	 {
	 con = DBConnection.createConnection();
	 String query = "insert into user(firstname,lastname,email,password,streetaddress1,streetaddress2,city,state,country,zipcode) values (?,?,?,?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
	 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
	 preparedStatement.setString(1, fname);
	 preparedStatement.setString(2, lname);
	 preparedStatement.setString(3, email);
	 preparedStatement.setString(4, password);
	 preparedStatement.setString(5, strtaddr1);
	 preparedStatement.setString(6, strtaddr2);
	 preparedStatement.setString(7, city);
	 preparedStatement.setString(8, state);
	 preparedStatement.setString(9, country);
	 preparedStatement.setString(10, zip);
	 int i= preparedStatement.executeUpdate();
	 if (i>0)  //Just to ensure data has been inserted into the database
	 return "SUCCESS"; 
	 }
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 
	 return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	 }
	}
