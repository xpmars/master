package com.travelsky.service;

import java.util.List;

import com.travelsky.domain.Dish;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com)  @2014-1-18
 */
public interface DishService {

	public abstract Dish findDishById(int dishId);
	
	public abstract List<Dish> findAll();
}
