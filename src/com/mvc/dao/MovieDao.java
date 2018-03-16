package com.mvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mvc.beans.MovieBean;
import com.mvc.util.DBConnection;

public class MovieDao {
	public static ArrayList<MovieBean> movieList(){

		 Connection con = null;
		 Statement statement = null;
		 ResultSet resultSet = null;
	 
	        String query = "SELECT * FROM movies INNER JOIN movie_info ON movies.movie_id=movie_info.movie_id";
	        try {
	        	 
	        	con = DBConnection.createConnection();
	   		 statement = con.createStatement();
	   		 resultSet = statement.executeQuery(query);
	 
	            ArrayList<MovieBean> movies = new ArrayList<MovieBean>();
	 
	            while(resultSet.next()) {
	            	MovieBean mb = new MovieBean();
	                mb.setTitle(resultSet.getString("title"));
	                mb.setImgurl(resultSet.getString("imgurl"));
	                mb.setReleased(resultSet.getString("released"));
	                mb.setDirector(resultSet.getString("director"));
	                mb.setActors(resultSet.getString("actors"));
	                mb.setRating(resultSet.getInt("rating"));
	                mb.setDescription(resultSet.getString("descrption"));
	                mb.setTrailer(resultSet.getString("trailer"));
	           
	          
	 System.out.println(mb.getTitle());
	 System.out.println(mb.getImgurl());
	 System.out.println(mb.getReleased());
	                movies.add(mb);
	 
	 
	            }
	            return movies;
	        }
	 
	    catch(SQLException e) {
	    e.printStackTrace();
	    return null;    
	    }
	        
	}
}
