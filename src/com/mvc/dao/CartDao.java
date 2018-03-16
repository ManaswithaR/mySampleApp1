package com.mvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import com.mvc.beans.CartBean;
import com.mvc.util.DBConnection;
import com.mysql.jdbc.PreparedStatement;

public class CartDao {
	public static void getShoppingList(ArrayList<CartBean> carts, CartBean cb){

		
		// CartBean cb=new CartBean();
//		String cartId=cb.getCartId();
//		String  title=cb.getItemName();
//		String price=cb.getItemPrice();
		// HttpSession session= request.getSession();
	        //String query = "SELECT * FROM mysampleapp.category_info  INNER JOIN mysampleapp.inventory ON category_info.catinfo__id=inventory.cat_info_id  WHERE category_info.catinfo_id="+cartId;
	       
	        	 
	    /*    con = DBConnection.createConnection();
	   		 statement = con.createStatement();
	   		 resultSet = statement.executeQuery(query);*/
	 
	           
		// ArrayList <sCart> newList = new ArrayList<>();
	        
	                             
					carts.add(cb);
	                JSONArray cartArray =new JSONArray(carts);
	                System.out.println("in caryts dao");
	            System.out.println(cartArray);
	            
	  
	 
	        
	}
	public String  updateOrderList(int userId,int cartId){

//		 Connection con = null;
//		 Statement statement = null;
//		 int resultSet = 0;
		 CartBean cb=new CartBean();
		 Connection con = DBConnection.createConnection();

		 	String status="success";
	        String query = "INSERT INTO mysampleapp.orders (user_id,order_status,cate_info_id) VALUES (?,?,?)"; 
	        try {
	        	 
	        	  PreparedStatement pst = (PreparedStatement) con.prepareStatement(query);
	        	 
	        	  pst.setInt(1, userId);
	        	  pst.setString(2,status);	        	
	        	  pst.setInt(3, cartId);
	        	  pst.executeUpdate();
	 
	            
	 
//	            while(resultSet.next()) {
//	           
//	            	cartId=Integer.toString(resultSet.getInt("catinfo_id"));
//	            	cb.setCartId(cartId);
//	            	cb.setItemName(resultSet.getString("title"));
//	            	cb.setItemImgUrl(resultSet.getString("img")); 
//	            	cb.setItemPrice(Integer.toString(resultSet.getInt("price")));
//	            //	cb.setQuantity(resultSet.getInt("stock"));
//	                             
//	                carts.add(cb);
//	 
//	            }
	   		return "SUCCESS";      
	        }
	 
	    catch(SQLException e) {
	    e.printStackTrace();
	    return null;
	    }
	     
	}
	public String  updateInventory(int quantity,int cartId){

		 Connection con = DBConnection.createConnection();
		  
		
	        try {
	        	 String Sql = "select stock from mysampleapp.inventory where inventory.cat_info_id= "+cartId;
	    		 PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(Sql);    
	    		
	    		 ResultSet rs = pst1.executeQuery();
	    		 rs.beforeFirst();
	    		 rs.next();
	    		 int stock=rs.getInt("stock");
	    		 System.out.println("stock:"+stock);
	    		 	if(quantity == 0) {
	    		 		quantity=5;
	    		 	}else {
	    		 		 System.out.println("quantity:"+quantity);
	    		 		quantity=stock-quantity;
	    		 	}
	    		 	System.out.println("quantity:"+quantity);
	    	       // String query = "INSERT INTO  mysampleapp.inventory (stock) VALUES (?) WHERE inventory.cat_info_id= "+cartId; 
	    	        String sql2="UPDATE  mysampleapp.inventory SET stock = "+quantity+",last_update = CURRENT_TIMESTAMP WHERE inventory.cat_info_id= "+cartId;
	    	        PreparedStatement pst2 = (PreparedStatement) con.prepareStatement(sql2);
	    	        pst2 = (PreparedStatement) con.prepareStatement(sql2);        	
	    	        //pst2.setInt(1, quantity);
	    	        pst2.executeUpdate();
	 
	         
	   		return "SUCCESS";      
	        }
	 
	    catch(SQLException e) {
	    e.printStackTrace();
	    return null;
	    }
	     
	}
}
