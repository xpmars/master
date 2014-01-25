package com.travelsky.domain;

import java.io.Serializable;

/**
 * 类说明：用户表
 * 
 * @author 作者: ChengJun
 * @version 创建时间：2013-10-12 下午12:38:24
 */
public class Menu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3266314660117025881L;
	private Integer menuId;
	private String dishName;
	private Restaurant restaurant;
	private float prince;
	private boolean isPungent;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public float getPrince() {
		return prince;
	}

	public void setPrince(float prince) {
		this.prince = prince;
	}

	public boolean isPungent() {
		return isPungent;
	}

	public void setPungent(boolean isPungent) {
		this.isPungent = isPungent;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", dishName=" + dishName + ", "
				+ " restaurant=" + restaurant + ", prince=" + prince
				+ ", isPungent=" + isPungent + "]";
	}

}
