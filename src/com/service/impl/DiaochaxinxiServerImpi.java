package com.service.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.DiaochaxinxiDao;
import com.entity.Diaochaxinxi;
import com.service.*;
@Service
public class DiaochaxinxiServerImpi implements DiaochaxinxiServer {
	@Resource
   	private DiaochaxinxiDao gdao;
	@Override
	public int add(Diaochaxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Diaochaxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Diaochaxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	@Override
	public List<Diaochaxinxi> getsydiaochaxinxi1(Map<String, Object> map) {
		return gdao.getsydiaochaxinxi1(map);
	}
	@Override
	public List<Diaochaxinxi> getsydiaochaxinxi2(Map<String, Object> map) {
		return gdao.getsydiaochaxinxi2(map);
	}
	@Override
	public List<Diaochaxinxi> getsydiaochaxinxi3(Map<String, Object> map) {
		return gdao.getsydiaochaxinxi3(map);
	}
	
	@Override
	public Diaochaxinxi quchongDiaochaxinxi(Map<String, Object> account) {
		return gdao.quchongDiaochaxinxi(account);
	}

	@Override
	public List<Diaochaxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Diaochaxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Diaochaxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

