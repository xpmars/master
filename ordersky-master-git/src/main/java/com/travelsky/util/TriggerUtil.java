package com.travelsky.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.travelsky.context.CacheLoder;
import com.travelsky.domain.Trigger;
import com.travelsky.exception.EmailException;
import com.travelsky.service.EmailService;

/**
 * @Description: TODO 触发器工具
 * @author chengjun(chengjun@travelsky.com) @2014-2-20
 */
@Controller
@Scope("prototype")
public class TriggerUtil {

	private static Logger logger = Logger.getLogger(TriggerUtil.class);
	@Autowired
	private EmailService emailService;
	/**
	 * 触发事件
	 */
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);// 获取年份
	int month = calendar.get(Calendar.MONTH);// 获取月份
	int day = calendar.get(Calendar.DATE);// 获取天


	public void Trigger(final int hour, final int minute, final int second, final String henchman) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				
				System.out.println(year + "年" + month + "月" + day + "日" + minute + ":" + minute + ":"
						+ second);
				logger.info(year + "年" + month + "月" + day + "日" + hour + ":" + minute + ":"
						+ second + " *************触发器触发***************");
				System.out.println("****************************触发器触发****************************");
				List<Trigger> triggerList = CacheLoder.cacheTriggerList;
				List<Trigger> needRemoveTriggerList = new ArrayList<Trigger>();

				// 发送邮件
				try {
					emailService.sentToHenchman(henchman);
				} catch (EmailException ee) {
					ee.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (triggerList != null && triggerList.size() != 0) {
					for (Trigger trigger : triggerList) {
						if (trigger.getHenchman().equals(henchman)) {
							needRemoveTriggerList.add(trigger);
						}
					}
				}
				System.out.println("缓存中有触发器列表：" + CacheLoder.cacheTriggerList);
				logger.info("将删除内存中 " + henchman + " 对应的缓存触发器");
				CacheLoder.cacheTriggerList.removeAll(needRemoveTriggerList);
				System.out.println("删除后，缓存中还有触发器列表：" + CacheLoder.cacheTriggerList);
			}

		};
		/*** 定制每日10：30：00执行方法 ***/
		System.out.println("将在" + year + "年" + month + "月" + day + "日 " + hour + ":" + minute + ":"
				+ second + "触发！");
		calendar.set(year, month, day, hour, minute, second);
		Date date = calendar.getTime();
		timer.schedule(task, date);

	}

}
