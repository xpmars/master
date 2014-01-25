package com.travelsky.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.travelsky.dao.DishDao;
import com.travelsky.dao.UserDao;
import com.travelsky.domain.Dish;
import com.travelsky.service.DishService;

public class DishServiceImpl implements DishService {
	@Autowired
	private DishDao dishDao;
	
	public Dish findRestById(Integer restId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Dish> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
