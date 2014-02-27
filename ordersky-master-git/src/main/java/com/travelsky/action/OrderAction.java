/**   
 * @Title: OrdersAction.java
 * @author chengjun(chengjun@travelsky.com) 
 * @date 2014-1-28 上午10:11:45  
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.travelsky.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.travelsky.context.CacheLoder;
import com.travelsky.domain.Order;
import com.travelsky.domain.Order_Dish;
import com.travelsky.exception.TriggerException;
import com.travelsky.service.DishService;
import com.travelsky.service.EmailService;
import com.travelsky.service.OrderService;
import com.travelsky.service.impl.TriggerServiceImpl;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com) @2014-1-28
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
	@Autowired
	private EmailService emailService;
	@Autowired
	private TriggerServiceImpl triggerServiceImpl;
	private Order order;
	private String henchman;
	private String orderUser;
	private Order_Dish order_dish;
	private String orderStr;
	private List<Order> orderList;
	private String message; // 使用json返回单个值
	private List<String> inputList;

	public String submit() {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject json = JSONObject.fromObject(map);// 将map对象转换成json类型数据
		//校验-判断订餐者 是否为空，禁止未登录点餐
		if(orderUser == null || ("").equals(orderUser)){
			json.put("code", "1");
			json.put("result", "订单提交失败，请您先登录...");
logger.error("订单提交失败，用户未登录！");
			message = json.toString();// 给result赋值，传递给页面
			return SUCCESS;
		}
		//校验-判断跟随者 是否为空，禁止独自点餐
		if(henchman == null || ("").equals(henchman)){
			json.put("code", "1");
			json.put("result", "订单提交失败，请您选择一个点餐官...");
logger.error("订单提交失败，用户未选择点餐官！");
			message = json.toString();// 给result赋值，传递给页面
			return SUCCESS;
		}
				
		
		//准备提交菜单的数据
logger.info("菜单开始提交......");		
		int totalPrice = 0;
		Order order = new Order();
		Date currentTime = new Date();
		int random = (int) (Math.random() * 10000);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");//订单时间的格式化
		String currentTimeStr = sdf.format(currentTime);
		String orderId = currentTimeStr + random;
		order.setId(new BigDecimal(orderId));
		String[] dishIdArr = orderStr.split(",");
		for (int i = 0; i < dishIdArr.length; i++) {
			int dishId = Integer.parseInt(dishIdArr[i]);
			Order_Dish order_dish = new Order_Dish();
			UUID uuid = UUID.randomUUID();
			String uuidStr = uuid.toString();
			order_dish.setId(uuidStr);
			order_dish.setDishId(dishId);
			order_dish.setOrderId(order.getId());
			order.getOrderdishList().add(order_dish);
			totalPrice += dishService.findDishById(dishId).getPrice();
		}
		order.setOrderRcvd(henchman);
		order.setOrderUser(orderUser);
		order.setTotalPrice(totalPrice);
		order.setOrderDate(new java.sql.Date(currentTime.getTime()));
		System.out.println(order);
		
		
		
		//转入service部分
		int resultNum = 0;
		try {
			resultNum = orderService.insertOrder(order);
		} catch (TriggerException te){
			logger.error("点餐失败，对应点餐官未设置该时段的组团订餐计划！");
			json.put("code", "1");
			json.put("result", "点餐失败，对应点餐官  " + henchman + "未设置该时段的组团订餐计划！");
			message = json.toString();// 给result赋值，传递给页面
			return SUCCESS;
		} catch (Exception e) {
			logger.error("点餐异常！");
			json.put("code", "1");
			json.put("result", "点餐异常");
			message = json.toString();// 给result赋值，传递给页面
			return SUCCESS;
		}
		
		//返回值的设置部分
		json.put("email", order.getOrderRcvd());
		if (dishIdArr.length + 1 == resultNum) {
			logger.info("订单提交成功");
			json.put("code", "0");
			json.put("result", "点餐成功");
			message = json.toString();// 给result赋值，传递给页面
			return SUCCESS;
		} else {
			logger.info("订单提交失败，可能为系统错误");
			json.put("code", "1");
			json.put("result", "订单提交失败，可能为系统错误");
			message = json.toString();// 给result赋值，传递给页面
			return ERROR;
		}
	}

	/**
	 * 
	 */
	private Order findOrderById(int orderId) {
		return orderService.findOrderById(orderId);
	}

	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return logger;
	}

	/**
	 * @param logger
	 *            the logger to set
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
	 * @param session
	 *            the session to set
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
	 * @param orderList
	 *            the orderList to set
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
	 * @param message
	 *            the message to set
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
	 * @param inputList
	 *            the inputList to set
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

	public Order_Dish getOrder_dish() {
		return order_dish;
	}

	public void setOrder_dish(Order_Dish order_dish) {
		this.order_dish = order_dish;
	}

	/**
	 * @return the orderRcvd
	 */
	public String getHenchman() {
		return henchman;
	}

	/**
	 * @param orderRcvd
	 *            the orderRcvd to set
	 */
	public void setHenchman(String henchman) {
		this.henchman = henchman;
	}

	/**
	 * @return the orderUser
	 */
	public String getOrderUser() {
		return orderUser;
	}

	/**
	 * @param orderUser
	 *            the orderUser to set
	 */
	public void setOrderUser(String orderUser) {
		this.orderUser = orderUser;
	}

}
