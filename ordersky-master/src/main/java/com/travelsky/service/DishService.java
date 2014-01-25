package com.travelsky.service;

import java.util.List;

import com.travelsky.domain.Dish;

public interface DishService {

	public abstract Dish findRestById(Integer restId);

	public abstract List<Dish> findAll();
}
