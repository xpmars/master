package com.travelsky.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.travelsky.bean.IpAdress;
import com.travelsky.context.GlobalVariable;
import com.travelsky.context.SpringContext;
import com.travelsky.dao.IpDao;

public class ValidateIpThreads implements Runnable {

	private IpDao ipDao = (IpDao) SpringContext.getContext().getBean("ipDao"); 
	@Override
	public void run() {
		List<IpAdress> validateIPList = Collections.synchronizedList(new ArrayList<IpAdress>());
		validateIPList = ipDao.queryAll();
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 15,
				20, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(
				),new ThreadPoolExecutor.DiscardOldestPolicy());
		AtomicInteger counts = new AtomicInteger(0);
		for (IpAdress ipAdress : validateIPList) {
			System.out.println("数据库取出"+ipAdress+"待验证......");
			counts.incrementAndGet();
			threadPool.execute(new ValidateIPThread(counts,ipAdress));	
		}
		while (counts.intValue() >= 1) {
			System.out.println("now the active threads:" + counts.intValue());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
System.out.println("IP验证结束，新一轮的验证将在2个小时候开始...");	
		for (IpAdress ipAdress : GlobalVariable.validateIpList) {
			if(ipAdress.isAlive() == false)
				System.out.println("未通过验证："+ipAdress);
		}
		try {
			Thread.sleep(1000*3600*3);//2个小时启动一次
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
