package com.travelsky.util;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import com.travelsky.bean.IpAdress;

public class IpProcess {
	private static String url = null;
	private static String responseBody = null;
	private static final int BUFFER_SIZE = 8192;
	private static final int CONN_TIME_OUT = 50 * 1000;
	private static final int READ_TIME_OUT = 50 * 1000;
	private static final String USER_AGENT = "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.1.5) "
			+ "Gecko/20091102 Firefox/3.5.5 GTB6 (.NET CLR 3.5.30729)";
	private static HttpParams httpParams = new BasicHttpParams();
	static {
		 	//SetProxy("10.123.74.137:808");//公司内开代理速度更快，不开代理也能用！
	}

	public static void SetProxy(String proxyIp) {
		String[] pp = proxyIp.split(":");
		String proxyHost = pp[0];
		int proxyPort = Integer.parseInt(pp[1]);
		HttpConnectionParams.setConnectionTimeout(httpParams, CONN_TIME_OUT);
		HttpConnectionParams.setSoTimeout(httpParams, READ_TIME_OUT);
		HttpConnectionParams.setSocketBufferSize(httpParams, BUFFER_SIZE);
		// 设置重定向，缺省为 true
		HttpClientParams.setRedirecting(httpParams, true);
		// 代理设置
		HttpHost proxy = new HttpHost(proxyHost, proxyPort);
		httpParams.setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
		String userAgent = USER_AGENT;
		HttpProtocolParams.setUserAgent(httpParams, userAgent);
	}

	public static void getIpadress(String url) {
System.out.println("从"+url+"上开始爬取代理IP。");
		Map<Character, Integer> portMap = new HashMap<Character, Integer>();
		portMap.put('q', 0);
		portMap.put('c', 1);
		portMap.put('a', 2);
		portMap.put('v', 3);
		portMap.put('m', 4);
		portMap.put('b', 5);
		portMap.put('w', 6);
		portMap.put('i', 7);
		portMap.put('r', 8);
		portMap.put('l', 9);
		StringBuffer sb = new StringBuffer();
		try {
			Document doc = Jsoup.connect(url).data("jquery", "java")
					.userAgent("Mozilla").cookie("auth", "token")
					.timeout(20000).get();
			Elements links = doc.select("tr:has(script)");	
			for (Element link : links) {
				Element linksIp = link.child(0);
				Element linksSpeed = link.child(2);
				Element linksArea = link.child(3);
				String linkIp = linksIp.text();
				String linkPort = "";
				String ipAdress = "";
				char[] chArray = linksIp.child(0).html()
						.replace("document.write(\":\"+", "").replace(")", "")
						.replace("+", "").toString().toCharArray();
				for (int i = 0; i < chArray.length; i++) {
					linkPort += portMap.get(chArray[i]);
				}
				String speed = linksSpeed.html().split(",")[0];
				String Area = linksArea.html();
				float speedFloat = Float.parseFloat(speed)/1000;
				ipAdress = linkIp + ":" + linkPort + ","+ String.valueOf(speedFloat)+","+Area;
				sb.append(ipAdress).append("\r\n");
			}
System.out.println("本次爬取的IP有：\n"+sb);
			ReadOrWriteFileUtil.WriteTxt(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取代理IP的地理位置
	 * 
	 * @param ipAdress
	 * @return
	 */
	public static IpAdress getIpLocation(IpAdress ipAdress) {
		HttpClient client = HttpclientUtil.createHttpClient();//作用域一定要谨慎
		url = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js&ip="
				+ ipAdress.getAdress();
		try {
			HttpGet httget = new HttpGet(url);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			responseBody = client.execute(httget, responseHandler);
		} catch (Exception e) {
			System.out.println("网络分析出错！");
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}
		String jsonText = responseBody.substring(responseBody.indexOf('{'),
				responseBody.lastIndexOf(';'));
		JSONObject jsonObj = JSONObject.fromObject(jsonText);
		ipAdress.setCountry(jsonObj.getString("country"));
		ipAdress.setProvince(jsonObj.getString("province"));
		ipAdress.setCity(jsonObj.getString("city"));
		ipAdress.setIsp(jsonObj.getString("isp"));
		return ipAdress;
	}

	/**
	 * 验证代理IP的有效性
	 * 
	 * @param proxyAndport
	 * @return
	 */
	public static boolean isVaildProxyA(String proxyIp) {

		String pp[] = proxyIp.split(":");
		String proxyHost = pp[0];
		String proxyPort = pp[1];
		return HttpclientUtil.checkProxy(proxyHost, proxyPort);
	}

}
