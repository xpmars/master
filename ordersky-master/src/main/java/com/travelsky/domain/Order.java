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
	private Dish dish;
	private Date orderDate;
	private float totalPrice;
	
	
}
