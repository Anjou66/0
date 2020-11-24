package com.service;

import java.util.List;

import java.util.Map;

import com.entity.Gongsixinxi;

public interface GongsixinxiServer {

  public int add(Gongsixinxi po);

  public int update(Gongsixinxi po);
  
  
  
  public int delete(int id);

  public List<Gongsixinxi> getAll(Map<String,Object> map);
  public List<Gongsixinxi> getsygongsixinxi1(Map<String,Object> map);
  public List<Gongsixinxi> getsygongsixinxi2(Map<String,Object> map);
  public List<Gongsixinxi> getsygongsixinxi3(Map<String,Object> map);
  public Gongsixinxi quchongGongsixinxi(Map<String, Object> acount);

  public Gongsixinxi getById( int id);

  public List<Gongsixinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Gongsixinxi> select(Map<String, Object> map);
}
//	æ‰?æœ‰List
