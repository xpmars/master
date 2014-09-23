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

import org.springframework.beans.factory.annotation.Autowired;

import com.travelsky.domain.Order;
import com.travelsky.domain.User;
import com.travelsky.service.UserService;
import com.travelsky.util.TriggerUtil;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com) @2014-2-11
 */
public class CacheLoder {
	public  static List<User> cacheUserList = Collections.synchronizedList(new ArrayList<User>());
	public  static List<Order> cacheOrderList = Collections.synchronizedList(new ArrayList<Order>());
	@Autowired
	private UserService userService;
	public void init() {
		System.out.println("Load Cache......");
		cacheUserList = userService.findUserByType("订饭官");
		System.out.println("加载触发器线程......");
	}
}
