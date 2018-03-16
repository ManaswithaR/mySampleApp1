package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.beans.CartBean;
import com.mvc.beans.ProductBean;
import com.mvc.dao.CartDao;
import com.mvc.dao.ProductDao;

import org.json.*;



public class MovieController extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session= request.getSession(true);
	ProductBean mb=new ProductBean();
	ArrayList<ProductBean> mList = ProductDao.movieList();
	// System.out.println();
	 //request.setAttribute("movies",mList);
	// JSONObject MovieObject =new JSONObject("movies");
	 //System.out.println(MovieObject);
	 JSONArray movieArray =new JSONArray(mList);
	// System.out.println(movieArray);
	 //JSONObject MovieObject =new JSONObject();
	 request.setAttribute("movies",movieArray);
	 
	 
	 RequestDispatcher rd = request.getRequestDispatcher("/movies.jsp");
		rd.include(request, response);
	}
@SuppressWarnings("unchecked")
protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
	HttpSession session= request.getSession(true);
	
	
	ArrayList<CartBean> cartList=null;
	if(session.getAttribute("cart")!= null) {

		cartList= (ArrayList<CartBean>) session.getAttribute("cart");
		JSONArray carList =new JSONArray(cartList);
		System.out.println("inside session array");
		System.out.println(carList);
	}else {
		cartList=new ArrayList<>();
	}
	String prodID=request.getParameter("prodId");
	String title=request.getParameter("title");
	String price=request.getParameter("price");
	String imgUrl=request.getParameter("prodImage");
	String quantity=request.getParameter("quantity");
	CartBean cartb=new CartBean();
	cartb.setCartId(prodID);
	cartb.setItemName(title);
	cartb.setItemPrice(price);
	cartb.setItemImgUrl(imgUrl);
	cartb.setQuantity(quantity);
	System.out.println(title);
	
	System.out.println("size of cartList");
	System.out.println(cartList.size());
//	if(cartList.size()!=0) {
//		for(int i=0;i<cartList.size();) {
//			System.out.println(cartList.get(i).cartId);
//				cartList.add(cartb);
//			//session=null;
//		break;
//	}
//	}else {
//		System.out.println("else block");
//		
//	}
	cartList.add(cartb); 
//	System.out.println(cArray);
	
	//	ArrayList<CartBean> cartList=(ArrayList<CartBean>) session.getAttribute("cart");
//	cartList=CartDao.getShoppingList(cartList,cartb);
//request.getAttribute("movies");
//request.getAttribute(arg0)
//	cartList.add(cb);
	
	JSONArray cArray =new JSONArray(cartList);
	session.setAttribute("cart", cartList);
	//System.out.println("movies");
	//System.out.println(session.getAttribute("cart"));
	//System.out.println(cArray);
	//session.setAttribute("cart", cartList);
	request.setAttribute("carts", cArray);
	response.sendRedirect(request.getContextPath() + "/payment");
}
}
