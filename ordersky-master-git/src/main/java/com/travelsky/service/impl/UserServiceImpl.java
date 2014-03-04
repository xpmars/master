package com.travelsky.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelsky.context.CacheLoder;
import com.travelsky.dao.UserDao;
import com.travelsky.domain.User;
import com.travelsky.exception.UserException;
import com.travelsky.service.UserService;
import com.travelsky.util.LdapAuthenticateUtil;

/**
 * 类说明：用户Service实现
 * 
 * @author 作者: ChengJun
 * @version 创建时间：2012-3-25 下午02:26:48
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;

	// 添加用户
	public void addUser(User user) throws UserException {

		logger.info("注册-再查看Ldap库中是否有重复用户数据。");
		String emailHostName = user.getEmail().split("@")[1];
		if (emailHostName.contains("travelsky")) {
			logger.debug("注册-进行travelsky主机名验证。");
			boolean checkResult = LdapAuthenticateUtil.authenricate(user.getEmail(),
					user.getPassword());
			if (checkResult == true) {// 通过Ldap验证
				logger.debug("注册-通过Ldap验证。");
			} else {
				logger.debug("注册-未通过Ldap验证。");
				throw new UserException("Ldap验证travelsky邮箱失败，请重新注册。");
			}
		}

		userDao.insertUser(user);
		if ("订饭官".equals(user.getUsertype())) {
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
		return userDao.findUserById(userId);
	}

	public List<User> findAllUser() {
		return userDao.findAll();
	}

	public User login(User user) {
		logger.info("登录-返回用户信息");
		return userDao.userLogin(user);
	}
	public User validateLdap(User user){
		logger.debug("登录-查看用户是否属于travelsky用户。");
		String emailHostName = user.getEmail().split("@")[1];
		if (emailHostName.contains("travelsky")) {
			logger.debug("登录-该用户属于travelsky用户。");
			logger.debug("登录-进行travelsky主机名验证。");	
			boolean checkResult = LdapAuthenticateUtil
					.authenricate(user.getEmail(), user.getPassword());
			// 首先进行LDAP校验
			if (checkResult == true) {
				logger.info("登录-通过LDAP校验");
				if (userDao.findUserByEmail(user.getEmail()) == null) {
					logger.info("登录-而本地数据库中无该用户数据，将其插入");
					if(user.getUsertype() == null || "".equals(user.getUsertype())){
						user.setUsertype("吃货");//登陆用户默认为吃货
					}
					userDao.insertUser(user);
				} else {
					logger.debug("登录-本地数据库中已有该用户数据");
				}
				return user;
			} else {
				logger.debug("登录-未通过LDAP校验，进入普通用户登录流程...");
			}
		}else{
			logger.error("登录-该用户不属于travelsky用户。");
		}
		return null;
	}

	public User findRepeat(User user) {
		logger.info("註冊-查看是否有重复数据。");
		return userDao.findRepeat(user);
	}

	public List<User> findUserByType(String userType) {
		return userDao.findUserByType(userType);
	}
}
