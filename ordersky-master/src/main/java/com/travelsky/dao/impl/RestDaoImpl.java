package com.travelsky.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelsky.dao.RestDao;
import com.travelsky.domain.Restaurant;

/**
 * 类说明：用户dao实现
 * 
 * @author 作者: ChengJun
 * @version 创建时间：2012-3-25 下午02:24:15
 */
@Repository
public class RestDaoImpl implements RestDao {
	private final String INSERT_REST = "insertRest";
	private final String UPDATE_REST = "updateRest";
	private final String DELETE_REST = "deleteRest";
	private final String FIND_REST_BYID = "findRestById";
	private final String SELECT_ALL_REST = "selectAllRest";
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pdsu.edu.dao.impl.UserDao#insertUser(com.pdsu.edu.domain.User)
	 */
	public void insertRest(Restaurant rest) {
		sqlSessionTemplate.insert(INSERT_REST, rest);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pdsu.edu.dao.impl.UserDao#updateUser(com.pdsu.edu.domain.User)
	 */
	public void updateRest(Restaurant rest) {
		sqlSessionTemplate.update(UPDATE_REST, rest);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pdsu.edu.dao.impl.UserDao#deleteUser(java.lang.Integer)
	 */
	public void deleteRest(Integer restId) {
		sqlSessionTemplate.delete(DELETE_REST, restId);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pdsu.edu.dao.impl.UserDao#findUserByid(java.lang.Integer)
	 */
	public Restaurant findRestByid(Integer restId) {
		return sqlSessionTemplate.selectOne(FIND_REST_BYID, restId);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pdsu.edu.dao.impl.UserDao#findAll()
	 */
	public List<Restaurant> findAll() {
		return sqlSessionTemplate.selectList(SELECT_ALL_REST);
	}

}
