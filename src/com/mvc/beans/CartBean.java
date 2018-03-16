package com.mvc.beans;

public class CartBean {
	
	public String cartId;
	public String itemName;
	public String itemImgUrl;
	public String itemPrice;
	public String quantity;
	
	
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String price) {
		this.itemPrice = price;
	}
	public String getItemImgUrl() {
		return itemImgUrl;
	}
	public void setItemImgUrl(String itemImgUrl) {
		this.itemImgUrl = itemImgUrl;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	

}
