package com.travelsky.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelsky.dao.DishDao;
import com.travelsky.dao.UserDao;
import com.travelsky.domain.Dish;
import com.travelsky.service.DishService;
/**
 * 类说明：用户Service实现
 * 
 * @author 作者: ChengJun
 * @version 创建时间：2012-3-25 下午02:26:48
 */
@Service
@Transactional
public class DishServiceImpl implements DishService {
	@Autowired
	private DishDao dishDao;

	public List<Dish> findAll() {
		return dishDao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.travelsky.service.DishService#findDishById(java.lang.Integer)
	 */
	public Dish findDishById(int dishId) {
		return dishDao.findDishById(dishId);
	}

}
