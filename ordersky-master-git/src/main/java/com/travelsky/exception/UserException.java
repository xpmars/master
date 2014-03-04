/**   
* @Title: UserException.java
* @author chengjun(chengjun@travelsky.com) 
* @date 2014-3-4 下午6:16:34  
* @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
*/
package com.travelsky.exception;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com)  @2014-3-4
 */
public class UserException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserException() {
	}

	public UserException(String smg) {
		super(smg);
	}
}
