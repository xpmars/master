package com.travelsky.context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.travelsky.bean.IpAdress;

public class GlobalVariable {
	public  static List<IpAdress> ipAdressList = Collections.synchronizedList(new ArrayList<IpAdress>());
	//待验证IP列表
	public  static List<IpAdress> validateIpList = Collections.synchronizedList(new ArrayList<IpAdress>());
	
}
