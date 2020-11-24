package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Huatixinxi;

public interface HuatixinxiDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Huatixinxi record);

    int insertSelective(Huatixinxi record);

    Huatixinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Huatixinxi record);
	
    int updateByPrimaryKey(Huatixinxi record);
	public Huatixinxi quchongHuatixinxi(Map<String, Object> huatimingcheng);
	public List<Huatixinxi> getAll(Map<String, Object> map);
	public List<Huatixinxi> getsyhuatixinxi1(Map<String, Object> map);
	public List<Huatixinxi> getsyhuatixinxi3(Map<String, Object> map);
	public List<Huatixinxi> getsyhuatixinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Huatixinxi> getByPage(Map<String, Object> map);
	public List<Huatixinxi> select(Map<String, Object> map);
//	所有List
}

