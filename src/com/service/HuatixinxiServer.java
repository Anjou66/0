package com.service;

import java.util.List;

import java.util.Map;

import com.entity.Huatixinxi;

public interface HuatixinxiServer {

  public int add(Huatixinxi po);

  public int update(Huatixinxi po);
  
  
  
  public int delete(int id);

  public List<Huatixinxi> getAll(Map<String,Object> map);
  public List<Huatixinxi> getsyhuatixinxi1(Map<String,Object> map);
  public List<Huatixinxi> getsyhuatixinxi2(Map<String,Object> map);
  public List<Huatixinxi> getsyhuatixinxi3(Map<String,Object> map);
  public Huatixinxi quchongHuatixinxi(Map<String, Object> acount);

  public Huatixinxi getById( int id);

  public List<Huatixinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Huatixinxi> select(Map<String, Object> map);
}
//	æ‰?æœ‰List
