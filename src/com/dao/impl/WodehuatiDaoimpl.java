package com.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.WodehuatiDao;
import com.entity.Shoucangjilu;
import com.entity.Wodehuati;
import com.entity.Xinwentongzhi;
@Repository
@Transactional(readOnly=true)
public class WodehuatiDaoimpl implements WodehuatiDao{
	@Autowired  
	private SessionFactory sessionfactory;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		Wodehuati s=(Wodehuati)sessionfactory.getCurrentSession().get(Wodehuati.class,id);
		sessionfactory.getCurrentSession().delete(s);
		return 0;
	}

	@Override
	@Transactional
	public int insert(Wodehuati record) {
		sessionfactory.getCurrentSession().save(record);
		return 0;
	}

	@Override
	public int insertSelective(Wodehuati record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Wodehuati selectByPrimaryKey(Integer id) {
		return (Wodehuati)sessionfactory.getCurrentSession().get(Wodehuati.class,id);
	}

	@Override
	public int updateByPrimaryKeySelective(Wodehuati r) {
		String hql="UPDATE Wodehuati SET";
		if(r.getHuatimingcheng()!=null) hql=hql+"huatimingcheng="+r.getHuatimingcheng()+",";
		if(r.getYonghucheng()!=null) hql=hql+"yonghucheng="+r.getYonghucheng()+",";
		if(r.getAddtime()!=null) hql=hql+"addtime="+r.getAddtime();
		hql=hql+"where id="+r.getId()+";";
		sessionfactory.getCurrentSession().createQuery(hql);
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Wodehuati record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Wodehuati quchongWodehuati(Map<String, Object> yonghucheng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Wodehuati> getAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Wodehuati> getsywodehuati1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Wodehuati> getsywodehuati3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Wodehuati> getsywodehuati2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public int getCount(Map<String, Object> po) {
		String hql="select  count(*) from Wodehuati  where 1=1";
		if(po.get("huatimingcheng")!=null) hql=hql+"and huatimingcheng like  concat ('%','"+po.get("huatimingcheng")+"','%')";
		if(po.get("yonghucheng")!=null) hql=hql+"and yonghucheng like  concat ('%','"+po.get("yonghucheng")+"','%')";
		System.out.println(hql);
		List  cout=sessionfactory.getCurrentSession().createQuery(hql).list();
		System.out.println(cout.get(0));
		Number i = (Number)cout.get(0);
		return i.intValue();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Wodehuati> getByPage(Map<String, Object> po) {
		String hql="from Wodehuati where 1=1";
		if(po.get("huatimingcheng")!=null) hql=hql+"and huatimingcheng LIKE CONCAT('%','"+po.get("huatimingcheng")+"','%')";
		if(po.get("yonghucheng")!=null) hql=hql+"and yonghucheng like  concat('%','"+po.get("yonghucheng")+"','%')";
		hql=hql+" order by id desc";
		if(po.get("pageno")!=null&&po.get("pangeSize")!=null) hql=hql+"limit"+po.get("pageno")+","+po.get("pageSize");
		List<Wodehuati> d= sessionfactory.getCurrentSession().createQuery(hql).list();
		System.out.println(d.get(0));
		return d;
	}

	@Override
	public List<Wodehuati> select(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
