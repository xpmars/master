/**   
* @Title: EmailUtil.java
* @author chengjun(chengjun@travelsky.com) 
* @date 2014-2-20 下午2:28:49  
* @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
*/
package com.travelsky.util;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.travelsky.domain.User;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com)  @2014-2-20
 */
public class EmailUtil {

	public static void doSendEmail(String mailTo , String text) throws Exception{
        String title = "您的订单";
//      String mailTo =scheduleParamSysDao.getParaValuebyName("SSMEMAIL"); //目的邮箱配置
        String isproxy="1";//1，有代理
        String proxyhost ="10.123.74.137";//公司代理服务器
        String proxyport ="1080";
        String smtphost ="smtp.tom.com";
        String smtpuser ="ordersky@tom.com";//邮件发送者
        String smtppassword ="travelsky";//密码
        String smptport ="25";
        
        //设置代理服务器
        Properties props = System.getProperties();
        if(isproxy!=null&& "1".equals(isproxy)){
            props.setProperty("proxySet", "true");
            props.setProperty("socksProxyHost", proxyhost);
            props.setProperty("socksProxyPort", proxyport);
        }
        props.setProperty("mail.smtp.host", smtphost);
        props.setProperty("mail.smtp.port", smptport);
        props.put("mail.smtp.auth", "true");
 //       props.put("mail.debug", "true");

        final String username = smtpuser;
        final String password = smtppassword;

        //使用验证
        try{
            Session session = Session.getDefaultInstance(props,
                    new Authenticator() {
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(username,
                            password);
                }
            });
            MimeMessage message = new MimeMessage(session);
            Address address = new InternetAddress(smtpuser);
            Address toAaddress = new InternetAddress(mailTo);
            message.setFrom(address);
            message.setRecipient(MimeMessage.RecipientType.TO, toAaddress);
            message.setSubject(title);
            message.setText(text);
            message.setSentDate(new Date());
            System.out.println("向："+mailTo+" 邮件发送中.....");
            Transport.send(message);
            System.out.println("邮件发送成功！");
        }catch (Exception e){
        	System.out.println("邮件发送失败！");
            e.printStackTrace();
            throw e;
        }
    }
}
