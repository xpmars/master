/**   
* @Title: TriggerDaoImpl.java
* @author chengjun(chengjun@travelsky.com) 
* @date 2014-2-27 下午12:44:05  
* @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
*/
package com.travelsky.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelsky.dao.TriggerDao;
import com.travelsky.domain.Trigger;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com)  @2014-2-27
 */
@Repository
public class TriggerDaoImpl implements TriggerDao {
	private final String INSERT_TRIGGER = "insertTrigger";
	private final String UPDATE_TRIGGER = "updateTrigger";
	private final String DELETE_TRIGGER = "deleteTrigger";
	private final String FIND_TRIGGER_BYHENCHMAN = "findTriggerByHenchman";
	private final String SELECT_ALL_TRIGGER = "selectAllTrigger";
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	/* (non-Javadoc)
	 * @see com.travelsky.dao.TriggerDao#findTriggerByHenchman(java.lang.String)
	 */
	public List<Trigger> findTriggerByHenchman(String henchman) {
		return sqlSessionTemplate.selectList(FIND_TRIGGER_BYHENCHMAN, henchman);
	}

	/* (non-Javadoc)
	 * @see com.travelsky.dao.TriggerDao#findAll()
	 */
	public List<Trigger> findAll() {
		return null;
	}

}
