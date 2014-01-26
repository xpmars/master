package com.travelsky.domain;

import java.io.Serializable;

/**
 * 类说明：用户表
 * 
 * @author 作者: ChengJun
 * @version 创建时间：2013-10-12 下午12:38:24
 */
public class Dish implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3266314660117025881L;
	private Integer id;
	private Integer restId;
	private String dishName;
	private String taste;
	private String price;
	private String discount;
	private String remark;
	private String interval;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getRestId() {
		return restId;
	}
	public void setRestId(Integer restId) {
		this.restId = restId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Dish [id=" + id + ", restId=" + restId + ", dishName=" + dishName + ", taste="
				+ taste + ", price=" + price + ", discount=" + discount + ", remark=" + remark
				+ ", interval=" + interval + "]";
	}


}
