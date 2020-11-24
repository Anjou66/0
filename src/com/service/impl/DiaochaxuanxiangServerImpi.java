package com.service.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.DiaochaxuanxiangDao;
import com.entity.Diaochaxuanxiang;
import com.service.*;
@Service
public class DiaochaxuanxiangServerImpi implements DiaochaxuanxiangServer {
   @Resource
   private DiaochaxuanxiangDao gdao;
	@Override
	public int add(Diaochaxuanxiang po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Diaochaxuanxiang po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Diaochaxuanxiang> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Diaochaxuanxiang> getsydiaochaxuanxiang1(Map<String, Object> map) {
		return gdao.getsydiaochaxuanxiang1(map);
	}
	public List<Diaochaxuanxiang> getsydiaochaxuanxiang2(Map<String, Object> map) {
		return gdao.getsydiaochaxuanxiang2(map);
	}
	public List<Diaochaxuanxiang> getsydiaochaxuanxiang3(Map<String, Object> map) {
		return gdao.getsydiaochaxuanxiang3(map);
	}
	
	@Override
	public Diaochaxuanxiang quchongDiaochaxuanxiang(Map<String, Object> account) {
		return gdao.quchongDiaochaxuanxiang(account);
	}

	@Override
	public List<Diaochaxuanxiang> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Diaochaxuanxiang> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Diaochaxuanxiang getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

