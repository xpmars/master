/**   
 * @Title: EmailService.java
 * @author chengjun(chengjun@travelsky.com) 
 * @date 2014-2-20 下午2:44:05  
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.travelsky.service;

import java.util.List;

import com.travelsky.domain.Order;
import com.travelsky.exception.EmailException;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com) @2014-2-20
 */
public interface EmailService {
	public abstract void sentToOne(String orderUser,String henchMan,Order order) throws EmailException;

	public abstract void sentToAll(List<String> userList, String text) throws EmailException;
	
	public abstract void sentToHenchman(String henchman) throws EmailException;
}
