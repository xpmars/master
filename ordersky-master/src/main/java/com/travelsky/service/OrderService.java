/**   
* @Title: OrderService.java
* @author chengjun(chengjun@travelsky.com) 
* @date 2014-1-28 上午10:34:45  
* @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
*/
package com.travelsky.service;

import com.travelsky.domain.Order;


/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com)  @2014-1-28
 */
public interface OrderService {
	public abstract int insertOrder(Order order);
	public abstract Order findOrderById(int orderId);
}
