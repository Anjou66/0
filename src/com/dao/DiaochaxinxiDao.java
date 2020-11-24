package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.*;

public interface DiaochaxinxiDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Diaochaxinxi record);

    int insertSelective(Diaochaxinxi record);

    Diaochaxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Diaochaxinxi record);
	
    int updateByPrimaryKey(Diaochaxinxi record);
	public Diaochaxinxi quchongDiaochaxinxi(Map<String, Object> gongsibianhao);
	public List<Diaochaxinxi> getAll(Map<String, Object> map);
	public List<Diaochaxinxi> getsydiaochaxinxi1(Map<String, Object> map);
	public List<Diaochaxinxi> getsydiaochaxinxi3(Map<String, Object> map);
	public List<Diaochaxinxi> getsydiaochaxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Diaochaxinxi> getByPage(Map<String, Object> map);
	public List<Diaochaxinxi> select(Map<String, Object> map);
//	所有List
}

