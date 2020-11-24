package com.service;

import java.util.List;

import java.util.Map;

import com.entity.Diaochaxinxi;

public interface DiaochaxinxiServer {

  public int add(Diaochaxinxi po);

  public int update(Diaochaxinxi po);
  
  
  
  public int delete(int id);

  public List<Diaochaxinxi> getAll(Map<String,Object> map);
  public List<Diaochaxinxi> getsydiaochaxinxi1(Map<String,Object> map);
  public List<Diaochaxinxi> getsydiaochaxinxi2(Map<String,Object> map);
  public List<Diaochaxinxi> getsydiaochaxinxi3(Map<String,Object> map);
  public Diaochaxinxi quchongDiaochaxinxi(Map<String, Object> acount);

  public Diaochaxinxi getById( int id);

  public List<Diaochaxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Diaochaxinxi> select(Map<String, Object> map);
}
//	æ‰?æœ‰List
