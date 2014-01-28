/**   
* @Title: Orders.java
* @author chengjun(chengjun@travelsky.com) 
* @date 2014-1-27 下午3:17:41  
* @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
*/
package com.travelsky.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com)  @2014-1-27
 */
public class Order  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6985319482140445260L;
	private BigInteger id;
	private User orderUser;
	private Date orderDate;
	private String remark;
	private int totalPrice;
	/**
	 * @return the orderId
	 */
	public BigInteger getId() {
		return id;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}
	/**
	 * @return the orderUser
	 */
	public User getOrderUser() {
		return orderUser;
	}
	/**
	 * @param orderUser the orderUser to set
	 */
	public void setOrderUser(User orderUser) {
		this.orderUser = orderUser;
	}
	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * @return the totalPrice
	 */
	public int getTotalPrice() {
		return totalPrice;
	}
	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}

