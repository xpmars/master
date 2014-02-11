package com.travelsky.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelsky.dao.UserDao;
import com.travelsky.domain.User;

/**
 * 类说明：用户dao实现
 * 
 * @author 作者: ChengJun
 * @version 创建时间：2012-3-25 下午02:24:15
 */
@Repository
public class UserDaoImpl implements UserDao {
	private final String INSERT_USER = "insertUser";
	private final String UPDATE_USER = "updateUser";
	private final String DELETE_USER = "deleteUser";
	private final String FIND_USER_BYID = "findUserById";
	private final String FIND_USER_BYTYPE = "findUserByType";
	private final String SELECT_ALL_USER = "selectAllUser";
	private final String USER_LOGIN = "userLogin";
	private final String FIND_REPEAT = "findRepeat";
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pdsu.edu.dao.impl.UserDao#insertUser(com.pdsu.edu.domain.User)
	 */
	public void insertUser(User user) {
		sqlSessionTemplate.insert(INSERT_USER, user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pdsu.edu.dao.impl.UserDao#updateUser(com.pdsu.edu.domain.User)
	 */
	public void updateUser(User user) {
		sqlSessionTemplate.update(UPDATE_USER, user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pdsu.edu.dao.impl.UserDao#deleteUser(java.lang.Integer)
	 */
	public void deleteUser(Integer userId) {
		sqlSessionTemplate.delete(DELETE_USER, userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pdsu.edu.dao.impl.UserDao#findUserByid(java.lang.Integer)
	 */
	public User findUserByid(Integer userId) {
		return sqlSessionTemplate.selectOne(FIND_USER_BYID, userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pdsu.edu.dao.impl.UserDao#findAll()
	 */
	public List<User> findAll() {
		return sqlSessionTemplate.selectList(SELECT_ALL_USER);
	}

	public User userLogin(User user) {
		return sqlSessionTemplate.selectOne(USER_LOGIN, user);
	}

	public User findRepeat(User user) {
		return sqlSessionTemplate.selectOne(FIND_REPEAT, user);
	}

	/* (non-Javadoc)
	 * @see com.travelsky.dao.UserDao#findUserByType(java.lang.String)
	 */
	public List<User> findUserByType(String type) {
		return sqlSessionTemplate.selectList(FIND_USER_BYTYPE,type);
	}
}
