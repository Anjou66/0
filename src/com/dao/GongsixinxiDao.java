package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Gongsixinxi;

public interface GongsixinxiDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Gongsixinxi record);

    int insertSelective(Gongsixinxi record);

    Gongsixinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gongsixinxi record);
	
    int updateByPrimaryKey(Gongsixinxi record);
	public Gongsixinxi quchongGongsixinxi(Map<String, Object> gongsibianhao);
	public List<Gongsixinxi> getAll(Map<String, Object> map);
	public List<Gongsixinxi> getsygongsixinxi1(Map<String, Object> map);
	public List<Gongsixinxi> getsygongsixinxi3(Map<String, Object> map);
	public List<Gongsixinxi> getsygongsixinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Gongsixinxi> getByPage(Map<String, Object> map);
	public List<Gongsixinxi> select(Map<String, Object> map);
//	所有List
}

