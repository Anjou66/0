package com.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AllusersDao;
import com.entity.Allusers;
import com.entity.Diaochaxinxi;
@Repository
@Transactional(readOnly=true)
public class AllusersDaoimpl implements AllusersDao{
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		Allusers user=sessionfactory.getCurrentSession().load(Allusers.class,id);
		System.out.println(user.getId()+"sdsfg");
		sessionfactory.getCurrentSession().delete(user);
		return 0;
	}

	@Override
	public int insert(Allusers record) {
		sessionfactory.getCurrentSession().save(record);
		return 0;
	}

	@Override
	public int insertSelective(Allusers record) {
		sessionfactory.getCurrentSession().save(record);
		return 0;
	}

	@Override
	@Transactional(readOnly=true)
	public Allusers selectByPrimaryKey(Integer id) {
		return (Allusers)sessionfactory.getCurrentSession().get(Allusers.class,id);
	}

	@Override
	public int updateByPrimaryKeySelective(Allusers record) {
		sessionfactory.getCurrentSession().update(record);
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Allusers record) {
		sessionfactory.getCurrentSession().update(record);
		return 0;
	}

	@Override
	public Allusers quchongAllusers(Map<String, Object> uname) {
		String hql=" from Allusers where username='"+(String)uname.get("username")+"'";
		Allusers s=(Allusers)sessionfactory.getCurrentSession().createQuery(hql).uniqueResult();
		System.out.println(hql);
		return s;
	}

	@Override
	public List<Allusers> getAll(Map<String, Object> map) {
//		q=from allusers where username=;
//		foreach(v:Object){
//			if(v.key==username && v.val!=null) q=q+"username";
//		}
		//	return sessionfactory.getCurrentSession().createQuery(q).setParameter("username",map.get()).list();
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public int getCount(Map<String, Object> po) {
		String hql="select  count(*) from Allusers where 1=1";
		if(po.get("username")!=null) hql=hql+" and usrname LIKE CONCAT('%','"+po.get("username")+"','%')";
		System.out.println(hql);
		List  cout=sessionfactory.getCurrentSession().createQuery(hql).list();
		System.out.println(cout.get(0));
		Number i = (Number)cout.get(0);
		return i.intValue();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Allusers> getByPage(Map<String, Object> po) {
		String hql=" from Allusers where 1=1";
		if(po.get("username")!=null) hql=hql+"and diaochabianhao LIKE CONCAT('%','"+po.get("diaochabianhao")+"','%')";
		if(po.get("pwd")!=null) hql=hql+"and huatimingcheng like  concat('%','"+po.get("huatimingcheng")+"','%')";
		if(po.get("cx")!=null) hql=hql+"and diaochamingcheng like  concat('%','"+po.get("diaochamingcheng")+"','%')";
		if(po.get("pageno")!=null&&po.get("pangeSize")!=null) hql=hql+"limit"+po.get("pageno")+","+po.get("pageSize");
		List<Allusers> d= sessionfactory.getCurrentSession().createQuery(hql).list();
		System.out.println(d.get(0));
		return d;
		
	}

	@Override
	public List<Allusers> select(Map<String, Object> map) {
		return null;
	}

	@Override
	public Allusers allusersLogin(Map<String, Object> po) {
		return (Allusers)sessionfactory.getCurrentSession().createQuery("from Allusers where username=:username and pwd=:pwd").setParameter("username",po.get("username")).setParameter("pwd",po.get("pwd"));
	}
    

}
