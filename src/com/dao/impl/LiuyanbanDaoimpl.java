package com.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.LiuyanbanDao;
import com.entity.Liuyanban;
@Repository
@Transactional(readOnly=true)
public class LiuyanbanDaoimpl implements LiuyanbanDao{
	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		Liuyanban l=(Liuyanban)sessionfactory.getCurrentSession().get(Liuyanban.class,id);
		sessionfactory.getCurrentSession().delete(l);
		return 0;
	}

	@Override
	@Transactional
	public int insert(Liuyanban record) {
		sessionfactory.getCurrentSession().save(record);
		return 0;
	}

	@Override
	public int insertSelective(Liuyanban record) {	
		return 0;
	}

	@Override
	public Liuyanban selectByPrimaryKey(Integer id) {
		return (Liuyanban)sessionfactory.getCurrentSession().get(Liuyanban.class,id);		
	}

	@Override
	public int updateByPrimaryKeySelective(Liuyanban record) {
		sessionfactory.getCurrentSession().update(record);
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelectivelb(Liuyanban record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Liuyanban record) {
		String hql="update Liuyanban set";
		if( record.getHuifuneirong()!=null) hql=hql+"huifuneirong="+record.getHuifuneirong();
		hql=hql+"where id="+record.getId();
		sessionfactory.getCurrentSession().createQuery(hql);
		return 0;
	}

	@Override
	public Liuyanban quchongLiuyanban(Map<String, Object> uname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Liuyanban> getAll(Map<String, Object> map) {
		
		return null;
	}

	@Override
	public List<Liuyanban> getsyliuyanban1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Liuyanban> getsyliuyanban3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Liuyanban> getsyliuyanban2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public int getCount(Map<String, Object> po) {
		String hql="select  count(*) from Liuyanban where 1=1";
		if(po.get("cheng")!=null) hql=hql+"and cheng LIKE CONCAT('%','"+po.get("cheng")+"','%')";
		if(po.get("xingbie")!=null) hql=hql+"and xingbie LIKE CONCAT('%','"+po.get("xingbie")+"','%')";
		if(po.get("QQ")!=null) hql=hql+"and QQ like  concat('%','"+po.get("QQ")+"','%')";
		if(po.get("youxiang")!=null) hql=hql+"and youxiang like  concat('%','"+po.get("youxiang")+"','%')";
		if(po.get("shouji")!=null) hql=hql+"and shouji like  concat('%','"+po.get("shouji")+"','%')";
		if(po.get("neirong")!=null) hql=hql+"and neirong like  concat('%','"+po.get("neirong")+"','%')";
		if(po.get("huifuneirong")!=null) hql=hql+"and huifuneirong like  concat('%','"+po.get("huifuneirong")+"','%')";
		System.out.println(hql);
		List  cout=sessionfactory.getCurrentSession().createQuery(hql).list();
		System.out.println(cout.get(0));
		Number i = (Number)cout.get(0);
		return i.intValue();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Liuyanban> getByPage(Map<String, Object> po) {
		String hql=" from Liuyanban where 1=1";
		if(po.get("cheng")!=null) hql=hql+"and cheng LIKE CONCAT('%','"+po.get("cheng")+"','%')";
		if(po.get("xingbie")!=null) hql=hql+"and xingbie like  concat('%','"+po.get("xingbie")+"','%')";
		if(po.get("QQ")!=null) hql=hql+"and QQ like  concat('%','"+po.get("QQ")+"','%')";
		if(po.get("youxiang")!=null) hql=hql+"and youxiang like  concat('%','"+po.get("youxiang")+"','%')";
		if(po.get("shouji")!=null) hql=hql+"and shouji like  concat('%','"+po.get("shouji")+"','%')";
		if(po.get("neirong")!=null) hql=hql+"and neirong like  concat('%','"+po.get("neirong")+"','%')";
		if(po.get("huifuneirong")!=null) hql=hql+"and huifuneirong like  concat('%','"+po.get("huifuneirong")+"','%')";
		hql=hql+" order by id desc";
		if(po.get("pageno")!=null&&po.get("pangeSize")!=null) hql=hql+"limit"+po.get("pageno")+","+po.get("pageSize");
		return sessionfactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<Liuyanban> select(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
