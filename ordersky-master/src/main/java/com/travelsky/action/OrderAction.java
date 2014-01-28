/**   
* @Title: OrdersAction.java
* @author chengjun(chengjun@travelsky.com) 
* @date 2014-1-28 上午10:11:45  
* @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
*/
package com.travelsky.action;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.travelsky.domain.Order;
import com.travelsky.service.DishService;
import com.travelsky.service.OrderService;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com)  @2014-1-28
 */
@Controller
@Scope("prototype")
public class OrderAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3932421741172282690L;
	private static Logger logger = Logger.getLogger(UserAction.class);
	private Map<String, Object> session;
	@Autowired
	private OrderService orderService;
	@Autowired
	private DishService dishService;
	private Order order;
	private String orderStr;
	private List<Order> orderList;
	private String message;     //使用json返回单个值   
	private List<String> inputList;
	
	public String submit() {
		logger.info("菜单开始提交......");
		int totalPrice = 0;
		Order order = new Order();
		Date currentTime = new Date();
		int random = (int)(Math.random()*10000);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		String currentTimeStr=sdf.format(currentTime);
		String orderId = currentTimeStr+random;
		order.setId(new BigInteger(orderId));
		String[] dishIdArr = orderStr.split(",");
		for (int i = 0; i < dishIdArr.length; i++) {
			int dishId = Integer.parseInt(dishIdArr[i]);
			totalPrice += dishService.findDishById(dishId).getPrice();
		}
		order.setTotalPrice(totalPrice);
		order.setOrderDate(new java.sql.Date(currentTime.getTime()));
		orderService.insertOrder(order);
		
		
		return message;
	}
	/**
	 * 
	 */
	private Order findOrderById(String orderId) {
		return orderService.findOrderById(orderId);
	}
	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return logger;
	}
	/**
	 * @param logger the logger to set
	 */
	public static void setLogger(Logger logger) {
		OrderAction.logger = logger;
	}
	/**
	 * @return the session
	 */
	public Map<String, Object> getSession() {
		return session;
	}
	/**
	 * @param session the session to set
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	/**
	 * @return the orderList
	 */
	public List<Order> getOrderList() {
		return orderList;
	}
	/**
	 * @param orderList the orderList to set
	 */
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the inputList
	 */
	public List<String> getInputList() {
		return inputList;
	}
	/**
	 * @param inputList the inputList to set
	 */
	public void setInputList(List<String> inputList) {
		this.inputList = inputList;
	}
	public String execute() throws Exception {
		return null;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getOrderStr() {
		return orderStr;
	}
	public void setOrderStr(String orderStr) {
		this.orderStr = orderStr;
	}
	
}
