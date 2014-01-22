package com.travelsky.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.travelsky.bean.IpAdress;
import com.travelsky.bean.User;
import com.travelsky.dao.IpDao;
import com.travelsky.dao.UserDao;


@SuppressWarnings("unused")
public class DaoTest {

	@Test
	public void test() {
//		    ApplicationContext ctx = new ClassPathXmlApplicationContext("dao/applicationContextTest.xml");  
//		    TestBean tb = ctx.getBean("userTest", TestBean.class);
//		    System.out.println(  tb.toString());
		
		    ApplicationContext ctx = new ClassPathXmlApplicationContext("dao/applicationContext.xml"); 
		    IpDao ipDao = ctx.getBean("ipDao",IpDao.class);  
		    IpAdress ipAd = new IpAdress();
		    ipAd.setAdress("4");
		    ipAd.setPort(4);
		    ipAd.setAlive(false);
		    ipAd.setDomestic(true);
//		    ipDao.insert(ipAd); 
//		    ipDao.deleteByIsAlive();
		    List ipAdressList = new ArrayList();
		    ipAdressList.add(ipAd);
		    ipDao.VerifyInsert(ipAdressList);
//		    System.out.println(  ipDao.BatchUpdate(ipAdressList).toString());
//		    ipAdressList =  ipDao.queryAll();
//		    System.out.println(ipDao.getRecordCount());
//		    System.out.println(ipDao.queryIsDomestic(false));
//		    System.out.println(ipDao.queryIsAlived(true));

//		    ipDao.BatchInsert(ipAdressList);
		    
//		    System.out.println( ipDao.deleteByIsAlive());
//		    ipDao.deleteRep();
		    
//		    User model = new User();  
//		    model.setUsername("tes2t");  
//		    model.setPassword("test"); 
//		    model.setComment("test"); 
//		    userDao.save(model);  
		
		  
		  
	}

}
