/**   
* @Title: EmailServiceImpl.java
* @author chengjun(chengjun@travelsky.com) 
* @date 2014-2-20 下午2:45:06  
* @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
*/
package com.travelsky.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelsky.context.CacheLoder;
import com.travelsky.dao.DishDao;
import com.travelsky.dao.OrderDao;
import com.travelsky.domain.Dish;
import com.travelsky.domain.Order;
import com.travelsky.domain.Order_Dish;
import com.travelsky.service.EmailService;
import com.travelsky.util.EmailUtil;

/**
 * @Description: TODO 发邮件
 * @author chengjun(chengjun@travelsky.com)  @2014-2-20
 */
@Service
@Transactional
public class EmailServiceImpl implements EmailService {
	private static Logger logger = Logger.getLogger(EmailServiceImpl.class);
	
	@Autowired
	private DishDao dishDao;
	
	
	/* (non-Javadoc)
	 * @see com.travelsky.service.EmailService#sentToOne(java.lang.String, java.lang.String, com.travelsky.domain.Order)
	 */
	
	public void sentToOne(String orderUser, String henchMan, Order order) {
		
		StringBuffer text = new StringBuffer("		饿了吧?不要着急,您的订单号为：" + order.getId() + "\n");			
		
		List<Order_Dish> Order_Dish_List = order.getOrderdishList();

		for (Order_Dish order_Dish : Order_Dish_List) {
			Dish dish = dishDao.findDishById(order_Dish.getDishId());
			text.append("				" + dish.getId() + "    " + dish.getDishName() + "\n");
		}
		text.append("-----------------------------------------------------------"+"\n");
		text.append("已经提交至： " + henchMan +" 的点餐官！\n" +
				"          共计：" + order.getTotalPrice() +"元.\n");
		try {
			logger.info("开始向 : " + order.getOrderUser() + ", 发送邮件...");
			EmailUtil.doSendEmail(orderUser, text.toString());
		} catch (Exception e) {
			logger.error("邮件发送失败...");
			e.printStackTrace();
		}
	}
	
	public void sentToHenchman(String henchMan) {
		StringBuffer text = new StringBuffer("*********************订单表********************* ");
		List<Order> orderList = CacheLoder.cacheOrderList;
		int countPrice = 0;
		
		text.append("餐厅名："+ " 还没起名字！ ");
		for (Order order : orderList) {
			text.append("    "+order.getOrderUser());
			int countPriceForOne = 0;
			List<Order_Dish> Order_Dish_List = order.getOrderdishList();
			for (Order_Dish order_Dish : Order_Dish_List) {
				Dish dish = dishDao.findDishById(order_Dish.getDishId());
				text.append("    "+dish.getId() + "    " + dish.getDishName() + "    " + dish.getPrice() + "\n");
				countPriceForOne += dish.getPrice();
			}
			countPrice += countPriceForOne;
			text.append("    合计："+countPrice +"\n");
			text.append("--------------------------------------------------------" + "\n");
		}
		text.append("=========================================================" + "\n");
		text.append("总计：" + countPrice + "元。" + " \n");
		text.append("赶紧拨打电话，"+"  553475952  "+"帮助小伙伴订餐吧~");
		
			try {
				logger.info("开始向 : " + henchMan + ", 发送邮件...");
				EmailUtil.doSendEmail(henchMan, text.toString());
			} catch (Exception e) {
				logger.error("邮件发送失败...");
				e.printStackTrace();
			}
	}

	/* (non-Javadoc)
	 * @see com.travelsky.service.EmailService#sentToAll(java.util.List, java.lang.String)
	 */
	public void sentToAll(List<String> userList, String text) {
		// TODO Auto-generated method stub
		
	}



}
