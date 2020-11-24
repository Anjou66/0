package com.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.YonghuzhuceDao;
import com.entity.Shoucangjilu;
import com.entity.Yonghuxinxi;
import com.entity.Yonghuzhuce;
import com.entity.Youqinglianjie;
@Repository
@Transactional(readOnly=true)
public class YonghuzhuceDaoimpl implements YonghuzhuceDao {
	@Autowired  
	private SessionFactory sessionfactory;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		Shoucangjilu s=(Shoucangjilu)sessionfactory.getCurrentSession().get(Shoucangjilu.class,id);
		sessionfactory.getCurrentSession().delete(s);
		return 0;
	}

	@Override
	public int insert(Yonghuzhuce r) {
		
		sessionfactory.getCurrentSession().save(r);
		return 0;
	}

	@Override
	public int insertSelective(Yonghuzhuce record) {
		// 
		return 0;
	}

	@Override
	public Yonghuzhuce selectByPrimaryKey(Integer id) {
		return (Yonghuzhuce)sessionfactory.getCurrentSession().get(Yonghuzhuce.class, id);
	}

	@Override
	public int updateByPrimaryKeySelective(Yonghuzhuce r) {
		String hql="UPDATE Yonghuzhuce SET";
		if(r.getYonghuming()!=null) hql=hql+"yonghuming="+r.getYonghuming()+",";
		if(r.getMima()!=null) hql=hql+"mima="+r.getMima()+",";
		if(r.getXingming()!=null) hql=hql+"Xingming="+r.getXingming()+",";
		if(r.getXingbie()!=null) hql=hql+"xingbie="+r.getXingbie()+",";
		if(r.getChushengnianyue()!=null) hql=hql+"chushengnianyue="+r.getChushengnianyue()+",";
		if(r.getQQ()!=null) hql=hql+"QQ="+r.getQQ()+",";
		if(r.getYouxiang()!=null) hql=hql+"youxiang="+r.getYouxiang()+",";
		if(r.getShouji()!=null) hql=hql+"shouji="+r.getShouji()+",";
		if(r.getShenfenzheng()!=null) hql=hql+"Shenfenzheng="+r.getShenfenzheng()+",";
		if(r.getTouxiang()!=null) hql=hql+"touxiang="+r.getTouxiang()+",";
		if(r.getDizhi()!=null) hql=hql+"dizhi="+r.getDizhi()+",";
		if(r.getBeizhu()!=null) hql=hql+"beizhu="+r.getBeizhu()+",";
		if(r.getAddtime()!=null) hql=hql+"addtime="+r.getAddtime();
		hql=hql+"where id="+r.getId()+";";
		sessionfactory.getCurrentSession().createQuery(hql);
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Yonghuzhuce record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Yonghuzhuce quchongYonghuzhuce(Map<String, Object> yonghuming) {
		String hql="select *from Yonghuzhuce where yonghucheng='"+yonghuming.get("yonghuming")+"'limit 0,1";
		return (Yonghuzhuce)sessionfactory.getCurrentSession().createQuery(hql);
	}

	@Override
	public List<Yonghuzhuce> getAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Yonghuzhuce> getsyyonghuzhuce1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Yonghuzhuce> getsyyonghuzhuce3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Yonghuzhuce> getsyyonghuzhuce2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public int getCount(Map<String, Object> po) {
		String hql="select  count(*) from Yonghuzhuce  where 1=1";
		if(po.get("yonghuming")!=null) hql=hql+"and yonghuming like  concat ('%',"+po.get("yonghuming ")+"'%')";
		if(po.get("mima")!=null) hql=hql+"and mima like  concat ('%',"+po.get("mima")+"'%')";
		if(po.get("xingming")!=null) hql=hql+"and xingming like  concat ('%',"+po.get("xingming")+"'%')";
		if(po.get("xingbie")!=null) hql=hql+"and xingbie like  concat ('%',"+po.get("xingbie")+"'%')";
		if(po.get("chushengnianyue1")!=null) hql=hql+"and chushengnianyue1 like  concat ('%',"+po.get("chushengnianyue1")+"'%')";
		if(po.get("chushengnianyue2")!=null) hql=hql+"and chushengnianyue2 like  concat ('%',"+po.get("chushengnianyue2")+"'%')";
		if(po.get("QQ")!=null) hql=hql+"and QQ like  concat ('%',"+po.get("QQ")+"'%')";
		if(po.get("youxiang")!=null) hql=hql+"and youxiang like  concat ('%',"+po.get("youxiang")+"'%')";
		if(po.get("shouji")!=null) hql=hql+"and shouji like  concat ('%',"+po.get("shouji")+"'%')";
		if(po.get("shenfenzheng")!=null) hql=hql+"and shenfenzheng like  concat ('%',"+po.get("shenfenzheng")+"'%')";
		if(po.get("touxiang")!=null) hql=hql+"and touxiang like  concat ('%',"+po.get("touxiang")+"'%')";
		if(po.get("dizhi")!=null) hql=hql+"and dizhi like  concat ('%',"+po.get("dizhi")+"'%')";
		if(po.get("beizhu")!=null) hql=hql+"and beizhu like  concat ('%',"+po.get("beizhu")+"'%')";
		System.out.println(hql);
		List  cout=sessionfactory.getCurrentSession().createQuery(hql).list();
		System.out.println(cout.get(0));
		Number i = (Number)cout.get(0);
		return i.intValue();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Yonghuzhuce> getByPage(Map<String, Object> po) {
		String hql=" from Yonghuzhuce where 1=1";
		if(po.get("yonghuming")!=null) hql=hql+"and yonghuming LIKE CONCAT('%','"+po.get("yonghuming")+"','%')";
		if(po.get("mima")!=null) hql=hql+"and mima like  concat('%','"+po.get("mima")+"','%')";
		if(po.get("xingming")!=null) hql=hql+"and xingming like  concat('%','"+po.get("xingming")+"','%')";
		if(po.get("xingbie")!=null) hql=hql+"and xingbie like  concat('%','"+po.get("xingbie")+"','%')";
		if(po.get("chushengnianyue1")!=null) hql=hql+"and chushengnianyue1 like  concat('%','"+po.get("chushengnianyue1")+"','%')";
		if(po.get("chushengnianyue2")!=null) hql=hql+"and chushengnianyue2 like  concat('%','"+po.get("chushengnianyue2")+"','%')";
		if(po.get("QQ")!=null) hql=hql+"and QQ like  concat('%','"+po.get("QQ")+"','%')";
		if(po.get("youxiang")!=null) hql=hql+"and youxiang like  concat('%','"+po.get("youxiang")+"','%')";
		if(po.get("shouji")!=null) hql=hql+"and shouji like  concat('%','"+po.get("shouji")+"','%')";
		if(po.get("shenfenzheng")!=null) hql=hql+"and shenfenzheng like  concat('%','"+po.get("shenfenzheng")+"','%')";
		if(po.get("touxiang")!=null) hql=hql+"and touxiang like  concat('%','"+po.get("touxiang")+"','%')";
		if(po.get("dizhi")!=null) hql=hql+"and dizhi like  concat('%','"+po.get("dizhi")+"','%')";
		if(po.get("beizhu")!=null) hql=hql+"and beizhu like  concat('%','"+po.get("beizhu")+"','%')";
		hql=hql+" order by id desc";
		if(po.get("pageno")!=null&&po.get("pangeSize")!=null) hql=hql+"limit"+po.get("pageno")+","+po.get("pageSize");
		List<Yonghuzhuce> d= sessionfactory.getCurrentSession().createQuery(hql).list();
		System.out.println(d.get(0));
		return d;
	}

	@Override
	public List<Yonghuzhuce> select(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
