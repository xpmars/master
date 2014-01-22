package com.travelsky.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;

import com.travelsky.context.GlobalVariable;
import com.travelsky.context.SpringContext;
import com.travelsky.dao.IpDao;
import com.travelsky.thread.ClearSetCacheThread;
import com.travelsky.thread.UpdateCacheIpThread;
import com.travelsky.thread.ValidateIpThreads;
import com.travelsky.util.IpProcess;
import com.travelsky.util.ReadOrWriteFileUtil;

public class InitServiceBean implements InitializingBean{

	public  static List<IpAdress> cacheIpList;
	public  static Set<IpAdress> qunarSet;
	public  static Set<IpAdress> ctripSet;
	public static Map<String, Set<IpAdress>> map;
	private  List<Set<IpAdress>> setList = new ArrayList<Set<IpAdress>>();
	private static List<IpAdress> ipAdressList = GlobalVariable.ipAdressList;
	private IpDao ipDao = (IpDao) SpringContext.getContext().getBean("ipDao");  
	@Override
	public void afterPropertiesSet() throws Exception {
		//第一步：爬取一天的代理IP
		getEveryIp();
		//第二步：入库，并检查重复
		insertIp();
		//第三步：再次验证重复IP地址，确保存入唯一性，删除重复
		System.out.println("一共删除"+ipDao.deleteRep()+"条重复数据记录！");
		//第四步：其他缓存初始化，取出今日可用IP,并存入到全局cacheIpList中
		qunarSet = Collections.synchronizedSet(new HashSet<IpAdress>());
		ctripSet = Collections.synchronizedSet(new HashSet<IpAdress>());
		setList.add(ctripSet);
		setList.add(qunarSet);
		
		map = new HashMap<String, Set<IpAdress>>();
		map.put("qunar", qunarSet);
		map.put("ctrip", ctripSet);
		
		cacheIpList = Collections.synchronizedList(new ArrayList<IpAdress>());
		cacheIpList = getVaildedIp();
		//启动线程，给失效代理IP置位，并定时更新缓存cacheIpList
		reloadCacheIp();
		
	}

	private void reloadCacheIp() {
		//启动监控多线程,给失效IP置标记位
	//	new Thread(new ValidateIpThreads()).start();
		//定时更新缓存cacheIpList线程
	   	new Thread(new UpdateCacheIpThread(cacheIpList)).start();
	   	//定时清空缓存Set的线程
	   	new Thread(new ClearSetCacheThread(setList)).start();
	}

	private  List<IpAdress> getVaildedIp() {
		 return ipDao.queryIsAlived(true);
	}

	private void insertIp() {
		ReadOrWriteFileUtil.ReadTxt();
		System.out.println("插入"+ipAdressList.size()+"个！");
		ipDao.VerifyInsert(ipAdressList);
		ipAdressList = null;
	}
	
	private void getEveryIp() {
		System.out.println("开始抓取今日代理IP");
		for (int i = 1; i < 11; i++) {
			String url = "http://www.cnproxy.com/proxy"+ i +".html";
			IpProcess.getIpadress(url);
		}
	}
	
}
