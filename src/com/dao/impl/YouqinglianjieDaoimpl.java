package com.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.YouqinglianjieDao;
import com.entity.Shoucangjilu;
import com.entity.Xinwentongzhi;
import com.entity.Youqinglianjie;
@Repository
@Transactional(readOnly=true)
public class YouqinglianjieDaoimpl implements YouqinglianjieDao{
	@Autowired  
	private SessionFactory sessionfactory;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		Youqinglianjie s=(Youqinglianjie)sessionfactory.getCurrentSession().get(Youqinglianjie.class,id);
		sessionfactory.getCurrentSession().delete(s);
		return 0;
	}

	@Override
	public int insert(Youqinglianjie record) {
		sessionfactory.getCurrentSession().save(record);
		return 0;
	}

	@Override
	public int insertSelective(Youqinglianjie record) {
		return 0;
	}

	@Override
	public Youqinglianjie selectByPrimaryKey(Integer id) {
		return (Youqinglianjie)sessionfactory.getCurrentSession().get(Youqinglianjie.class,id);
	}

	@Override
	public int updateByPrimaryKeySelective(Youqinglianjie r) {
		String hql="UPDATE Youqinglianjie SET";
		if(r.getWangzhanmingcheng()!=null) hql=hql+"Wangzhanmingcheng="+r.getWangzhanmingcheng()+",";
		if(r.getWangzhi()!=null) hql=hql+"Wangzhi="+r.getWangzhi()+",";
		if(r.getLOGO()!=null) hql=hql+"LOGO="+r.getLOGO()+",";
		
		if(r.getAddtime()!=null) hql=hql+"addtime="+r.getAddtime();
		hql=hql+"where id="+r.getId()+";";
		sessionfactory.getCurrentSession().createQuery(hql);
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Youqinglianjie record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Youqinglianjie quchongYouqinglianjie(Map<String, Object> wangzhanmingcheng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Youqinglianjie> getAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Youqinglianjie> getsyyouqinglianjie1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Youqinglianjie> getsyyouqinglianjie3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Youqinglianjie> getsyyouqinglianjie2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public int getCount(Map<String, Object> po) {
		String hql="select  count(*) from Youqinglianjie  where 1=1";
		if(po.get("wangzhanmingcheng!=null")!=null) hql=hql+"and wangzhanmingcheng like  concat ('%','"+po.get("wangzhanmingcheng ")+"','%')";
		if(po.get("wangzhi")!=null) hql=hql+"and wangzhi like  concat ('%','"+po.get("wangzhi")+"','%')";
		if(po.get("LOGO")!=null) hql=hql+"and LOGO like  concat ('%','"+po.get("LOGO")+"','%')";
		System.out.println(hql);
		List  cout=sessionfactory.getCurrentSession().createQuery(hql).list();
		System.out.println(cout.get(0));
		Number i = (Number)cout.get(0);
		return i.intValue();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Youqinglianjie> getByPage(Map<String, Object> po) {
		String hql="from Youqinglianjie where 1=1";
		if(po.get("wangzhanmingcheng")!=null) hql=hql+"and wangzhanmingcheng LIKE CONCAT('%','"+po.get("wangzhanmingcheng")+"','%')";
		if(po.get("wangzhi")!=null) hql=hql+"and wangzhi like  concat('%','"+po.get("wangzhi")+"','%')";
		if(po.get("LOGO")!=null) hql=hql+"and LOGO like  concat('%','"+po.get("LOGO")+"','%')";
		hql=hql+" order by id desc";
		if(po.get("pageno")!=null&&po.get("pangeSize")!=null) hql=hql+"limit"+po.get("pageno")+","+po.get("pageSize");
		List<Youqinglianjie> d= sessionfactory.getCurrentSession().createQuery(hql).list();
		System.out.println(d.get(0));
		return d;
	}

	@Override
	public List<Youqinglianjie> select(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
