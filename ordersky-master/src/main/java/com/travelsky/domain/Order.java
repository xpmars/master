package com.travelsky.domain;

import java.io.Serializable;
import java.sql.Date;

public class Order  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6985319482140445260L;
	private Integer orderId;
	private User orderUser;
	private String dishName;
	private Menu menu;
	private Date orderDate;
	private float totalPrice;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public User getOrderUser() {
		return orderUser;
	}
	public void setOrderUser(User orderUser) {
		this.orderUser = orderUser;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderUser=" + orderUser
				+ ", dishName=" + dishName + ", menu=" + menu + ", orderDate="
				+ orderDate + ", totalPrice=" + totalPrice + "]";
	}
	
	
	
	
}
