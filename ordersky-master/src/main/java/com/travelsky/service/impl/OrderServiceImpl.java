/**   
* @Title: OrderServiceImpl.java
* @author chengjun(chengjun@travelsky.com) 
* @date 2014-1-28 上午10:37:20  
* @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
*/
package com.travelsky.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelsky.dao.OrderDao;
import com.travelsky.domain.Order;
import com.travelsky.service.OrderService;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com)  @2014-1-28
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;

	/* (non-Javadoc)
	 * @see com.travelsky.service.OrderService#insertOrder()
	 */
	public int insertOrder(Order order) {
		return orderDao.insertOrder(order);
	}

	/* (non-Javadoc)
	 * @see com.travelsky.service.OrderService#findOrderById(java.lang.String)
	 */
	public Order findOrderById(int orderId) {
		return orderDao.findOrderById(orderId);
	}


	
}
