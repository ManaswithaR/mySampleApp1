package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import com.mvc.beans.CartBean;
import com.mvc.beans.ProductBean;
import com.mvc.dao.CartDao;
import com.mvc.dao.ProductDao;

public class TVShowController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(true);
		ProductBean mb=new ProductBean();
		ArrayList<ProductBean> sList = ProductDao.showList();
		 JSONArray showArray =new JSONArray(sList);
		 request.setAttribute("shows",showArray);
		 RequestDispatcher rd = request.getRequestDispatcher("/shows.jsp");
			rd.include(request, response);
		}
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
	        HttpServletResponse response)
	        throws ServletException, IOException {
		HttpSession session= request.getSession(true);
		CartBean cartb=new CartBean();
		
		ArrayList<CartBean> cartList=null;
		if(session.getAttribute("cart")!= null) {

			cartList=(ArrayList<CartBean>) session.getAttribute("cart");
		}else {
			cartList=new ArrayList<>();
		}
		String prodID=request.getParameter("prodId");
		String title=request.getParameter("title");
		String price=request.getParameter("price");
		String imgUrl=request.getParameter("prodImage");
		String quantity=request.getParameter("quantity");
		cartb.setCartId(prodID);
		cartb.setItemName(title);
		cartb.setItemPrice(price);
		cartb.setItemImgUrl(imgUrl);
		cartb.setQuantity(quantity);
		System.out.println(imgUrl);
		System.out.println("size of cartList");
		System.out.println(cartList.size());
//		if(cartList.size()!=0) {
//			for(int i=0;i<cartList.size();) {
//				System.out.println(cartList.get(i).cartId);
//					cartList.add(cartb);
//				//session=null;
//			break;
//		}
//		}else {
//			System.out.println("else block");
//			
//		}
		cartList.add(cartb); 
		 
//		System.out.println(cArray);
		
		//	ArrayList<CartBean> cartList=(ArrayList<CartBean>) session.getAttribute("cart");
//		cartList=CartDao.getShoppingList(cartList,cartb);
	//request.getAttribute("movies");
	//request.getAttribute(arg0)
//		cartList.add(cb);
		
		JSONArray cArray =new JSONArray(cartList);
		System.out.println(cArray);
		session.setAttribute("cart", cartList);
		request.setAttribute("carts", cartList);
		response.sendRedirect(request.getContextPath() + "/payment");
	}
	}
