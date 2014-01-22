package com.travelsky.main;



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

public class Test {

	private static List<IpAdress> ipAdressList = GlobalVariable.ipAdressList;

	/**
	 * 插入IP到数据库中
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"dao/applicationContext.xml");
		IpDao ipDao = ctx.getBean("ipDao", IpDao.class);
		ReadOrWriteFileUtil.ReadTxt();
		ipDao.VerifyInsert(ipAdressList);
		System.out.println("一共删除"+ipDao.deleteRep()+"条重复数据记录！");
	}
}