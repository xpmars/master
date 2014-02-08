/**   
* @Title: Order_Dish.java
* @author chengjun(chengjun@travelsky.com) 
* @date 2014-2-6 下午10:29:33  
* @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
*/
package com.travelsky.domain;

import java.math.BigDecimal;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com)  @2014-2-6
 */
public class Order_Dish {
	private String id;
	private BigDecimal orderId;
	private int dishId;
	/**
	 * @return the orderId
	 */
	public BigDecimal getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(BigDecimal orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the dishId
	 */
	public int getDishId() {
		return dishId;
	}
	/**
	 * @param dishId the dishId to set
	 */
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order_Dish [id=" + id + ", orderId=" + orderId + ", dishId=" + dishId + "]";
	}
	
}
