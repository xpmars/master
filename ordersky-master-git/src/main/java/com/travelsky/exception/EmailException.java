/**   
 * @Title: EmailException.java
 * @author chengjun(chengjun@travelsky.com) 
 * @date 2014-2-27 上午10:52:29  
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.travelsky.exception;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com) @2014-2-27
 */
public class EmailException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailException() {
	}

	public EmailException(String smg) {
		super(smg);
	}
}
