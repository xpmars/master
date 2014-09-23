package com.travelsky.dao;

import java.util.List;

import com.travelsky.domain.User;

/**
 * 类说明：
 * 
 * @author 作者: ChengJun
 * @version 创建时间：2012-3-25 下午03:03:19
 */
public interface UserDao {

	public abstract void insertUser(User user);

	public abstract void updateUser(User user);

	public abstract void deleteUser(Integer userId);

	public abstract User findUserById(Integer userId);

	public abstract List<User> findAll();

	public abstract User userLogin(User user);
	
	public abstract User findRepeat(User user);
	
	public abstract List<User> findUserByType(String type);

	public abstract User findUserByEmail(String email);
}