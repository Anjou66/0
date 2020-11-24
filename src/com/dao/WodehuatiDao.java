package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Wodehuati;

public interface WodehuatiDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Wodehuati record);

    int insertSelective(Wodehuati record);

    Wodehuati selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wodehuati record);
	
    int updateByPrimaryKey(Wodehuati record);
	public Wodehuati quchongWodehuati(Map<String, Object> yonghucheng);
	public List<Wodehuati> getAll(Map<String, Object> map);
	public List<Wodehuati> getsywodehuati1(Map<String, Object> map);
	public List<Wodehuati> getsywodehuati3(Map<String, Object> map);
	public List<Wodehuati> getsywodehuati2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Wodehuati> getByPage(Map<String, Object> map);
	public List<Wodehuati> select(Map<String, Object> map);
//	所有List
}

