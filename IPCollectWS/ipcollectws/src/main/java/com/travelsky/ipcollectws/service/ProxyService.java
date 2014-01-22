package com.travelsky.ipcollectws.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

import org.springframework.stereotype.Service;

import com.travelsky.bean.InitServiceBean;
import com.travelsky.bean.IpAdress;
import com.travelsky.bean.User;
import com.travelsky.dao.UserDao;
import com.travelsky.ipcollectws.util.LoggerProxy;
import com.travelsky.util.MD5Util;

@Path("/proxyservice")
@Produces({ "application/json", "application/xml" })
@Service
public class ProxyService {
	private InitServiceBean initServiceBean;
	private UserDao userDao;

	@GET
	@Path("/{source}/{num}/{checksum}")
	@Produces({ "application/json" })
	public Response getProxyIp(@PathParam("source") String source,
			@PathParam("num") int num, @PathParam("checksum") String checksum) {
		LoggerProxy.debug("getProxyIp from " + source);
		ResponseBuilder builder = Response.status(Status.OK);
		builder.type("application/json");
		String message = null;

		if (verifiedMD5(checksum)) {
			message = getReturnMessage(source, num);
		} else {
			message = "<proxyDate><resultCode>2</resultCode></proxyDate>";
		}

		XMLSerializer xmlSerializer = new XMLSerializer();
		JSON json = xmlSerializer.read(message);
		System.out.println(json);
		builder.entity(json.toString());
		return builder.build();
	}

	private boolean verifiedMD5(String checksum) {
		boolean flag = false;
		List<User> userList = userDao.selectAll();
		for (User user : userList) {
			if(checksum.equals(MD5Util.GetMD5Code(user.getUsername()+user.getPassword())))
				flag = true;
		}	
		return flag;
	}

	private String getReturnMessage(String source, int num) {
		String message = null;
		List<IpAdress> cacheIpList = initServiceBean.cacheIpList;
		Map<String, Set<IpAdress>> map = initServiceBean.map;
		List<IpAdress> inputList = new ArrayList<IpAdress>();
		boolean flag = true;
		Set<IpAdress> sett = map.get(source);
		if (num > 0) {
			int i = 0;
			int j = 0;
			while (j < num && i < cacheIpList.size()) {
				IpAdress ipAd = cacheIpList.get(i++);

				if (sett.contains(ipAd))
					continue;
				else {
					inputList.add(ipAd);
					j++;
				}
				if (sett.size() == cacheIpList.size()) {
					// 返回IP地址不够用，resultcode置为1
					flag = false;
					break;
				}
			}
			int ipCount = inputList.size();
			if (flag && ipCount > 0) {
				message = "<proxyDate><resultCode>0</resultCode>" + "<ipCount>"
						+ ipCount + "</ipCount><proxyList>";// 成功返回码为0
				for (Iterator<IpAdress> iterator = inputList.iterator(); iterator
						.hasNext();) {
					IpAdress ipAdress = iterator.next();
					sett.add(ipAdress);
					message += "<proxy><ip>" + ipAdress.getAdress()
							+ "</ip><port>" + ipAdress.getPort()
							+ "</port></proxy>";
				}
				message += "</proxyList></proxyDate>";
			} else
				message = "<proxyDate><resultCode>1</resultCode></proxyDate>";
		} else {
			message = "<proxyDate><resultCode>1</resultCode></proxyDate>";
		}

		inputList = null;
		return message;
	}

	public InitServiceBean getInitServiceBean() {
		return initServiceBean;
	}

	public void setInitServiceBean(InitServiceBean initServiceBean) {
		this.initServiceBean = initServiceBean;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
// END SNIPPET: service