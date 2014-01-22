package com.travelsky.bean;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class QunarSrc {
	private List<IpAdress> inputList;
	private List<IpAdress> cacheIpList;
	private Set<IpAdress> qunarSet;
	private int num;

	public QunarSrc(List<IpAdress> inputList, List<IpAdress> cacheIpList,
			Set<IpAdress> qunarSet, int num) {
		super();
		this.inputList = inputList;
		this.cacheIpList = cacheIpList;
		this.qunarSet = qunarSet;
		this.num = num;
	}
	
	public String getMessage() {
		int i = 0;
		int j = 0;
		boolean flag = true;
		String message = null;
		while (j < num && i < cacheIpList.size()) {
			IpAdress ipAd = cacheIpList.get(i++);
			if (qunarSet.contains(ipAd)) {
				continue;
			} else {
				inputList.add(ipAd);
				qunarSet.add(ipAd);
				j++;
			}
			if (qunarSet.size() == cacheIpList.size()) {
				// 返回IP地址不够用，resultcode置为1
				flag = false;
				break;
			}
		}
		if (flag) {
			message = "<proxyDate><resultCode>0</resultCode><proxyList>";// 成功返回码为0
			for (Iterator<IpAdress> iterator = inputList.iterator(); iterator
					.hasNext();) {
				IpAdress ipAdress = (IpAdress) iterator.next();
				message += "<proxy><ip>" + ipAdress.getAdress()
						+ "</ip><port>" + ipAdress.getPort()
						+ "</port></proxy>";
			}
			message += "</proxyList></proxyDate>";
		} else
			message = "<proxyDate><resultCode>1</resultCode></proxyDate>";
		return message;
	}
}
