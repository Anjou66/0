package com.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.PinglunDao;
import com.entity.Pinglun;
import com.entity.Shoucangjilu;
@Repository
@Transactional(readOnly=true)
public class PinglunDaoimpl implements PinglunDao{
	@Autowired
	private SessionFactory sessionfactory;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		Pinglun h=(Pinglun)sessionfactory.getCurrentSession().get(Pinglun.class,id );
		sessionfactory.getCurrentSession().delete(h);
		return 0;
	}

	@Override
	public int insert(Pinglun record) {
		sessionfactory.getCurrentSession().save(record);
		return 0;
	}

	@Override
	public int insertSelective(Pinglun record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Pinglun selectByPrimaryKey(Integer id) {
		return (Pinglun)sessionfactory.getCurrentSession().get(Pinglun.class,id);
	}

	@Override
	public int updateByPrimaryKeySelective(Pinglun r) {
		String hql="UPDATE Pinglun SET";
		if(r.getXinwenID()!=null) hql=hql+"xinwenID="+r.getXinwenID()+",";
		if(r.getPinglunneirong()!=null) hql=hql+"pinglunneirong="+r.getPinglunneirong()+",";
		if(r.getPinglunren()!=null) hql=hql+"pinglunren+"+r.getPinglunren()+",";
		if(r.getPingfen()!=null) hql=hql+"pingfen="+r.getPingfen()+",";
		if(r.getBiao()!=null) hql=hql+"biao="+r.getBiao()+",";
		if(r.getAddtime()!=null) hql=hql+"addtime="+r.getAddtime()+",";
		if(r.getAddtime()!=null) hql=hql+"addtime="+r.getAddtime();
		hql=hql+"where id="+r.getId()+";";
		sessionfactory.getCurrentSession().createQuery(hql);
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Pinglun record) {
		sessionfactory.getCurrentSession().update(record);
		return 0;
	}

	@Override
	public Pinglun quchongPinglun(Map<String, Object> uname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pinglun> getAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public int getCount(Map<String, Object> po) {
		String hql="select  count(*) from Pinglun  where 1=1";
		if(po.get("xinwenID")!=null) hql=hql+"and xinwenID like  concat ('%','"+po.get("xinwenID")+"','%')";
		if(po.get("pinglunneirong")!=null) hql=hql+"and pinglunneirong like  concat ('%','"+po.get("pinglunneirong")+"','%')";
		if(po.get("pinglunren")!=null) hql=hql+"and pinglunren like  concat ('%','"+po.get("pinglunren")+"','%')";
		if(po.get("pingfen")!=null) hql=hql+"and pingfen like  concat ('%','"+po.get("pingfen")+"','%')";
		if(po.get("biao")!=null) hql=hql+"and biao like  concat ('%','"+po.get("biao")+"','%')";
		System.out.println(hql);
		List  cout=sessionfactory.getCurrentSession().createQuery(hql).list();
		System.out.println(cout.get(0));
		Number i = (Number)cout.get(0);
		return i.intValue();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Pinglun> getByPage(Map<String, Object> po) {
		String hql=" from Pinglun where 1=1";
		if(po.get("xinwenID")!=null) hql=hql+"and xinwenID LIKE CONCAT('%','"+po.get("xinwenID")+"','%')";
		if(po.get("pinglunneirong")!=null) hql=hql+"and pinglunneirong like  concat('%','"+po.get("pinglunneirong")+"','%')";
		if(po.get("pinglunren")!=null) hql=hql+"and pinglunren like  concat('%','"+po.get("pinglunren")+"','%')";
		if(po.get("pingfen")!=null) hql=hql+"and pingfen like  concat('%','"+po.get("pingfen")+"','%')";
		if(po.get("biao")!=null) hql=hql+"and biao like  concat('%','"+po.get("biao")+"','%')";
		hql=hql+" order by id desc";
		if(po.get("pageno")!=null&&po.get("pangeSize")!=null) hql=hql+"limit"+po.get("pageno")+","+po.get("pageSize");
		List<Pinglun> d= sessionfactory.getCurrentSession().createQuery(hql).list();
		System.out.println(d.get(0));
		return d;
	}

	@Override
	public List<Pinglun> select(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
