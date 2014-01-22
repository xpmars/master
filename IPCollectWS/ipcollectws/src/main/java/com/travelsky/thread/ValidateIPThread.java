package com.travelsky.thread;

import java.util.concurrent.atomic.AtomicInteger;

import com.travelsky.bean.IpAdress;
import com.travelsky.context.GlobalVariable;
import com.travelsky.context.SpringContext;
import com.travelsky.dao.IpDao;
import com.travelsky.util.IpProcess;

public class ValidateIPThread implements Runnable {
	private IpAdress ipAdress;
	private AtomicInteger counts; 
	private IpDao ipDao = (IpDao) SpringContext.getContext().getBean("ipDao"); 
	public ValidateIPThread(AtomicInteger counts, IpAdress ipAdress) {
		this.counts = counts;
		this.ipAdress = ipAdress;
	}
	@Override
	public void run() {
		boolean flag = IpProcess.isVaildProxyA(ipAdress.getAdress()+":"+ipAdress.getPort());
		ipAdress.setAlive(flag);
		ipDao.update(ipAdress);
		
		if(flag)
			GlobalVariable.validateIpList.add(ipAdress);
        counts.decrementAndGet();
	}

}
