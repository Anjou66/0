package com.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.YonghuxinxiDao;
import com.entity.Shoucangjilu;
import com.entity.Yonghuxinxi;
import com.entity.Yonghuzhuce;
@Repository
@Transactional(readOnly=true)
public class YonghuxinxiDaoimpl implements YonghuxinxiDao{
	@Autowired  
	private SessionFactory sessionfactory;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		Shoucangjilu s=(Shoucangjilu)sessionfactory.getCurrentSession().get(Shoucangjilu.class,id);
		System.out.println(s+"sdd");
		sessionfactory.getCurrentSession().delete(s);
		return 0;
	}

	@Override
	public int insert(Yonghuxinxi r) {
		System.out.println(r.getAddtime()+" "+r.getChushengriqi()+" "+r.getMima()+" "+r.getShouji()+" "+r.getXingbie()+" "+r.getTouxiang()+" "+r.getYonghucheng()+" "+r.getId());
		sessionfactory.getCurrentSession().save(r);
		return 0;
	}

	@Override
	public int insertSelective(Yonghuxinxi record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Yonghuxinxi selectByPrimaryKey(Integer id) {
		return (Yonghuxinxi) sessionfactory.getCurrentSession().get(Yonghuxinxi.class,id);
	}

	@Override
	public int updateByPrimaryKeySelective(Yonghuxinxi r) {
		String hql="UPDATE Yonghuxinxi SET ";
		if(r.getYonghucheng()!=null) hql=hql+"yonghucheng='"+r.getYonghucheng()+"',";
		if(r.getMima()!=null) hql=hql+"mima='"+r.getMima()+"',";
		if(r.getTouxiang()!=null) hql=hql+"touxiang='"+r.getTouxiang()+"',";
		if(r.getShouji()!=null) hql=hql+"shouji='"+r.getShouji()+"',";
		if(r.getYouxiang()!=null) hql=hql+"youxiang='"+r.getYouxiang()+"',";
		if(r.getChushengriqi()!=null) hql=hql+"chushengriqi='"+r.getChushengriqi()+"',";
		if(r.getXingbie()!=null) hql=hql+"xingbie='"+r.getXingbie()+"'";
		//if(r.getAddtime()!=null) hql=hql+"addtime="+r.getAddtime();
		hql=hql+" where id="+r.getId()+"";
		sessionfactory.getCurrentSession().createQuery(hql);
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Yonghuxinxi record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Yonghuxinxi quchongYonghuxinxi(Map<String, Object> yonghucheng) {
		String hql="from Yonghuxinxi where yonghucheng='"+yonghucheng.get("yonghucheng")+"'";
		return (Yonghuxinxi)sessionfactory.getCurrentSession().createQuery(hql).uniqueResult();
	}

	@Override
	public List<Yonghuxinxi> getAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Yonghuxinxi> getsyyonghuxinxi1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Yonghuxinxi> getsyyonghuxinxi3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Yonghuxinxi> getsyyonghuxinxi2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public int getCount(Map<String, Object> po) {
		String hql="select  count(*) from Yonghuxinxi  where 1=1";
		if(po.get("yonghucheng")!=null) hql=hql+"and yonghucheng like  concat ('%',"+po.get("yonghucheng ")+"','%')";
		if(po.get("mima")!=null) hql=hql+"and mima like  concat ('%',"+po.get("mima")+"','%')";
		if(po.get("touxiang")!=null) hql=hql+"and touxiang like  concat ('%',"+po.get("touxiang")+"','%')";
		if(po.get("shouji")!=null) hql=hql+"and shouji like  concat ('%',"+po.get("shouji")+"','%')";
		if(po.get("youxiang")!=null) hql=hql+"and youxiang like  concat ('%',"+po.get("youxiang")+"','%')";
		if(po.get("chushengriqi1")!=null) hql=hql+"and chushengriqi1 like  concat ('%',"+po.get("chushengriqi1")+"','%')";
		if(po.get("chushengriqi2")!=null) hql=hql+"and chushengriqi2 like  concat ('%',"+po.get("chushengriqi2")+"','%')";
		if(po.get("xingbie")!=null) hql=hql+"and xingbie like  concat ('%',"+po.get("xingbie")+"','%')";
		System.out.println(hql);
		List  cout=sessionfactory.getCurrentSession().createQuery(hql).list();
		System.out.println(cout.get(0));
		Number i = (Number)cout.get(0);
		return i.intValue();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Yonghuxinxi> getByPage(Map<String, Object> po) {
		String hql="from Yonghuxinxi where 1=1";
		if(po.get("yonghucheng")!=null) hql=hql+"and yonghucheng LIKE CONCAT('%','"+po.get("yonghucheng")+"','%')";
		if(po.get("mima")!=null) hql=hql+"and mima like  concat('%','"+po.get("mima")+"','%')";
		if(po.get("touxiang")!=null) hql=hql+"and touxiang like  concat('%','"+po.get("touxiang")+"','%')";
		if(po.get("shouji")!=null) hql=hql+"and shouji like  concat('%','"+po.get("shouji")+"','%')";
		if(po.get("youxiang")!=null) hql=hql+"and youxiang like  concat('%','"+po.get("youxiang")+"','%')";
		if(po.get("chushengriqi1")!=null) hql=hql+"and chushengriqi1 like  concat('%','"+po.get("chushengriqi1")+"','%')";
		if(po.get("chushengriqi2")!=null) hql=hql+"and chushengriqi2 like  concat('%','"+po.get("chushengriqi2")+"','%')";
		if(po.get("xingbie")!=null) hql=hql+"and xingbie like  concat('%','"+po.get("xingbie")+"','%')";
		hql=hql+" order by id desc";
		if(po.get("pageno")!=null&&po.get("pangeSize")!=null) hql=hql+"limit"+po.get("pageno")+","+po.get("pageSize");
		List<Yonghuxinxi> d= sessionfactory.getCurrentSession().createQuery(hql).list();
		//System.out.println(d.get(0));
		return d;
	}

	@Override
	public List<Yonghuxinxi> select(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
