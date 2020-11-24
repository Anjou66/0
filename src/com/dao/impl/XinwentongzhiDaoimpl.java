package com.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.XinwentongzhiDao;
import com.entity.Shoucangjilu;
import com.entity.Xinwentongzhi;
@Repository
@Transactional(readOnly=true)
public class XinwentongzhiDaoimpl implements XinwentongzhiDao{
	@Autowired  
	private SessionFactory sessionfactory;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		Xinwentongzhi s=(Xinwentongzhi)sessionfactory.getCurrentSession().get(Xinwentongzhi.class,id);
		sessionfactory.getCurrentSession().delete(s);
		return 0;
	}

	@Override
	public int insert(Xinwentongzhi record) {
		sessionfactory.getCurrentSession().save(record);
		return 0;
	}

	@Override
	public int insertSelective(Xinwentongzhi record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional(readOnly=true)
	public Xinwentongzhi selectByPrimaryKey(Integer id) {
		return (Xinwentongzhi)sessionfactory.getCurrentSession().get(Xinwentongzhi.class, id);
	}

	@Override
	public int updateByPrimaryKeySelective(Xinwentongzhi r) {
		String hql="UPDATE Xinwentongzhi SET";
		if(r.getBiaoti()!=null) hql=hql+"biaoti="+r.getBiaoti()+",";
		if(r.getLeibie()!=null) hql=hql+"leibie="+r.getLeibie()+",";
		if(r.getNeirong()!=null) hql=hql+"neirong="+r.getNeirong()+",";
		if(r.getShouyetupian()!=null) hql=hql+"shouyetupian="+r.getShouyetupian()+",";
		if(r.getDianjilv()!=null) hql=hql+"dianjilv="+r.getDianjilv()+",";
		if(r.getTianjiaren()!=null) hql=hql+"tianjiaren="+r.getTianjiaren()+",";
		if(r.getAddtime()!=null) hql=hql+"addtime="+r.getAddtime();
		hql=hql+"where id="+r.getId()+";";
		sessionfactory.getCurrentSession().createQuery(hql);
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Xinwentongzhi record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Xinwentongzhi quchongXinwentongzhi(Map<String, Object> uname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Xinwentongzhi> getAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Xinwentongzhi> getsyxinwentongzhi1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Xinwentongzhi> getsyxinwentongzhi2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Xinwentongzhi> getsyxinwentongzhi3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public int getCount(Map<String, Object> po) {
		String hql="select  count(*) from Xinwentongzhi  where 1=1 ";
		if(po.get("biaoti")!=null) hql=hql+"and biaoti like  concat ('%','"+po.get("biaoti")+"','%')";
		if(po.get("leibie")!=null) hql=hql+"and leibie like  concat ('%','"+po.get("leibie")+"','%')";
		if(po.get("lb")!=null) hql=hql+"and leibie like  concat ('%','"+po.get("lb")+"','%')";
		if(po.get("neirong")!=null) hql=hql+"and neirong like  concat ('%','"+po.get("neirong")+"','%')";
		if(po.get("shouyetupian")!=null) hql=hql+"and shouyetupian like  concat ('%','"+po.get("shouyetupian")+"','%')";
		if(po.get("dianjilv")!=null) hql=hql+"and dianjilv like  concat ('%','"+po.get("dianjilv")+"','%')";
		if(po.get("tianjiaren")!=null) hql=hql+"and tianjiaren like  concat ('%','"+po.get("tianjiaren")+"','%')";
		System.out.println(hql);
		List  cout=sessionfactory.getCurrentSession().createQuery(hql).list();
		Number i = (Number)cout.get(0);
		return i.intValue();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Xinwentongzhi> getByPage(Map<String, Object> po) {
		String hql="from Xinwentongzhi where 1=1";
		if(po.get("biaoti")!=null) hql=hql+" and biaoti LIKE CONCAT('%','"+po.get("biaoti")+"','%')";
		if(po.get("leibie")!=null) hql=hql+" and leibie like  concat('%','"+po.get("leibie")+"','%')";
		if(po.get("lb")!=null) hql=hql+" and leibie like  concat('%','"+po.get("lb")+"','%')";
		if(po.get("neirong")!=null) hql=hql+" and neirong like  concat('%','"+po.get("neirong")+"','%')";
		if(po.get("shouyetupian")!=null) hql=hql+" and shouyetupian like  concat('%','"+po.get("shouyetupian")+"','%')";
		if(po.get("dianjilv")!=null) hql=hql+" and dianjilv like  concat('%','"+po.get("dianjilv")+"','%')";
		if(po.get("tianjiaren")!=null) hql=hql+" and tianjiaren like  concat('%','"+po.get("tianjiaren")+"','%')";
		hql=hql+" order by id desc";
		if(po.get("pageno")!=null&&po.get("pangeSize")!=null) hql=hql+"limit"+po.get("pageno")+","+po.get("pageSize");
		System.out.println(hql);
		List<Xinwentongzhi> d= sessionfactory.getCurrentSession().createQuery(hql).list();
		System.out.println(d.get(0));
		return d;
	}

	@Override
	public List<Xinwentongzhi> select(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
