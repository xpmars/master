package com.travelsky.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.travelsky.util.MD5Util;
import com.travelsky.util.PropertyUtil;

public class MD5Test {

	@Test
	public void test() {
		MD5Util getMD5 = new MD5Util();
//		System.out.println(getMD5.GetMD5Code("testtest"));
		System.out.println( this.getClass().getClassLoader().getResource("")); 
//		PropertyUtil conf = new PropertyUtil("local.properties");
  //      String value = conf.getValue("jdbc.url");    
    //    System.out.println(value);
	}

}
