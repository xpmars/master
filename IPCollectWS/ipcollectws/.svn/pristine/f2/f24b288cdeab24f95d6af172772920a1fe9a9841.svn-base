package com.travelsky.test;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.travelsky.bean.IpAdress;
import com.travelsky.context.GlobalVariable;
import com.travelsky.context.SpringContext;
import com.travelsky.dao.IpDao;
import com.travelsky.dao.IpDaoImpl;
import com.travelsky.thread.LocateIPThread;
import com.travelsky.thread.ValidateIPThread;
import com.travelsky.util.IpProcess;
import com.travelsky.util.ReadOrWriteFileUtil;

public class test {

	private static List<IpAdress> ipAdressList = GlobalVariable.ipAdressList;
/**
 * 插入IP到数据库中
 */
@Test
	public void DaoInsertTest() {
	 ApplicationContext ctx = new ClassPathXmlApplicationContext("dao/applicationContext.xml"); 
	    IpDao ipDao = ctx.getBean("ipDao",IpDao.class);  
		ReadOrWriteFileUtil.ReadTxt();
		ipDao.VerifyInsert(ipAdressList);
	}
	/*
	@Test
	public void DaoFindAllTest() {
		List<IpAdress> ipAdressList = ipDao.findAll();
		for (IpAdress ipAdress : ipAdressList) {
			System.out.println("数据库取出"+ipAdress);
		}
		System.out.println("一共有"+ipDao.getRecordCount()+"条记录！");
	}
	*/
/*	@Test
	public void DaoDeleteTest() {
		System.out.println("一共删除"+ipDao.deleteByIsAlive()+"条记录！");
	}
*/
/**
 * 删除重复IP
 */
//@Test
//	public void DaoDeleteRepTest() {
//		System.out.println("一共删除"+ipDao.deleteRep()+"条重复数据记录！");
//	}
/**
 * 给失效IP置标记位
 * @throws InterruptedException 
 */
//	@Test
//	public void ValidateIpTest() throws InterruptedException  {
//		int index = 0;
//		List<IpAdress> validateIPList = Collections.synchronizedList(new ArrayList<IpAdress>());
//		validateIPList = ipDao.findAll();
//		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 15,
//				20, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(
//				),new ThreadPoolExecutor.DiscardOldestPolicy());
//		AtomicInteger counts = new AtomicInteger(0);
//		for (IpAdress ipAdress : validateIPList) {
//			System.out.println("数据库取出"+ipAdress+"待验证......");
//			String task = "task@" + index++;
//			counts.incrementAndGet();
//			threadPool.execute(new ValidateIPThread(counts,ipAdress,task));	
//		}
//		while (counts.intValue() >= 1) {
//			System.out.println("now the active threads:" + counts.intValue());
//			Thread.sleep(3000);
//		}
//		
//		for (IpAdress ipAdress : GlobalVariable.validateIpList) {
//			if(ipAdress.isAlive() == false)
//				System.out.println("未通过验证："+ipAdress);
//		}
//	}

	
	/**
	 * 寻找国外代理IP
	 */
//	@Test
//	public void FindIsDomesticIpTest() {
//		List<IpAdress> ipAdressList = ipDao.findIsDomestic(false);
//		
//		for (IpAdress ipAdress : ipAdressList) {
//			System.out.println("数据库取出"+ipAdress);
//		}
//		System.out.println("一共有"+ipAdressList.size()+"条国外IP地址。");
//	}
	
/**
 * 自动爬取代理IP
 */
//	@Test
//	public void getIpTest(){
//		String path = "G:/proxy.txt";
//System.out.println("爬取IP地址开始......");
//		for (int i = 1; i < 11; i++) {
//			String url = "http://www.cnproxy.com/proxy"+ i +".html";
//			IpProcess.getIpadress(url,path);
//		}
//	}
/**
 * 先验证重复，再插入代理IP
 */
//	@Test
//	public void DaoVerifyInsertTest() {
//	String path = "G:/proxy.txt";
//	ipAdressList = ReadOrWriteFileUtil.ReadTxt(path);
//	System.out.println("插入"+ipAdressList.size()+"个！");
//		ipDao.VerifyInsert(ipAdressList);
//	}
//	@Test
//	public void ThreadTest(){
//		String path = "G:/proxy.txt";
//		ipAdressList = ReadOrWriteFileUtil.ReadTxt(path);
	//	System.out.println("插入"+ipAdressList.size()+"个！");
//	}
//	@Test
//	public void test(){
//		try {
//			Document doc = Jsoup.connect("http://www.cnproxy.com/proxy1.html").data("jquery", "java")
//					.userAgent("Mozilla").cookie("auth", "token")
//					.timeout(10000).get();
//			System.out.println(doc);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
