package com.travelsky.dao;

import java.util.List;

import com.travelsky.bean.User;

public interface UserDao {
	public void save(User user);  
	public List<User> selectAll();  
    public int countAll();
}
