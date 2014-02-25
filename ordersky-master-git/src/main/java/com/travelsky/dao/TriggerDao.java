/**   
* @Title: TriggerDao.java
* @author chengjun(chengjun@travelsky.com) 
* @date 2014-2-27 下午12:39:45  
* @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
*/
package com.travelsky.dao;

import java.util.List;

import com.travelsky.domain.Trigger;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com)  @2014-2-27
 */
public interface TriggerDao {

		public abstract List<Trigger> findTriggerByHenchman(String henchman);

		public abstract List<Trigger> findAll();
		
}

