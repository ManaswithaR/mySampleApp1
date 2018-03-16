package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.mvc.beans.CartBean;
import com.mvc.beans.RegisterBean;
import com.mvc.dao.CartDao;
import com.mvc.dao.LoginDao;

import jdk.nashorn.internal.parser.JSONParser;


	public class PaymentController extends HttpServlet {
		/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
		private static final RegisterBean RegisterBean = null;
		@SuppressWarnings("unchecked")
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session= request.getSession(true);
		CartBean cb=new CartBean();
		RegisterBean rb=new RegisterBean();
		LoginDao loginDao =new LoginDao(); 
		if(session.getAttribute("userId") != null) {
		String uid=(String) session.getAttribute("userId");
		
		int userId= Integer.parseInt(uid);
		rb=loginDao.getUser(userId);
		}
		ArrayList<CartBean> cartList=null;
		if(session.getAttribute("cart")!= null) {
		//	JSONParser parser = new JSONParser();
			 
			cartList=(ArrayList<CartBean>) session.getAttribute("cart");
			int cartTotal=0;
			for(int i=0;i<cartList.size();i++) {
				cartTotal += Integer.parseInt(cartList.get(i).getItemPrice());
			}
			//JSONStringer parser=new JSONStringer();
	//SONArray carts=cartList.
//			//Object obj  = parser.parse(content)
//			System.out.println("in payment");
//			
//	
//	 request.setAttribute("carts",cartList);
			//JSONArray carts= (JSONArray) session.getAttribute("cart");
		//JSONArray carts =cartList.add(e)
		//ONObject cartObject =new JSONObject();
			JSONArray cArray =new JSONArray(cartList);
			 request.setAttribute("user", rb);
			request.setAttribute("total",cartTotal);
		 request.setAttribute("carts",cArray);
		System.out.println(cArray);
			System.out.println("coming here");
			
			//System.out.println(carts);
			//cartList=(ArrayList<CartBean>) session.getAttribute("cart");
		//	System.out.println(carts);
			// JSONObject MovieObject =new JSONObject("movies");
			 //System.out.println(MovieObject);
			//JSONArray carts =new JSONArray("carts");
			// System.out.println(movieArray);
			 //JSONObject MovieObject =new JSONObject();
			 //request.setAttribute("payment",movieArray);
			 
			 
			 RequestDispatcher rd = request.getRequestDispatcher("/payment.jsp");
				rd.include(request, response);
		}else {
			response.sendRedirect(request.getContextPath() + "/home");
		}
			}
		
		@SuppressWarnings("unchecked")
		protected void doPost(HttpServletRequest request,
		        HttpServletResponse response)
		        throws ServletException, IOException {
				HttpSession session= request.getSession();
				response.setContentType("text/html");  
				//ArrayList<CartBean> cartList=CartDao.getShoppingList();
				//request.getAttribute("movies");
				//session.setAttribute("carts", cartList);
				String cartId=request.getParameter("cartId");
				String actionType=request.getParameter("action");
				String fname=request.getParameter("firstname");
				String lname=request.getParameter("lastname");
				String email=request.getParameter("email");
				String cardType=request.getParameter("cardtype");
				String cardNum=request.getParameter("cardnumber");
				String cvv=request.getParameter("cvv");
				String expYear=request.getParameter("expiryYear");
				String expMonth=request.getParameter("expiryMonth");
				String streetaddr1=request.getParameter("streetaddress1");
				String streetaddr2=request.getParameter("streetaddress2");
				String city=request.getParameter("city");
				String state=request.getParameter("state");
				String country=request.getParameter("country");
				String zip=request.getParameter("zipcode");
				String quantity=request.getParameter("quantity");
				ArrayList<CartBean> cartList=null;
				PrintWriter out=response.getWriter();
				System.out.println("print quantity");
				System.out.println(quantity);
				
				if(actionType.equals("remove")) 
				{
					
					cartList=(ArrayList<CartBean>) session.getAttribute("cart");
					System.out.println(cartId);
					for(int i=0;i<cartList.size();i++) {
						if(cartList.get(i).getCartId().equals(cartId)) {
							cartList.remove(i);
						}
					}
					session.setAttribute("cart", cartList);
					System.out.println(cartList);
					response.sendRedirect(request.getContextPath() + "/payment");
					
				}else {
					if(fname.isEmpty()== true || lname.isEmpty()== true || email.isEmpty()== true ||cardType.isEmpty()== true || cardNum.isEmpty()== true || cvv.isEmpty()== true || expYear.isEmpty()== true || expMonth.isEmpty()== true || streetaddr1.isEmpty()== true || city.isEmpty()== true || state.isEmpty()== true || country.isEmpty()== true || zip.isEmpty()== true || quantity.isEmpty() == true)
					{
						
						out.println("<div class='row col-xs-12'><span class='col-xs-6 alert alert-danger'>Form is Invalid</span></div>");
						response.sendRedirect(request.getContextPath() + "/payment");
					}else {
						if(cardNum.equals("4111111111111111") && cvv.equals("123")) {
							out.println("<span class='col-xs-6 alert alert-succeess'>success</span>");
							CartDao cd=new CartDao();
							int userId=Integer.parseInt((String) session.getAttribute("userId"));
							cartList=(ArrayList<CartBean>) session.getAttribute("cart");
							System.out.println("post payment");
							System.out.println(cartList);
							String orderStatus=null;
							String inventoryStatus=null;
							for(int i=0;i<cartList.size();i++) {
								int crtId=Integer.parseInt((String)cartList.get(i).getCartId()); 
								int stock=Integer.parseInt((String) quantity);
								System.out.println(crtId);
								 orderStatus=cd.updateOrderList(userId, crtId);	
								 inventoryStatus=cd.updateInventory(stock, crtId);
								
							}
							//System.out.println(cartId);
							//int crtId=Integer.parseInt((String) cartId);
						
							//String orderStatus=cd.updateOrderList(userId, crtId);
							if(orderStatus.equals("SUCCESS") && inventoryStatus.equals("SUCCESS")) {
								response.sendRedirect(request.getContextPath() + "/home");
							}
							
						}else {
							out.println("<span class='col-xs-6 alert alert-warning'>invalid card number/cvv</span>");
						}
					}
				}
				
				JSONArray cArray =new JSONArray(cartList);
				System.out.println("payment post");
			
		}
		}
