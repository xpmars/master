package com.travelsky.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.InputStream;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.travelsky.context.SpringContext;
import com.travelsky.dao.IpDao;
import com.travelsky.util.PropertyUtil;
import com.travelsky.util.ReadOrWriteFileUtil;

public class FileTest {

	@Test
	public void test() {
//		String path = FileTest.class.getClassLoader().getResource("").getPath() + "jcbc.properties";
//		String path = ReadOrWriteFileUtil.class.getClassLoader().getResource("./")+"proxy.txt";
//		System.out.println(path);

//		path.replace("file:/", "");
//		System.out.println(path.replace("file:/", ""));
//		InputStream is  = PropertyUtil.class.getResourceAsStream("jcbc.properties");
//		File file = new File("file:/E:/workspace/IPCollectWS/ipcollectws/target/classes/proxy.txt");
//		System.out.println(file.exists());
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("dao/applicationContext.xml"); 
		 SpringContext ctx2 = (SpringContext) ctx.getBean("springContext");
		 IpDao ipDao = (IpDao) ctx2.getContext().getBean("ipDao");
		 System.out.println(ipDao);
	}

}
