/**   
 * @Title: OrderServiceImpl.java
 * @author chengjun(chengjun@travelsky.com) 
 * @date 2014-1-28 上午10:37:20  
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.travelsky.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelsky.dao.OrderDao;
import com.travelsky.dao.UserDao;
import com.travelsky.domain.Order;
import com.travelsky.domain.User;
import com.travelsky.service.OrderService;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com) @2014-1-28
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao;

	private static Logger logger = Logger.getLogger(OrderServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.travelsky.service.OrderService#insertOrder()
	 */
	public int insertOrder(Order order) {
		// 插入菜单时，将订餐者的默认跟随者填入
		User henchman = null;
		logger.info("开始向数据库中插入订单...");
		logger.info("取得订餐者信息...");
		User user = userDao.findUserByEmail(order.getOrderUser());
		logger.info("判断订餐着的henchman...");

		String henchmanEmail = order.getOrderRcvd();
		if(henchmanEmail!=null || "".equals(henchmanEmail))
			henchman = userDao.findUserByEmail(henchmanEmail);
		if (henchman != null) {
			user.setHenchman(henchmanEmail);
		} else {
			logger.error("数据库中henchman信息为空，未能成功加上henchman信息...");
		}
		logger.info("更新订餐着的henchman信息...");
		userDao.updateUser(user);

		return orderDao.insertOrder(order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.travelsky.service.OrderService#findOrderById(java.lang.String)
	 */
	public Order findOrderById(int orderId) {
		return orderDao.findOrderById(orderId);
	}

}
