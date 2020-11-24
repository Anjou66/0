package com.service;

import java.util.List;

import java.util.Map;

import com.entity.Diaochaxuanxiang;

public interface DiaochaxuanxiangServer {

  public int add(Diaochaxuanxiang po);

  public int update(Diaochaxuanxiang po);
  
  
  
  public int delete(int id);

  public List<Diaochaxuanxiang> getAll(Map<String,Object> map);
  public List<Diaochaxuanxiang> getsydiaochaxuanxiang1(Map<String,Object> map);
  public List<Diaochaxuanxiang> getsydiaochaxuanxiang2(Map<String,Object> map);
  public List<Diaochaxuanxiang> getsydiaochaxuanxiang3(Map<String,Object> map);
  public Diaochaxuanxiang quchongDiaochaxuanxiang(Map<String, Object> acount);

  public Diaochaxuanxiang getById( int id);

  public List<Diaochaxuanxiang> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Diaochaxuanxiang> select(Map<String, Object> map);
}
//	æ‰?æœ‰List
