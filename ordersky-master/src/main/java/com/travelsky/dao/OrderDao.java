/**   
* @Title: OrderDao.java
* @author chengjun(chengjun@travelsky.com) 
* @date 2014-1-28 上午10:38:52  
* @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
*/
package com.travelsky.dao;

import com.travelsky.domain.Order;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com)  @2014-1-28
 */
public interface OrderDao {
	public abstract int insertOrder(Order order);
	
	public abstract Order findOrderById(String orderId);
}
