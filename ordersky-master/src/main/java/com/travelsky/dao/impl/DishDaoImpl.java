package com.travelsky.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelsky.dao.DishDao;
import com.travelsky.domain.Dish;
@Repository
public class DishDaoImpl implements DishDao{
	private final String INSERT_DISH = "insertDish";
	private final String UPDATE_DISH = "updateDish";
	private final String DELETE_DISH = "deleteDish";
	private final String FIND_DISH_BYID = "findDishById";
	private final String SELECT_ALL_DISH = "selectAllDish";
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public Dish findRestById(Integer restId) {
		return null;
	}

	public List<Dish> findAll() {
		return sqlSessionTemplate.selectList(SELECT_ALL_DISH);
	}

}
