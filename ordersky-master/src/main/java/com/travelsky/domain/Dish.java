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
	private String restId;
	private String dishName;
	private String taste;
	private float prince;
	private String discount;
	private String remark;
	private String interval;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRestId() {
		return restId;
	}
	public void setRestId(String restId) {
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
	public float getPrince() {
		return prince;
	}
	public void setPrince(float prince) {
		this.prince = prince;
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
				+ taste + ", prince=" + prince + ", discount=" + discount + ", remark=" + remark
				+ ", interval=" + interval + "]";
	}


}
