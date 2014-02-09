package com.travelsky.dao;

import java.util.List;

import com.travelsky.domain.Restaurant;

public interface RestDao {
	
	public abstract void insertRest(Restaurant rest);

	public abstract void updateRest(Restaurant rest);

	public abstract void deleteRest(Integer restId);

	public abstract Restaurant findRestByid(Integer restId);

	public abstract List<Restaurant> findAll();
}
