package com.travelsky.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelsky.dao.UserDao;
import com.travelsky.domain.User;
import com.travelsky.service.UserService;

import com.travelsky.dao.RestDao;
import com.travelsky.domain.Restaurant;
import com.travelsky.service.RestService;

/**
 * 类说明：用户Service实现
 * 
 * @author 作者: ChengJun
 * @version 创建时间：2012-3-25 下午02:26:48
 */
@Service
@Transactional
public class RestServiceImpl implements RestService {

	@Autowired
	private RestDao restDao;

	@Autowired
	public void setRestDao(RestDao restDao) {
		this.restDao = restDao;
	}
	public void addRest(Restaurant rest) {
		
	}
	public void updateRest(Restaurant rest) {

	}

	public void deleteRest(Integer restId) {
		
	}

	public Restaurant findRestById(Integer restId) {
		
		return null;
	}

	public List<Restaurant> findAllRest() {
	
		return null;
	}
}
