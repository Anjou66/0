package com.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ShoucangjiluDao;
import com.entity.Shoucangjilu;
import com.entity.Wodehuati;
@Repository
@Transactional(readOnly=true)
public class ShoucangjiluDaoimpl implements ShoucangjiluDao{
	@Autowired  
	private SessionFactory sessionfactory;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		Shoucangjilu s=(Shoucangjilu)sessionfactory.getCurrentSession().get(Shoucangjilu.class,id);
		sessionfactory.getCurrentSession().delete(s);
		return 0;
	}

	@Override
	public int insert(Shoucangjilu record) {
		sessionfactory.getCurrentSession().save(record);
		return 0;
	}

	@Override
	public int insertSelective(Shoucangjilu record) {
		
		return 0;
	}

	@Override
	public Shoucangjilu selectByPrimaryKey(Integer id) {
		return (Shoucangjilu)sessionfactory.getCurrentSession().get(Shoucangjilu.class, id);
	}

	@Override
	public int updateByPrimaryKeySelective(Shoucangjilu r) {
		String hql="UPDATE Shoucangjilu SET";
		if(r.getUsername()!=null) hql=hql+"username="+r.getUsername()+",";
		if(r.getXwid()!=null) hql=hql+"xwid="+r.getXwid()+",";
		if(r.getZiduan()!=null) hql=hql+"ziduan="+r.getZiduan()+",";
		if(r.getBiao()!=null) hql=hql+"biao="+r.getBiao()+",";
		if(r.getBiaoj()!=null) hql=hql+"biaoj="+r.getBiaoj()+",";
		if(r.getAddtime()!=null) hql=hql+"addtime="+r.getAddtime();
		hql=hql+"where id="+r.getId()+";";
		sessionfactory.getCurrentSession().createQuery(hql);
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Shoucangjilu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Shoucangjilu quchongShoucangjilu(Map<String, Object> uname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shoucangjilu> getAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public int getCount(Map<String, Object> po) {
		String hql="select  count(*) from Shoucangjilu  where 1=1";
		if(po.get("username")!=null) hql=hql+"and username like  concat ('%','"+po.get("username")+"','%')";
		if(po.get("xwid")!=null) hql=hql+"and xwid like  concat ('%','"+po.get("xwid")+"','%')";
		if(po.get("ziduan")!=null) hql=hql+"and ziduan like  concat ('%','"+po.get("ziduan")+"','%')";
		if(po.get("biao")!=null) hql=hql+"and biao like  concat ('%','"+po.get("biao")+"','%')";
		System.out.println(hql);
		List  cout=sessionfactory.getCurrentSession().createQuery(hql).list();
		System.out.println(cout.get(0));
		Number i = (Number)cout.get(0);
		return i.intValue();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Shoucangjilu> getByPage(Map<String, Object> po) {
		String hql=" from Shoucangjilu where 1=1";
		if(po.get("username")!=null) hql=hql+"and xinwenID LIKE CONCAT('%','"+po.get("xinwenID")+"','%')";
		if(po.get("xwid")!=null) hql=hql+"and pinglunneirong like  concat('%','"+po.get("pinglunneirong")+"','%')";
		if(po.get("ziduan")!=null) hql=hql+"and pinglunren like  concat('%','"+po.get("pinglunren")+"','%')";
		if(po.get("biao")!=null) hql=hql+"and biao like  concat('%','"+po.get("biao")+"','%')";
		hql=hql+" order by id desc";
		if(po.get("pageno")!=null&&po.get("pangeSize")!=null) hql=hql+"limit"+po.get("pageno")+","+po.get("pageSize");
		List<Shoucangjilu> d= sessionfactory.getCurrentSession().createQuery(hql).list();
		System.out.println(d.get(0));
		return d;
	}

	@Override
	public List<Shoucangjilu> select(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
