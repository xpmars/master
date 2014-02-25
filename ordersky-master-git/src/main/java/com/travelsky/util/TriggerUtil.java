package com.travelsky.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.scheduling.config.TriggerTask;

import com.travelsky.context.CacheLoder;
import com.travelsky.domain.Order;
import com.travelsky.domain.User;
import com.travelsky.domain.Trigger;

/**
 * @Description: TODO 触发器工具
 * @author chengjun(chengjun@travelsky.com) @2014-2-20
 */
public class TriggerUtil {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(TriggerUtil.class);
	/**
	 * 触发事件
	 */
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);// 获取年份
	int month = calendar.get(Calendar.MONTH);// 获取月份
	int day = calendar.get(Calendar.DATE);// 获取天
	private int hour;
	private int minute;
	private int second;
	private String henchman;

	public void Trigger() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {

				System.out.println(year + "年" + month + "月" + day + "日" + hour + ":" + minute + ":"
						+ second);
				logger.info(year + "年" + month + "月" + day + "日" + hour + ":" + minute + ":"
						+ second + " *************触发器触发***************");
				List<Trigger> triggerList = CacheLoder.cacheTriggerList;
				List<Order> orderList = CacheLoder.cacheOrderList;
				//查找缓存中henchman相关的订单
				for(Order order : orderList){
					if(order.getOrderRcvd().equals(henchman)){
						
						
						System.out.println(order);
						
						
						
						logger.info("将删除内存中 "+henchman+" 对应的订单缓存...");
						
						
						
						
						CacheLoder.cacheOrderList.remove(order);
					}
					
				}
				
				//发送邮件
				try {
					EmailUtil.doSendEmail(henchman, "123");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				for (Trigger trigger : triggerList) {
					if(trigger.getHenchman().equals(henchman)){
						logger.info("将删除内存中 "+henchman+" 对应的缓存触发器");
						CacheLoder.cacheTriggerList.remove(trigger);
					}
				}
				
				
				
		

			}

		};
		/*** 定制每日10：30：00执行方法 ***/
		System.out.println("将在" + year + ":" + month + ":" + day + ":" + hour + ":" + minute + ":"
				+ second + "触发！");
		calendar.set(year, month, day, hour, minute, second);
		Date date = calendar.getTime();
		timer.schedule(task, date);

	}

	/**
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * @param hour
	 *            the hour to set
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * @param minute
	 *            the minute to set
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}

	/**
	 * @return the second
	 */
	public int getSecond() {
		return second;
	}

	/**
	 * @param second
	 *            the second to set
	 */
	public void setSecond(int second) {
		this.second = second;
	}

	public String getHenchman() {
		return henchman;
	}

	public void setHenchman(String henchman) {
		this.henchman = henchman;
	}

}
