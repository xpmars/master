package com.travelsky.action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.travelsky.context.CacheLoder;
import com.travelsky.domain.User;
import com.travelsky.exception.UserException;
import com.travelsky.service.UserService;
import com.travelsky.util.EmailUtil;

/**
 * 类说明：用户Action
 * 
 * @author 作者: ChengJun
 * @version 创建时间：2012-3-25 下午03:29:52
 */
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3932431741172282690L;
	private static Logger logger = Logger.getLogger(UserAction.class);
	private Map<String, Object> session;
	@Autowired
	private UserService userService;
	private User user;
	private List<User> userList;
	private String message; // 使用json返回单个值
	private List<String> inputList;

	public String execute() throws Exception {
		return null;
	}

	public String login() {
		System.out.println(user);
		
		if(EmailUtil.validateEmail(user.getEmail()) == false){
			logger.error("登陆失败,邮箱格式不正确！");
			return ERROR;
		}
		if (user != null) {
			User user2 = userService.login(user);
			if (user2 != null) {
				setSession(ServletActionContext.getContext().getSession());
				putSession(user2);
				logger.info("登陆成功，返回session");
				return SUCCESS;
			} else {
				logger.debug("登陆-数据库中暂无该用户数据");
				User user3 = userService.validateLdap(user);
				if (user3 != null) {
					setSession(ServletActionContext.getContext().getSession());
					putSession(user3);
					logger.info("登陆成功，返回session");
					return SUCCESS;
				}
			}
		}
		logger.error("登陆失败");
		return ERROR;
	}

	/** 统一设置返回的Session值
	 * @param user2
	 */
	private void putSession(User user) {
		getSession().put("id", user.getId());
		getSession().put("email", user.getEmail());
		getSession().put("username", user.getUsername());
		getSession().put("name", user.getName());
		getSession().put("type", user.getUsertype());
		getSession().put("henchman", user.getHenchman());
	}

	public String logout() {
		logger.info("登出");
		ServletActionContext.getContext().getSession().clear();
		return SUCCESS;
	}

	public String addUI() {
		return "addUser";
	}

	public String updateUI() {
		user = userService.findUserById(user.getId());
		return "updateUser";
	}

	public String add() {
		try {
			userService.addUser(user);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String reg() {
		System.out.println(user);
		// 首先进行校验
		if (user != null) {
			if (user.getEmail() == null || "".equals(user.getEmail())) {
				message = "mailError";
				logger.error("注册失败，邮箱为空");
				return "reg_error";
			}

			if (user.getTelephone() == null || "".equals(user.getTelephone())) {
				message = "telError";
				logger.error("注册失败，手机号为空");
				return "reg_error";
			}

			if (user.getPassword() == null || user.getPassword2() == null
					|| "".equals(user.getPassword())) {
				message = "pswError";
				logger.error("注册失败，密码为空");
				return "reg_error";
			}
			if (!user.getPassword().equals(user.getPassword2())) {
				message = "pswError";
				logger.error("注册失败，输入两密码不一致");
				return "reg_error";
			}
			if (user.getPassword().length() < 6) {
				message = "pswError";
				logger.error("注册失败，输入密码长度太短");
				return "reg_error";
			}
			// 查看数据库中是否用重复
			User user2 = userService.findRepeat(user);
			if (user2 == null) {
				try {
					userService.addUser(user);
				} catch (UserException e) {
					message = "ldapError";
					logger.error("注册失败，Ldap验证不通过");
					e.printStackTrace();
					return "reg_error";
				}
				setSession(ServletActionContext.getContext().getSession());
				getSession().put("email", user.getEmail());
				getSession().put("type", user.getUsertype());
				logger.info("注册成功");
				message = "success";
				return "reg_success";
			} else {
				message = "error";
				return "reg_error";
			}

		}
		logger.error("注册失败，其他原因");
		message = "error";
		return "reg_error";
	}

	public String findRep() {
		message = "emailError";
		if (user != null) {
			User user2;
			user2 = userService.findRepeat(user);
			System.out.println(user);
			if (user2 == null) {
				logger.info("注册-该邮箱可用");
				message = "emailSuccess";
				return "message";
			}

		}
		logger.error("注册-邮箱名重复,不可用");
		return "message";
	}

	public String delete() {
		userService.deleteUser(user.getId());
		return SUCCESS;
	}

	public String update() {
		userService.updateUser(user);
		return SUCCESS;
	}

	public String getBenchmanList() {
		logger.info("获取缓存中的订饭官列表...");
		userList = CacheLoder.cacheUserList;
		System.out.println("UserList: " + userList);
		return "userList";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String queryAllUser() {
		userList = userService.findAllUser();
		return "userList";
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getInputList() {
		return inputList;
	}

	public void setInputList(List<String> inputList) {
		this.inputList = inputList;
	}

}
