package com.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DiaochaxuanxiangDao;
import com.entity.Allusers;
import com.entity.Diaochaxuanxiang;
import com.entity.Gongsixinxi;
@Repository
@Transactional(readOnly=true)
public class DiaochaxuanxiangDaoimpl implements DiaochaxuanxiangDao {
	@Autowired
	private SessionFactory sessionfactory;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		Diaochaxuanxiang user=sessionfactory.getCurrentSession().get(Diaochaxuanxiang.class,id);
		sessionfactory.getCurrentSession().delete(user);
		return 0;
	}

	@Override
	public int insert(Diaochaxuanxiang r) {
		//String hql="insert into Diaochaxuanxiang ("+r.getId()+","+r.getBiaoti()+","+r.getXuanxiangA()+","+r.getXuanxiangB()+","+r.getXuanxiangC()+","+r.getDaan()+","+r.getDiaochabianhao()+","+r.getGongsibianhao()+","+r.getAddtime()+")";
		//sessionfactory.getCurrentSession().createQuery(hql);
		sessionfactory.getCurrentSession().save(r);
		return 0;
	}

	@Override
	public int insertSelective(Diaochaxuanxiang record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Diaochaxuanxiang selectByPrimaryKey(Integer id) {
		return (Diaochaxuanxiang)sessionfactory.getCurrentSession().get(Diaochaxuanxiang.class,id);
		
	}

	@Override
	public int updateByPrimaryKeySelective(Diaochaxuanxiang record) {
		sessionfactory.getCurrentSession().update(record);
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Diaochaxuanxiang record) {
		
		return 0;
	}

	@Override
	public Diaochaxuanxiang quchongDiaochaxuanxiang(Map<String, Object> gongsibianhao) {
	
		return null;
	}

	@Override
	public List<Diaochaxuanxiang> getAll(Map<String, Object> map) {
		
		return null;
	}

	@Override
	public List<Diaochaxuanxiang> getsydiaochaxuanxiang1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Diaochaxuanxiang> getsydiaochaxuanxiang3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Diaochaxuanxiang> getsydiaochaxuanxiang2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount(Map<String, Object> po) {
		String hql="select  count(*) from Diaochaxuanxiang where 1=1";
		if(po.get("biaoti")!=null) hql=hql+"and biaoti LIKE CONCAT('%','"+po.get("biaoti")+"','%')";
		if(po.get("xuanxiangA")!=null) hql=hql+"and xuanxiangA like  concat('%','"+po.get("xuanxiangA")+"','%')";
		if(po.get("xuanxiangB")!=null) hql=hql+"and xuanxiangB like  concat('%','"+po.get("xuanxiangB")+"','%')";
		if(po.get("xuanxiangC")!=null) hql=hql+"and xuanxiangC like  concat('%','"+po.get("xuanxiangC")+"','%')";
		if(po.get("daan")!=null) hql=hql+"and daan like  concat('%','"+po.get("daan")+"','%')";
		if(po.get("diaochabianhao")!=null) hql=hql+"and diaochabianhao like  concat('%','"+po.get("diaochabianhao")+"','%')";
		if(po.get("gongsibianhao")!=null) hql=hql+"and gongsibianhao like  concat('%','"+po.get("gongsibianhao")+"','%')";
		System.out.println(hql);
		List  cout=sessionfactory.getCurrentSession().createQuery(hql).list();
		System.out.println(cout.get(0));
		Number i = (Number)cout.get(0);
		return i.intValue();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Diaochaxuanxiang> getByPage(Map<String, Object> po) {
		String hql="from Diaochaxuanxiang where 1=1";
		if(po.get("biaoti")!=null) hql=hql+"and biaoti LIKE CONCAT('%','"+po.get("biaoti")+"','%')";
		if(po.get("xuanxiangA")!=null) hql=hql+"and xuanxiangA like  concat('%','"+po.get("xuanxiangA")+"','%')";
		if(po.get("xuanxiangB")!=null) hql=hql+"and xuanxiangB like  concat('%','"+po.get("xuanxiangB")+"','%')";
		if(po.get("xuanxiangC")!=null) hql=hql+"and xuanxiangC like  concat('%','"+po.get("xuanxiangC")+"','%')";
		if(po.get("daan")!=null) hql=hql+"and daan like  concat('%','"+po.get("daan")+"','%')";
		if(po.get("diaochabianhao")!=null) hql=hql+"and diaochabianhao like  concat('%','"+po.get("diaochabianhao")+"','%')";
		if(po.get("gongsibianhao")!=null) hql=hql+"and gongsibianhao like  concat('%','"+po.get("gongsibianhao")+"','%')";
		hql=hql+" order by id desc";
		if(po.get("pageno")!=null&&po.get("pangeSize")!=null) hql=hql+"limit"+po.get("pageno")+","+po.get("pageSize");
		List<Diaochaxuanxiang> d= sessionfactory.getCurrentSession().createQuery(hql).list();
		return d;	
	}

	@Override
	public List<Diaochaxuanxiang> select(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
