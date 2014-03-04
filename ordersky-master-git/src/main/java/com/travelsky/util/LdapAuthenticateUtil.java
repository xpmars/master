/**   
 * @Title: LdapAuthenticateUtil.java
 * @author chengjun(chengjun@travelsky.com) 
 * @date 2014-3-4 下午4:25:59  
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.travelsky.util;

import java.util.Hashtable;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.Control;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com) @2014-3-4
 */
public class LdapAuthenticateUtil {
	private static String URL = "ldap://10.123.78.229:389/";
	private static String BASEDN = "dc=rdmsp,dc=com";
	private static String FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";
	private static LdapContext ctx = null;
	private static Hashtable<String, String> env = null;
	private static Control[] connCtls = null;

	private static void LDAP_connect() {
		env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, FACTORY);
		env.put(Context.PROVIDER_URL, URL + BASEDN);// LDAP server
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		// 此处若不指定用户名和密码,则自动转换为匿名登录

		try {
			ctx = new InitialLdapContext(env, connCtls);
		} catch (javax.naming.AuthenticationException e) {
			System.out.println("Authentication faild: " + e.toString());
		} catch (Exception e) {
			System.out.println("Something wrong while authenticating: " + e.toString());
		}
	}

	private static String getUserDN(String email) {
		String userDN = "";

		LDAP_connect();

		try {
			SearchControls constraints = new SearchControls();
			constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
			// The UID you are going to query,* means all nodes
			NamingEnumeration<?> en = ctx.search("", "mail=" + email, constraints);
			if (en == null) {
				System.out.println("Have no NamingEnumeration.");
			}
			if (!en.hasMoreElements()) {
				System.out.println("Have no element.");
			}
			while (en != null && en.hasMoreElements()) {// maybe more than one
														// element
				Object obj = en.nextElement();
				if (obj instanceof SearchResult) {
					SearchResult si = (SearchResult) obj;
					userDN += si.getName();
					userDN += "," + BASEDN;
				} else {
					System.out.println(obj);
				}
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Exception in search():" + e);
		}

		return userDN;
	}

	public static boolean authenricate(String ID, String password) {
		boolean valide = false;
		String userDN = getUserDN(ID);

		try {
			ctx.addToEnvironment(Context.SECURITY_PRINCIPAL, userDN);
			ctx.addToEnvironment(Context.SECURITY_CREDENTIALS, password);
			ctx.reconnect(connCtls);
			System.out.println(userDN + " is authenticated");
			valide = true;
		} catch (AuthenticationException e) {
			System.out.println(userDN + " is not authenticated");
			System.out.println(e.toString());
			valide = false;
		} catch (NamingException e) {
			System.out.println(userDN + " is not authenticated");
			valide = false;
		}
		return valide;
	}
}
