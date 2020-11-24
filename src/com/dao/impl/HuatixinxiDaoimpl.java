package com.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.HuatixinxiDao;
import com.entity.Huatixinxi;
import com.entity.Pinglun;
@Repository
@Transactional(readOnly=true)
public class HuatixinxiDaoimpl implements HuatixinxiDao  {
	@Autowired
	private SessionFactory sessionfactory;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		Huatixinxi hu=(Huatixinxi)sessionfactory.getCurrentSession().get(Huatixinxi.class,id);
		sessionfactory.getCurrentSession().delete(hu);
		return 0;
	}

	@Override
	public int insert(Huatixinxi record) {
		sessionfactory.getCurrentSession().save(record);
		return 0;
	}

	@Override
	public int insertSelective(Huatixinxi record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Huatixinxi selectByPrimaryKey(Integer id) {
		return (Huatixinxi)sessionfactory.getCurrentSession().get(Huatixinxi.class,id);
		
	}

	@Override
	public int updateByPrimaryKeySelective(Huatixinxi r) {
		String hql="update Huatixinxi";
		if(r.getHuatimingcheng()!=null) hql=hql+"set huatimingcheng='"+r.getHuatimingcheng()+"',";
		if(r.getAddtime()!=null) hql=hql+"set addtime='"+r.getAddtime()+"'";
		hql=hql+"where id="+r.getId();
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Huatixinxi record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Huatixinxi quchongHuatixinxi(Map<String, Object> hua) {
		String hql="from Huatixinxi where huatimingcheng='"+hua.get("huatimingcheng")+"'";
		return	(Huatixinxi)sessionfactory.getCurrentSession().createQuery(hql).uniqueResult();

	}

	@Override
	public List<Huatixinxi> getAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Huatixinxi> getsyhuatixinxi1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Huatixinxi> getsyhuatixinxi3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Huatixinxi> getsyhuatixinxi2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public int getCount(Map<String, Object> po) {
		String hql="select  count(*) from Huatixinxi  where 1=1";
		if(po.get("huatimingcheng")!=null) hql=hql+"and huatimingcheng like  concat ('%','"+po.get("huatimingcheng")+"','%')";
		System.out.println(hql);
		List  cout=sessionfactory.getCurrentSession().createQuery(hql).list();
		System.out.println(cout.get(0));
		Number i = (Number)cout.get(0);
		return i.intValue();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Huatixinxi> getByPage(Map<String, Object> p) {
		String hql=" from Huatixinxi where 1=1";
		if(p.get("huatimingcheng")!=null) hql=hql+"and huatimingcheng like  concat ('%','"+p.get("huatimingcheng")+"','%')";
		hql=hql+" order by id desc";
		if(p.get("pageno")!=null&&p.get("pangeSize")!=null) hql=hql+"limit"+p.get("pageno")+","+p.get("pageSize");
		List<Huatixinxi> d= sessionfactory.getCurrentSession().createQuery(hql).list();
		System.out.println(d.get(0));
		return d;
	}

	@Override
	public List<Huatixinxi> select(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
