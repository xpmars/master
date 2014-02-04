/**   
* @Title: Orders.java
* @author chengjun(chengjun@travelsky.com) 
* @date 2014-1-27 下午3:17:41  
* @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
*/
package com.travelsky.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
	private BigDecimal id;
	private String orderUser;
	private Date orderDate;
	private String remark;
	private int totalPrice;
	private String orderRcvd;
	/**
	 * @return the orderId
	 */
	public BigDecimal getId() {
		return id;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setId(BigDecimal id) {
		this.id = id;
	}
	/**
	 * @return the orderUser
	 */
	public String getOrderUser() {
		return orderUser;
	}
	/**
	 * @param orderUser the orderUser to set
	 */
	public void setOrderUser(String orderUser) {
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
	public String getOrderRcvd() {
		return orderRcvd;
	}
	public void setOrderRcvd(String orderRcvd) {
		this.orderRcvd = orderRcvd;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderUser=" + orderUser + ", orderDate=" + orderDate
				+ ", remark=" + remark + ", totalPrice=" + totalPrice + ", orderRcvd=" + orderRcvd
				+ "]";
	}
	
	
}

