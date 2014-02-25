/**   
 * @Title: CacheLoder.java
 * @author chengjun(chengjun@travelsky.com) 
 * @date 2014-2-11 上午11:51:11  
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.travelsky.context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.travelsky.action.UserAction;
import com.travelsky.domain.Order;
import com.travelsky.domain.Trigger;
import com.travelsky.domain.User;
import com.travelsky.service.UserService;
import com.travelsky.util.TriggerUtil;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com) @2014-2-11
 */
public class CacheLoder {
	private static Logger logger = Logger.getLogger(CacheLoder.class);
	public  static List<User> cacheUserList = Collections.synchronizedList(new ArrayList<User>());
	public  static List<Order> cacheOrderList = Collections.synchronizedList(new ArrayList<Order>());
	public  static List<Trigger> cacheTriggerList = Collections.synchronizedList(new ArrayList<Trigger>());
	@Autowired
	private UserService userService;
	public void init() {
		logger.info("Load Cache......");
		cacheUserList = userService.findUserByType("订饭官");
		
	}
}
