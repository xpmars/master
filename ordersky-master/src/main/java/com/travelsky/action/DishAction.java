package com.travelsky.action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.travelsky.domain.Dish;
import com.travelsky.service.DishService;

public class DishAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 497426678593753641L;
	private static Logger logger = Logger.getLogger(DishAction.class);
	private Map<String, Object> session;
	@Autowired
	private DishService dishService;
	private Dish dish;
	private List<Dish> dishList;
	private String message;     //使用json返回单个值   
	private List<String> inputList;
	public String execute() throws Exception {
		return null;
	}
	public List<Dish> findAll(){
		dishService.findAll();
		return dishList;
	}
	
	
	
	public String addDish(String dish){
		return null;
	}
	
	
	
	
	
	public static Logger getLogger() {
		return logger;
	}
	public static void setLogger(Logger logger) {
		DishAction.logger = logger;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Dish getDish() {
		return dish;
	}
	public void setDish(Dish dish) {
		this.dish = dish;
	}
	public List<Dish> getDishList() {
		return dishList;
	}
	public void setDishList(List<Dish> dishList) {
		this.dishList = dishList;
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
