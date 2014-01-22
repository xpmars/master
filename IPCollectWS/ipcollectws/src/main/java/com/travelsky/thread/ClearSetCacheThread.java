package com.travelsky.thread;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.travelsky.bean.IpAdress;
import com.travelsky.util.PropertyUtil;

public class ClearSetCacheThread implements Runnable {
	private List<Set<IpAdress>> setList;

	public ClearSetCacheThread(List<Set<IpAdress>> setList) {
		this.setList = setList;
	}

	@Override
	public void run() {

		while (true) {
			try {
System.out.println("每小时 请空一次set缓存");
				PropertyUtil conf = new PropertyUtil("threadPolling.properties");
				long pollingTime = Long.parseLong(conf.getValue("cacheSetPollingTime"));
				Thread.sleep(pollingTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (Iterator<Set<IpAdress>> iterator = setList.iterator(); iterator
					.hasNext();) {
				Set<IpAdress> set = (Set<IpAdress>) iterator.next();
				set.clear();
			}
		}
	}
}
