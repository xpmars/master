package com.travelsky.util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.scheduling.config.TriggerTask;

import com.travelsky.context.CacheLoder;
import com.travelsky.domain.User;

/**
 * @Description: TODO 触发器工具
 * @author chengjun(chengjun@travelsky.com) @2014-2-20
 */
public class TriggerUtil extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(TriggerUtil.class);
	/**
	 * 触发事件
	 */
	private int hour;
	private int minute;
	private int second;
	
	public void init() throws ServletException {
		logger.info("加载触发器线程......");
		List<User> henchmanList = CacheLoder.cacheUserList;
		TriggerSubmit();
	}

	public void TriggerSubmit() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);//获取年份
		int month=calendar.get(Calendar.MONTH);//获取月份 
		int day=calendar.get(Calendar.DATE);//获取日
		
		int hour = 9;
		int minute = 43;
		int second = 00;
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				Calendar calendar = Calendar.getInstance();
				int hour = calendar.get(Calendar.HOUR);//
				int minute=calendar.get(Calendar.MINUTE);//
				int second=calendar.get(Calendar.SECOND);//
				int millsSecond=calendar.get(Calendar.MILLISECOND);//
				
				System.out.println(hour +":"+ minute +":"+ second + ":" +millsSecond);
				System.out.println("*************触发***************");
			}

		};
		
		/*** 定制每日10：30：00执行方法 ***/
		System.out.println("将在" + year+":"+month+":" + day+":" + hour+":" + minute + ":"+ second + "触发！");
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
	 * @param hour the hour to set
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
	 * @param minute the minute to set
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
	 * @param second the second to set
	 */
	public void setSecond(int second) {
		this.second = second;
	}
	
}
