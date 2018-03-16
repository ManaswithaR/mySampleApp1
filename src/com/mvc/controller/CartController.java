package com.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.beans.CartBean;

public class CartController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	/*public static ArrayList<CartBean> getShoppingList(){

		
		 CartBean cb=new CartBean();
		// String cartId=cb.getCartId();
		// HttpSession session= request.getSession();
	        //String query = "SELECT * FROM mysampleapp.category_info  INNER JOIN mysampleapp.inventory ON category_info.catinfo__id=inventory.cat_info_id  WHERE category_info.catinfo_id="+cartId;
	               
	}*/
}
