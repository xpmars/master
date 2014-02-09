package com.travelsky.service;

import java.util.List;

import com.travelsky.domain.Restaurant;

public interface RestService {
	// 添加用户
	public abstract void addRest(Restaurant rest);

	public abstract void updateRest(Restaurant rest);

	public abstract void deleteRest(Integer restId);

	public abstract Restaurant findRestById(Integer restId);

	public abstract List<Restaurant> findAllRest();
}
