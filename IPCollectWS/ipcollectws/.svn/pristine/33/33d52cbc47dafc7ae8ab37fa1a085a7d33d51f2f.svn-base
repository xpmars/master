package com.travelsky.thread;

import java.util.List;

import com.travelsky.bean.IpAdress;
import com.travelsky.context.SpringContext;
import com.travelsky.dao.IpDao;
import com.travelsky.dao.IpDaoImpl;
import com.travelsky.util.PropertyUtil;

public class UpdateCacheIpThread implements Runnable {

	private List<IpAdress> cacheIpList;
	private IpDao ipDao = (IpDao) SpringContext.getContext().getBean("ipDao");  
	public UpdateCacheIpThread(List<IpAdress> cacheIpList) {
		this.setCacheIpList(cacheIpList);
	}

	@Override
	public void run() {
		while(true){
			try {
				System.out.println("此时CacheList中有"+cacheIpList.size()+"条IP。");
System.out.println("30分钟后 reload一次cacheIpList缓存");
				PropertyUtil conf = new PropertyUtil("threadPolling.properties");
				long pollingTime = Long.parseLong(conf.getValue("cacheListPollingTime"));
				Thread.sleep(pollingTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			setCacheIpList(ipDao.queryIsAlived(true));
			
		}
	}

	public List<IpAdress> getCacheIpList() {
		return cacheIpList;
	}

	public void setCacheIpList(List<IpAdress> cacheIpList) {
		this.cacheIpList = cacheIpList;
	}

}
