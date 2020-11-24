package com.service;

import java.util.List;

import java.util.Map;

import com.entity.Wodehuati;

public interface WodehuatiServer {

  public int add(Wodehuati po);

  public int update(Wodehuati po);
  
  
  
  public int delete(int id);

  public List<Wodehuati> getAll(Map<String,Object> map);
  public List<Wodehuati> getsywodehuati1(Map<String,Object> map);
  public List<Wodehuati> getsywodehuati2(Map<String,Object> map);
  public List<Wodehuati> getsywodehuati3(Map<String,Object> map);
  public Wodehuati quchongWodehuati(Map<String, Object> acount);

  public Wodehuati getById( int id);

  public List<Wodehuati> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Wodehuati> select(Map<String, Object> map);
}
//	æ‰?æœ‰List
