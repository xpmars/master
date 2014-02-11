package com.travelsky.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelsky.context.CacheLoder;
import com.travelsky.dao.UserDao;
import com.travelsky.domain.User;
import com.travelsky.service.UserService;

/**
 * 类说明：用户Service实现
 * 
 * @author 作者: ChengJun
 * @version 创建时间：2012-3-25 下午02:26:48
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// 添加用户
	public void addUser(User user) {
		userDao.insertUser(user);
		if("订饭官".equals(user.getUsertype())){
			CacheLoder.cacheUserList = findUserByType("订饭官");
		}
			
	}

	// 更新用户
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public void deleteUser(Integer userId) {
		userDao.deleteUser(userId);
	}

	public User findUserById(Integer userId) {
		return userDao.findUserByid(userId);
	}

	public List<User> findAllUser() {
		return userDao.findAll();
	}

	public User login(User user) {
		return userDao.userLogin(user);
	}

	public User findRepeat(User user) {
		return userDao.findRepeat(user);
	}

	public List<User> findUserByType(String userType) {
		return userDao.findUserByType(userType);
	}
}
