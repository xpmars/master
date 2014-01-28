package com.travelsky.dao;

import java.util.List;

import com.travelsky.domain.Dish;

public interface DishDao {

	public abstract Dish findDishById(int dishId);

	public abstract List<Dish> findAll();
}
