package com.travelsky.dao;

import java.util.List;

import com.travelsky.domain.Dish;

public interface DishDao {

	public abstract Dish findRestById(Integer restId);

	public abstract List<Dish> findAll();
}
