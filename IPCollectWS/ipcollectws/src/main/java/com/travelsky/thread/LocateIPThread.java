package com.travelsky.thread;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.travelsky.bean.IpAdress;
import com.travelsky.context.GlobalVariable;
import com.travelsky.util.IpProcess;

public class LocateIPThread implements Runnable {
	private IpAdress ipAd;
	private AtomicInteger counts; 
	private static List<IpAdress> ipAdressList = GlobalVariable.ipAdressList;
	
	public LocateIPThread(AtomicInteger counts, IpAdress ipAd) {
		this.counts = counts;
		this.ipAd = ipAd;
	}
	@Override
	public void run() {
		ipAd = IpProcess.getIpLocation(ipAd);
		if ("中国".equals(ipAd.getCountry())) {
			ipAd.setDomestic(true);
		}
		ipAd.setAlive(true);
System.out.println(ipAd);
		ipAdressList.add(ipAd);
         counts.decrementAndGet();
	}
}
