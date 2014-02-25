/**   
* @Title: TriggerService.java
* @author chengjun(chengjun@travelsky.com) 
* @date 2014-2-26 下午5:02:36  
* @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
*/
package com.travelsky.service;

import com.travelsky.domain.Order;

/**
 * @Description: 触发器服务
 * @author chengjun(chengjun@travelsky.com)  @2014-2-26
 */
public interface TriggerService {
	public abstract void clearTrigger();
	public abstract void addTrigger();
	public abstract boolean hasTrigger();
	public abstract void triggerSubmit(String orderUser, String henchMan, Order order);
}
