package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Diaochaxuanxiang;

public interface DiaochaxuanxiangDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Diaochaxuanxiang record);

    int insertSelective(Diaochaxuanxiang record);

    Diaochaxuanxiang selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Diaochaxuanxiang record);
	
    int updateByPrimaryKey(Diaochaxuanxiang record);
	public Diaochaxuanxiang quchongDiaochaxuanxiang(Map<String, Object> gongsibianhao);
	public List<Diaochaxuanxiang> getAll(Map<String, Object> map);
	public List<Diaochaxuanxiang> getsydiaochaxuanxiang1(Map<String, Object> map);
	public List<Diaochaxuanxiang> getsydiaochaxuanxiang3(Map<String, Object> map);
	public List<Diaochaxuanxiang> getsydiaochaxuanxiang2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Diaochaxuanxiang> getByPage(Map<String, Object> map);
	public List<Diaochaxuanxiang> select(Map<String, Object> map);
//	所有List
}

