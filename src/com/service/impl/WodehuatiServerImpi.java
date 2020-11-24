package com.service.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.WodehuatiDao;
import com.entity.Wodehuati;
import com.service.WodehuatiServer;
@Service
public class WodehuatiServerImpi implements WodehuatiServer {
   @Resource
   private WodehuatiDao gdao;
	@Override
	public int add(Wodehuati po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Wodehuati po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Wodehuati> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Wodehuati> getsywodehuati1(Map<String, Object> map) {
		return gdao.getsywodehuati1(map);
	}
	public List<Wodehuati> getsywodehuati2(Map<String, Object> map) {
		return gdao.getsywodehuati2(map);
	}
	public List<Wodehuati> getsywodehuati3(Map<String, Object> map) {
		return gdao.getsywodehuati3(map);
	}
	
	@Override
	public Wodehuati quchongWodehuati(Map<String, Object> account) {
		return gdao.quchongWodehuati(account);
	}

	@Override
	public List<Wodehuati> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Wodehuati> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Wodehuati getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

