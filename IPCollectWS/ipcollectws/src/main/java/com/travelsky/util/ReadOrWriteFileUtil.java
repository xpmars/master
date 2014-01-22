package com.travelsky.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.travelsky.bean.IpAdress;
import com.travelsky.thread.LocateIPThread;

public class ReadOrWriteFileUtil {

	private static BufferedReader bufferedReader;
	private static InetAddress inetaddr;
	private static String filePath = System.getProperty("user.dir") + File.separator + "proxy.txt";
/**
 * 从Txt中读取ip地址，并且多线程在线获取对应的地理信息
 * @param path
 * @return
 */
	public static  void ReadTxt() {
		String str = null;
		String[] array = null;
		File file = null;
		try {
System.out.println(filePath);	
			file = new File(filePath);
			
System.out.println(file.getAbsolutePath());
			if (file.isFile() && file.exists()) {
				FileInputStream fis = new FileInputStream(file);
				InputStreamReader read = new InputStreamReader(fis);
				bufferedReader = new BufferedReader(read);
				// 线程池,验证IP
				ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 10,
						15, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(
						),new ThreadPoolExecutor.DiscardOldestPolicy());
				AtomicInteger counts = new AtomicInteger(0);
				while ((str = bufferedReader.readLine()) != null && !("".equals(str))) {
					array = str.split(":");
					String ipadress = array[0];
					IpAdress ipAd = new IpAdress();
					if (isLegal(ipadress)) {
						array = array[1].split(",", 10);
						int port = Integer.parseInt(array[0]);
						String speed = null;
						if(array.length>=2)
							speed = array[1];
						ipAd.setAdress(ipadress);
						ipAd.setPort(port);
						ipAd.setSpeed(speed);
						counts.incrementAndGet();
						// 多线程获取代理IP的地理定位
						threadPool.execute(new LocateIPThread(counts,ipAd));
					}
				}
				fis.close();
				read.close();
				while (counts.intValue() >= 1) {
					System.out.println("now the active threads:" + counts.intValue());
					Thread.sleep(3000);
				}
				threadPool.shutdown();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
	}
/**
 * 判断ip的合法性
 * @param ipadress
 * @return
 */
	private static boolean isLegal(String ipadress) {
		try {
			setInetaddr(InetAddress.getByName(ipadress));
		} catch (UnknownHostException e) {
			return false;
		}
		return true;
	}

	public static InetAddress getInetaddr() {
		return inetaddr;
	}

	public static void setInetaddr(InetAddress inetaddr) {
		ReadOrWriteFileUtil.inetaddr = inetaddr;
	}

	public static synchronized void WriteTxt(StringBuffer sb) {
		File file = null;
		file = new File(filePath);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter writter = new FileWriter(file);
			writter.write(sb.toString());
			writter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
