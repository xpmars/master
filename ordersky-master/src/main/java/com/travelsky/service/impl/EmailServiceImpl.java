/**   
* @Title: EmailServiceImpl.java
* @author chengjun(chengjun@travelsky.com) 
* @date 2014-2-20 下午2:45:06  
* @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
*/
package com.travelsky.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelsky.domain.Order;
import com.travelsky.domain.Order_Dish;
import com.travelsky.service.EmailService;
import com.travelsky.util.EmailUtil;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com)  @2014-2-20
 */
@Service
@Transactional
public class EmailServiceImpl implements EmailService {
	private static Logger logger = Logger.getLogger(EmailServiceImpl.class);
	/* (non-Javadoc)
	 * @see com.travelsky.service.EmailService#sentToOne(java.lang.String, java.lang.String, com.travelsky.domain.Order)
	 */
	
	public void sentToOne(String orderUser, String henchMan, Order order) {
		
		StringBuffer text = new StringBuffer("          饿了吧?不要着急,您的订单号为：");
		
		text.append(order.getId() +",已经提交至： " + henchMan +" 的点餐官！\n" +
				"          共计：" + order.getTotalPrice() +"元.");
		
		
		
		try {
			logger.info("开始向 : " + order.getOrderUser() + ", 发送邮件...");
			EmailUtil.doSendEmail(orderUser, text.toString());
		} catch (Exception e) {
			logger.error("邮件发送失败...");
			e.printStackTrace();
		}
	}
	

	/* (non-Javadoc)
	 * @see com.travelsky.service.EmailService#sentToAll(java.util.List, java.lang.String)
	 */
	public void sentToAll(List<String> rcvdAddList, String text) {
		// TODO Auto-generated method stub

	}


}
