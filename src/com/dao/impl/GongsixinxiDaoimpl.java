package com.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.GongsixinxiDao;
import com.entity.Allusers;
import com.entity.Gongsixinxi;
import com.entity.Huatixinxi;
@Repository
@Transactional(readOnly=true)
public class GongsixinxiDaoimpl implements GongsixinxiDao {
	@Autowired
	private SessionFactory sessionfactory;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		Gongsixinxi gong=sessionfactory.getCurrentSession().get(Gongsixinxi.class,id);
		sessionfactory.getCurrentSession().delete(gong);
		return 0;
	}

	@Override
	public int insert(Gongsixinxi record) {
		sessionfactory.getCurrentSession().save(record);
		return 0;
	}

	@Override
	public int insertSelective(Gongsixinxi record) {
		return 0;
	}

	@Override
	public Gongsixinxi selectByPrimaryKey(Integer id) {
		return (Gongsixinxi)sessionfactory.getCurrentSession().get(Gongsixinxi.class, id);
		
	}

	@Override
	public int updateByPrimaryKeySelective(Gongsixinxi record) {
		sessionfactory.getCurrentSession().update(record);
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Gongsixinxi record) {
		sessionfactory.getCurrentSession().update(record);
		return 0;
	}

	@Override
	public Gongsixinxi quchongGongsixinxi(Map<String, Object> gongsibianhao) {
		String hql=" from Gongsixinxi where gongsibianhao='"+(String)gongsibianhao.get("gongsibianhao")+"'";
		Gongsixinxi s=(Gongsixinxi)sessionfactory.getCurrentSession().createQuery(hql).uniqueResult();
		System.out.println(hql);
		return s;
	}

	@Override
	public List<Gongsixinxi> getAll(Map<String, Object> map) {
		//sessionfactory.getCurrentSession().get(Gongsixinxi.class,(String)map.getClass())
		return null;
	}

	@Override
	public List<Gongsixinxi> getsygongsixinxi1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gongsixinxi> getsygongsixinxi3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gongsixinxi> getsygongsixinxi2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public int getCount(Map<String, Object> po) {
		String hql="select  count(*) from Gongsixinxi where 1=1";
		if(po.get("gongsibianhao")!=null) hql=hql+"and gongsibianhao LIKE CONCAT('%','"+po.get("gongsibianhao")+"','%')";
		if(po.get("mima")!=null) hql=hql+"and mima LIKE CONCAT('%','"+po.get("mima")+"','%')";
		if(po.get("youxiang")!=null) hql=hql+"and youxiang like  concat('%','"+po.get("youxiang")+"','%')";
		if(po.get("gongsimingcheng")!=null) hql=hql+"and gongsimingcheng like  concat('%','"+po.get("gongsimingcheng")+"','%')";
		if(po.get("leixing")!=null) hql=hql+"and leixing like  concat('%','"+po.get("leixing")+"','%')";
		if(po.get("xingye")!=null) hql=hql+"and xingye like  concat('%','"+po.get("xingye")+"','%')";
		if(po.get("guimo")!=null) hql=hql+"and guimo like  concat('%','"+po.get("guimo")+"','%')";
		if(po.get("jianjie")!=null) hql=hql+"and jianjie like  concat('%','"+po.get("jianjie")+"','%')";
		System.out.println(hql);
		List  cout=sessionfactory.getCurrentSession().createQuery(hql).list();
		System.out.println(cout.get(0));
		Number i = (Number)cout.get(0);
		return i.intValue();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Gongsixinxi> getByPage(Map<String, Object> po) {
		String hql=" from Gongsixinxi where 1=1";
		if(po.get("gongsibianhao")!=null) hql=hql+"and gongsibianhao LIKE CONCAT('%','"+po.get("gongsibianhao")+"','%')";
		if(po.get("mima")!=null) hql=hql+"and mima like  concat('%','"+po.get("mima")+"','%')";
		if(po.get("youxiang")!=null) hql=hql+"and youxiang like  concat('%','"+po.get("youxiang")+"','%')";
		if(po.get("gongsimingcheng")!=null) hql=hql+"and gongsimingcheng like  concat('%','"+po.get("gongsimingcheng")+"','%')";
		if(po.get("leixing")!=null) hql=hql+"and leixing like  concat('%','"+po.get("leixing")+"','%')";
		if(po.get("xingye")!=null) hql=hql+"and xingye like  concat('%','"+po.get("xingye")+"','%')";
		if(po.get("guimo")!=null) hql=hql+"and guimo like  concat('%','"+po.get("guimo")+"','%')";
		if(po.get("jianjie")!=null) hql=hql+"and jianjie like  concat('%','"+po.get("jianjie")+"','%')";
		hql=hql+" order by id desc";
		if(po.get("pageno")!=null&&po.get("pangeSize")!=null) hql=hql+"limit"+po.get("pageno")+","+po.get("pageSize");
		List<Gongsixinxi> d= sessionfactory.getCurrentSession().createQuery(hql).list();
		System.out.println(d.get(0));
		return d;
	
	}

	@Override
	public List<Gongsixinxi> select(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
