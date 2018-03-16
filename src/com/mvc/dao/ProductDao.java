package com.mvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mvc.beans.ProductBean;
import com.mvc.util.DBConnection;

public class ProductDao {
	public static ArrayList<ProductBean> movieList(){

		 Connection con = null;
		 Statement statement = null;
		 ResultSet resultSet = null;
	 
	        String query = "SELECT * FROM mysampleapp.category  INNER JOIN mysampleapp.category_info ON category.cat_id=category_info.cat_id INNER JOIN mysampleapp.inventory ON category_info.catinfo_id=inventory.cat_info_id INNER JOIN mysampleapp.category_attributes ON category_info.catinfo_id=category_attributes.catinfo_id WHERE category.cat_type='movies'";
	        try {
	        	 
	        con = DBConnection.createConnection();
	   		 statement = con.createStatement();
	   		 resultSet = statement.executeQuery(query);
	 
	            ArrayList<ProductBean> movies = new ArrayList<ProductBean>();
	 
	            while(resultSet.next()) {
	            	ProductBean mb = new ProductBean();
	            	String prodId=Integer.toString(resultSet.getInt("catinfo_id"));
	            	mb.setProductID(prodId);
	            	 mb.setProductType(resultSet.getString("cat_type"));
	                mb.setProductTitle(resultSet.getString("title"));
	                mb.setImgLink(resultSet.getString("img"));
	                mb.setReleased(resultSet.getString("released"));
//	                mb.setDirector(resultSet.getString("director"));
//	                mb.setCrew(resultSet.getString("actors"));
	                mb.setRating(resultSet.getInt("rating"));
	                mb.setDescription(resultSet.getString("description"));
	                mb.setPrice(resultSet.getInt("price"));
	                mb.setQuantity(Integer.toString(resultSet.getInt("stock")));
	                if(resultSet.getString("attr_name").equals("trailer")) {
	                mb.setTrailer(resultSet.getString("atte_value"));
	               
	                
	                }
	          
	
	                
	                movies.add(mb);
	 
	 
	            }
	            return movies;
	        }
	 
	    catch(SQLException e) {
	    e.printStackTrace();
	    return null;    
	    }
	        
	}
	public static ArrayList<ProductBean> bookList(){

		 Connection con = null;
		 Statement statement = null;
		 ResultSet resultSet = null;
	 
	        String query = "SELECT * FROM mysampleapp.category  INNER JOIN mysampleapp.category_info ON category.cat_id=category_info.cat_id  INNER JOIN mysampleapp.inventory ON category_info.catinfo_id=inventory.cat_info_id INNER JOIN mysampleapp.category_attributes ON category_info.catinfo_id=category_attributes.catinfo_id WHERE category.cat_type='books'";
	        try {
	        	 
	        con = DBConnection.createConnection();
	   		 statement = con.createStatement();
	   		 resultSet = statement.executeQuery(query);
	 
	            ArrayList<ProductBean> books = new ArrayList<ProductBean>();
	 
	            while(resultSet.next()) {
	            	ProductBean mb = new ProductBean();
	            	String prodId=Integer.toString(resultSet.getInt("catinfo_id"));
	            	mb.setProductID(prodId);
	            	 mb.setProductType(resultSet.getString("cat_type"));
	                mb.setProductTitle(resultSet.getString("title"));
	                mb.setImgLink(resultSet.getString("img"));
	                mb.setReleased(resultSet.getString("released"));
//	                mb.setDirector(resultSet.getString("director"));
//	                mb.setCrew(resultSet.getString("actors"));
	                mb.setRating(resultSet.getInt("rating"));
	                mb.setDescription(resultSet.getString("description"));
	                mb.setPrice(resultSet.getInt("price"));
	                mb.setQuantity(Integer.toString(resultSet.getInt("stock")));
	           	                if(resultSet.getString("attr_name").equals("author")) {
		                mb.setAuthor(resultSet.getString("atte_value"));
		                }
	          
	
	                //System.out.println(resultSet.getString("atte_value"));
	                books.add(mb);
	 
	 
	            }
	            return books;
	        }
	 
	    catch(SQLException e) {
	    e.printStackTrace();
	    return null;    
	    }
	        
	}
	public static ArrayList<ProductBean> showList(){

		 Connection con = null;
		 Statement statement = null;
		 ResultSet resultSet = null;
	 
	        String query = "SELECT * FROM mysampleapp.category  INNER JOIN mysampleapp.category_info ON category.cat_id=category_info.cat_id INNER JOIN mysampleapp.inventory ON category_info.catinfo_id=inventory.cat_info_id INNER JOIN mysampleapp.category_attributes ON category_info.catinfo_id=category_attributes.catinfo_id WHERE category.cat_type='shows'";
	        try {
	        	 
	        con = DBConnection.createConnection();
	   		 statement = con.createStatement();
	   		 resultSet = statement.executeQuery(query);
	 
	            ArrayList<ProductBean> shows = new ArrayList<ProductBean>();
	 
	            while(resultSet.next()) {
	            	ProductBean mb = new ProductBean();
	            	String prodId=Integer.toString(resultSet.getInt("catinfo_id"));
	            	mb.setProductID(prodId);
	                mb.setProductTitle(resultSet.getString("title"));
	                mb.setProductType(resultSet.getString("cat_type"));
	                mb.setImgLink(resultSet.getString("img"));
	                mb.setReleased(resultSet.getString("released"));
//	                mb.setDirector(resultSet.getString("director"));
//	                mb.setCrew(resultSet.getString("actors"));
	                mb.setRating(resultSet.getInt("rating"));
	                mb.setDescription(resultSet.getString("description"));
	                mb.setPrice(resultSet.getInt("price"));
	                mb.setQuantity(Integer.toString(resultSet.getInt("stock")));
	                if(resultSet.getString("attr_name").equals("trailer")) {
	                mb.setTrailer(resultSet.getString("atte_value"));
	                }
	               
		             mb.setDirector("James kenny");
		                
	
	               // System.out.println(resultSet.getString("atte_value"));
	                shows.add(mb);
	 
	 
	            }
	            return shows;
	        }
	 
	    catch(SQLException e) {
	    e.printStackTrace();
	    return null;    
	    }
	        
	}
}
