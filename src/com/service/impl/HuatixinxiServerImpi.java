package com.service.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.HuatixinxiDao;
import com.entity.Huatixinxi;
import com.service.*;
@Service
public class HuatixinxiServerImpi implements HuatixinxiServer {
   @Resource
   private HuatixinxiDao gdao;
	@Override
	public int add(Huatixinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Huatixinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Huatixinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Huatixinxi> getsyhuatixinxi1(Map<String, Object> map) {
		return gdao.getsyhuatixinxi1(map);
	}
	public List<Huatixinxi> getsyhuatixinxi2(Map<String, Object> map) {
		return gdao.getsyhuatixinxi2(map);
	}
	public List<Huatixinxi> getsyhuatixinxi3(Map<String, Object> map) {
		return gdao.getsyhuatixinxi3(map);
	}
	
	@Override
	public Huatixinxi quchongHuatixinxi(Map<String, Object> account) {
		return gdao.quchongHuatixinxi(account);
	}

	@Override
	public List<Huatixinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Huatixinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Huatixinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

