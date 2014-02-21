package com.travelsky.service;

import java.util.List;

import com.travelsky.domain.User;

/**
 * 类说明：
 * 
 * @author 作者: ChengJun
 * @version 创建时间：2012-3-25 下午02:31:11
 */
public interface UserService {

	// 添加用户
	public abstract void addUser(User user);

	public abstract void updateUser(User user);

	public abstract void deleteUser(Integer userId);

	public abstract User findUserById(Integer userId);

	public abstract List<User> findAllUser();

	public abstract User login(User user);
	
	public abstract User findRepeat(User user);
	
	public abstract List<User> findUserByType(String userType);

}