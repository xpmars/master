package com.travelsky.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.scheduling.config.TriggerTask;

/**
 * @Description: TODO 触发器工具
 * @author chengjun(chengjun@travelsky.com) @2014-2-20
 */
public class TriggerUtil extends HttpServlet {

	public void init() throws ServletException {
		TriggerSubmit();
	}

	public void TriggerSubmit() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				System.out.println("*************触发***************");
			}

		};
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);//获取年份
		int month=calendar.get(Calendar.MONTH);//获取月份 
		int day=calendar.get(Calendar.DATE);//获取日
		
		int hour = 00;
		int minute = 39;
		int second = 00;
		/*** 定制每日10：30：00执行方法 ***/
		System.out.println(year+":"+month+":" + day+":" + hour+":" + minute + ":"+ second);
		calendar.set(year, month, day, hour, minute, second);
		Date date = calendar.getTime();
		timer.schedule(task, date);

	}
}
