/**   
* @Title: OrderDao.java
* @author chengjun(chengjun@travelsky.com) 
* @date 2014-1-28 上午10:40:08  
* @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
*/
package com.travelsky.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelsky.dao.OrderDao;
import com.travelsky.domain.Order;
import com.travelsky.domain.User;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com)  @2014-1-28
 */
@Repository
public class OrderDaoImpl implements OrderDao {
	private final String INSERT_ORDER = "insertOrder";
	private final String UPDATE_ORDER = "updateOrder";
	private final String DELETE_ORDER = "deleteOrder";
	private final String FIND_ORDER_BYID = "findOrderById";
	private final String SELECT_ALL_ORDER = "selectAllOrder";
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	/* (non-Javadoc)
	 * @see com.travelsky.dao.OrderDao#insertOrder(com.travelsky.domain.Order)
	 */
	public int insertOrder(Order order) {
System.out.println("Order："+order.toString());
		return sqlSessionTemplate.insert(INSERT_ORDER,order);
	}
	/* (non-Javadoc)
	 * @see com.travelsky.dao.OrderDao#findOrderById(java.lang.String)
	 */
	public Order findOrderById(int orderId) {
		return sqlSessionTemplate.selectOne(FIND_ORDER_BYID,orderId);
	}

}
