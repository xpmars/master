/**   
 * @Title: OrderDao.java
 * @author chengjun(chengjun@travelsky.com) 
 * @date 2014-1-28 上午10:40:08  
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.travelsky.dao.impl;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelsky.action.UserAction;
import com.travelsky.dao.OrderDao;
import com.travelsky.domain.Order;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com) @2014-1-28
 */
@Repository
public class OrderDaoImpl implements OrderDao {

	private static Logger logger = Logger.getLogger(OrderDaoImpl.class);
	private final String INSERT_ORDER = "insertOrder";
	private final String INSERT_ORDER_DISH = "insertOrderDish";
	private final String UPDATE_ORDER = "updateOrder";
	private final String DELETE_ORDER = "deleteOrder";
	private final String FIND_ORDER_BYID = "findOrderById";
	private final String SELECT_ALL_ORDER = "selectAllOrder";
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.travelsky.dao.OrderDao#insertOrder(com.travelsky.domain.Order)
	 */
	public int insertOrder(Order order) {
		int i = 0;
		int j = 0;
		System.out.println("Order：" + order.toString());
		logger.info("插入订单表记录：");
		i = sqlSessionTemplate.insert(INSERT_ORDER, order);
		logger.info("插入订单关联表记录：");
		j = sqlSessionTemplate.insert(INSERT_ORDER_DISH, order.getOrderdishList());

		System.out.println("返回值：" + (i + j));

		return i + j;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.travelsky.dao.OrderDao#findOrderById(java.lang.String)
	 */
	public Order findOrderById(int orderId) {
		return sqlSessionTemplate.selectOne(FIND_ORDER_BYID, orderId);
	}

}
