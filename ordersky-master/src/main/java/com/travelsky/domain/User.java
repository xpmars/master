package com.travelsky.domain;

import java.io.Serializable;

/**
 * 类说明：用户表
 * 
 * @author 作者: ChengJun
 * @version 创建时间：2012-3-25 下午12:38:24
 */
public class User implements Serializable {
	private static final long serialVersionUID = -4415990281535582814L;
	private Integer id;
	private String username;
	private String name;
	private String password;
	private String password2;
	private String telephone;
	private String usertype;
	private String email;
	private String error;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	
	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", password="
				+ password + ", password2=" + password2 + ", telephone=" + telephone
				+ ", usertype=" + usertype + ", email=" + email + ", error=" + error + "]";
	}
	
	
}
