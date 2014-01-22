package com.travelsky.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.travelsky.bean.IpAdress;

public interface IpDao {
	int insert(IpAdress entity);//增
	void BatchInsert(List<IpAdress> ipAdressList);//增
	void VerifyInsert(List<IpAdress> ipAdressList);//增
	boolean deleteById();//删
	int deleteRep();//删重复
	boolean deleteByDate(Date date);//删
	int deleteByIsAlive();//删
	int update(IpAdress entity);//改
	int[] BatchUpdate(List<IpAdress> ipAdressList);//增
	IpAdress queryById(Integer id);//查
	ArrayList<IpAdress>  queryAll();//查
	ArrayList<IpAdress> queryIsDomestic(boolean flag);//查
	ArrayList<IpAdress> queryIsAlived(boolean flag);//查
	int getRecordCount();
	ArrayList<IpAdress> queryIp(IpAdress entity);//查询
}
