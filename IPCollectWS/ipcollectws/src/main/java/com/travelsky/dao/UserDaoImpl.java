package com.travelsky.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.travelsky.bean.User;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
	private static final String INSERT_SQL = "insert into user(username,password,comment) values(?,?,?)";
	private static final String SELECTALL_SQL = "select * from user";
	private static final String COUNT_ALL_SQL = "select count(*) from user";

	@Override
	public void save(User user) {
		getJdbcTemplate().update(INSERT_SQL, user.getUsername(),
				user.getPassword(), user.getComment());
	}

	@Override
	public List<User> selectAll() {
		List<User> userList = new ArrayList<User>();
		List<Map<String, Object>> userListMap = getJdbcTemplate().queryForList(
				SELECTALL_SQL);
		for (Iterator<Map<String, Object>> iterator = userListMap.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			User user = new User();
			user.setUserid(Integer.parseInt(map.get("userid").toString()));
			user.setUsername(map.get("username").toString());
			user.setPassword(map.get("password").toString());
			user.setComment(map.get("comment").toString());
			userList.add(user);
		}
		return userList;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int countAll() {
		return getJdbcTemplate().queryForInt(COUNT_ALL_SQL);
	}

}
