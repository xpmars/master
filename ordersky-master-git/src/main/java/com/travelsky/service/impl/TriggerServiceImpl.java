/**   
 * @Title: TriggerServiceImpl.java
 * @author chengjun(chengjun@travelsky.com) 
 * @date 2014-2-26 下午5:05:28  
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.travelsky.service.impl;

import java.util.List;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelsky.context.CacheLoder;
import com.travelsky.dao.TriggerDao;
import com.travelsky.domain.Order;
import com.travelsky.domain.Trigger;
import com.travelsky.exception.TriggerException;
import com.travelsky.service.TriggerService;
import com.travelsky.util.TriggerUtil;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com) @2014-2-26
 */
@Service
@Transactional
public class TriggerServiceImpl implements TriggerService {
	private static Logger logger = Logger.getLogger(TriggerServiceImpl.class);
	@Autowired
	private TriggerDao triggerDao;
	@Autowired
	private TriggerUtil activedTrigger;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.travelsky.service.TriggerService#TriggerSubmit()
	 */
	public void triggerSubmit(String orderUser, String henchman, Order order) throws Exception {
		int min = 240000;
		// 缓存中的触发器triggerCacheList
		List<Trigger> triggerCacheList = CacheLoder.cacheTriggerList;
		// triggerTime，订餐产生时间的数字表示 用一个十万位大小的数字表示
		int triggerTime = Integer.parseInt(order.getId().toString().substring(8, 14));
System.out.println("订单时间：" + triggerTime);
		// 查看缓存triggerCacheList中是否含有henchman对应的触发器
		for (Trigger trigger : triggerCacheList) {
			// 若有该触发器，跳出触发器处理的方法
			if (trigger.getHenchman().equals(henchman))//已经含有对应henchman的触发器
				return ;
		}
		
		// 缓存中没有对应henchman的触发器
		// 需要从数据库中取出对应henman的触发器triggerList，
		// 并将最近触发时间用min表示，并取出最近将要触发的触发器，并加到缓存中
		List<Trigger> triggerList = triggerDao.findTriggerByHenchman(henchman);
		Trigger triggerTemp = null;
		if (triggerList.size() > 0 && triggerList != null) {
			int triggerTime2 = 0;
			for (Trigger trigger : triggerList) {
				triggerTime2 = trigger.getHour() * 10000 + trigger.getMinute() * 100
						+ trigger.getSecond();
				if (triggerTime2 > triggerTime && min > triggerTime2) {
					min = triggerTime2;
					triggerTemp = trigger;
				}
			}
		} else {
			logger.error(orderUser + ":点餐失败，没有对应订餐官的点餐触发事件");
			throw new TriggerException("点餐失败，没有对应订餐官的点餐触发事件");
		}
System.out.println("最近订餐时间：" + min);
		if(min==240000){
			throw new TriggerException("点餐已经结束，请明天点餐。");
		}
		
		// 激活触发器，并设定触发时间
		activedTrigger.setHour(min / 10000);
		activedTrigger.setMinute(min % 10000 / 100);
		activedTrigger.setSecond(min % 100);
		activedTrigger.setHenchman(henchman);
		// 将该触发器加入到缓存列表中
		CacheLoder.cacheTriggerList.add(triggerTemp);

		activedTrigger.Trigger();

		System.out.println(triggerTemp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.travelsky.service.TriggerService#clearTrigger()
	 */
	public void clearTrigger() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.travelsky.service.TriggerService#addTrigger()
	 */
	public void addTrigger() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.travelsky.service.TriggerService#hasTrigger()
	 */
	public boolean hasTrigger() {
		// TODO Auto-generated method stub
		return false;
	}

}
