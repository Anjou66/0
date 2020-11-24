package com.service.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.GongsixinxiDao;
import com.entity.Gongsixinxi;
import com.service.*;
@Service
public class GongsixinxiServerImpi implements GongsixinxiServer {
   @Resource
   private GongsixinxiDao gdao;
	@Override
	public int add(Gongsixinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Gongsixinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Gongsixinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Gongsixinxi> getsygongsixinxi1(Map<String, Object> map) {
		return gdao.getsygongsixinxi1(map);
	}
	public List<Gongsixinxi> getsygongsixinxi2(Map<String, Object> map) {
		return gdao.getsygongsixinxi2(map);
	}
	public List<Gongsixinxi> getsygongsixinxi3(Map<String, Object> map) {
		return gdao.getsygongsixinxi3(map);
	}
	
	@Override
	public Gongsixinxi quchongGongsixinxi(Map<String, Object> account) {
		return gdao.quchongGongsixinxi(account);
	}

	@Override
	public List<Gongsixinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Gongsixinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Gongsixinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

