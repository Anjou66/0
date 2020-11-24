package com.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DiaochaxinxiDao;
import com.entity.Allusers;
import com.entity.Diaochaxinxi;
import com.entity.Diaochaxuanxiang;
@Repository
@Transactional(readOnly=true)
public class DiaochaxinxiDaoimpl implements DiaochaxinxiDao{
		@Autowired
		private SessionFactory sessionfactory;
	
		@Override
		public int deleteByPrimaryKey(Integer id) {
			Diaochaxinxi d=(Diaochaxinxi)sessionfactory.getCurrentSession().get(Diaochaxinxi.class, id);
			sessionfactory.getCurrentSession().delete(d);
			return 0;
		}
		
		@Override
		public int insert(Diaochaxinxi record) {
			sessionfactory.getCurrentSession().save(record);
			return 0;
		}
		@Override
		public int insertSelective(Diaochaxinxi r) {
		
			String hql="INSERT INTO Diaochaxinxi SET";
			if(r.getId()!=null) hql=hql+"id="+r.getId()+",";
			if(r.getDiaochabianhao()!=null) hql=hql+"diaochabianhao="+r.getDiaochabianhao()+",";
			if(r.getHuatimingcheng()!=null) hql=hql+"huatimingcheng="+r.getHuatimingcheng()+",";
			if(r.getDiaochamingcheng()!=null) hql=hql+"diaochamingcheng+"+r.getDiaochamingcheng()+",";
			if(r.getCanyurenshu()!=null) hql=hql+"canyurenshu="+r.getCanyurenshu()+",";
			if(r.getDiaochazhi()!=null) hql=hql+"diaochazhi="+r.getDiaochabianhao()+",";
			if(r.getZongzhi()!=null) hql=hql+"zongzhi="+r.getZongzhi()+",";
			if(r.getGongsibianhao()!=null) hql=hql+"gongsibianhao="+r.getGongsibianhao()+",";
			if(r.getAddtime()!=null) hql=hql+"addtime="+r.getAddtime()+";";
			sessionfactory.getCurrentSession().createQuery(hql);
			return 0;
		}
		
		@Override
		public Diaochaxinxi selectByPrimaryKey(Integer id) {
			return (Diaochaxinxi)sessionfactory.getCurrentSession().get(Diaochaxinxi.class,id);
		}
		
		@Override
		public int updateByPrimaryKeySelective(Diaochaxinxi r) {
			String hql="UPDATE Diaochaxinxi SET";
			if(r.getDiaochabianhao()!=null) hql=hql+"diaochabianhao="+r.getDiaochabianhao()+",";
			if(r.getHuatimingcheng()!=null) hql=hql+"huatimingcheng="+r.getHuatimingcheng()+",";
			if(r.getDiaochamingcheng()!=null) hql=hql+"diaochamingcheng+"+r.getDiaochamingcheng()+",";
			if(r.getCanyurenshu()!=null) hql=hql+"canyurenshu="+r.getCanyurenshu()+",";
			if(r.getDiaochazhi()!=null) hql=hql+"diaochazhi="+r.getDiaochabianhao()+",";
			if(r.getZongzhi()!=null) hql=hql+"zongzhi="+r.getZongzhi()+",";
			if(r.getGongsibianhao()!=null) hql=hql+"gongsibianhao="+r.getGongsibianhao()+",";
			if(r.getAddtime()!=null) hql=hql+"addtime="+r.getAddtime();
			hql=hql+"where id="+r.getId()+";";
			return 0;
		}
		
		@Override
		public int updateByPrimaryKey(Diaochaxinxi record) {
			sessionfactory.getCurrentSession().update(record);
			return 0;
		}
		
		@Override
		public Diaochaxinxi quchongDiaochaxinxi(Map<String, Object> gongsibianhao) {
			String hql=" from Diaochaxinxi where diaochabianhao='"+(String)gongsibianhao.get("diaochabianhao")+"'";
			Diaochaxinxi s=(Diaochaxinxi)sessionfactory.getCurrentSession().createQuery(hql).uniqueResult();
			System.out.println(hql);
			return s;
		}
		
		@Override
		public List<Diaochaxinxi> getAll(Map<String, Object> map) {
			return null;
		}
		
		@Override
		public List<Diaochaxinxi> getsydiaochaxinxi1(Map<String, Object> map) {
			return null;
		}
		
		@Override
		public List<Diaochaxinxi> getsydiaochaxinxi3(Map<String, Object> map) {
			return null;
		}
		
		@Override
		public List<Diaochaxinxi> getsydiaochaxinxi2(Map<String, Object> map) {
			return null;
		}
//		return sessionfactory.getCurrentSession().createQuery("SELECT * FROM Allusers where 1=1 AND username LIKE CONCAT('%',:username,'%')\r\n" + 
//				"and pwd  LIKE CONCAT('%',:pwd,'%') and  cx LIKE CONCAT('%',:cx,'%') LIMIT :pageno,:paheSize").setParameter("username",map.get("username")).setParameter("pwd",map.get("pwd")).setParameter("cx",map.get("cx")).setParameter("pageno",map.get("pageno")).setParameter("pageSize",map.get("pageSize")).list();
//		
		@Override
		@Transactional(readOnly=true)
		public int getCount(Map<String, Object> po) {
			String hql="select  count(*) from Diaochaxinxi where 1=1";
			if(po.get("diaochabianhao")!=null) hql=hql+"and diaochabianhao LIKE CONCAT('%','"+po.get("diaochabianhao")+"','%')";
			if(po.get("huatimingcheng")!=null) hql=hql+"and huatimingcheng like  concat('%','"+po.get("huatimingcheng")+"','%')";
			if(po.get("diaochamingcheng")!=null) hql=hql+"and diaochamingcheng like  concat('%','"+po.get("diaochamingcheng")+"','%')";
			if(po.get("canyurenshu")!=null) hql=hql+"and canyurenshu like  concat('%','"+po.get("canyurenshu")+"','%')";
			if(po.get("diaochazhi")!=null) hql=hql+"and diaochazhi like  concat('%','"+po.get("diaochazhi")+"','%')";
			if(po.get("zongzhi")!=null) hql=hql+"and zongzhi like  concat('%','"+po.get("zongzhi")+"','%')";
			if(po.get("gongsibianhao")!=null) hql=hql+"and gongsibianhao like  concat('%','"+po.get("gongsibianhao")+"','%')";
			System.out.println(hql);
			List  cout=sessionfactory.getCurrentSession().createQuery(hql).list();
			System.out.println(cout.get(0));
			Number i = (Number)cout.get(0);
			return i.intValue();
			
		}
		@Override
		public List<Diaochaxinxi> getByPage(Map<String, Object> po) {
			String hql=" from Diaochaxinxi where 1=1";
			if(po.get("diaochabianhao")!=null) hql=hql+"and diaochabianhao LIKE CONCAT('%','"+po.get("diaochabianhao")+"','%')";
			if(po.get("huatimingcheng")!=null) hql=hql+"and huatimingcheng like  concat('%','"+po.get("huatimingcheng")+"','%')";
			if(po.get("diaochamingcheng")!=null) hql=hql+"and diaochamingcheng like  concat('%','"+po.get("diaochamingcheng")+"','%')";
			if(po.get("canyurenshu")!=null) hql=hql+"and canyurenshu like  concat('%','"+po.get("canyurenshu")+"','%')";
			if(po.get("diaochazhi")!=null) hql=hql+"and diaochazhi like  concat('%','"+po.get("diaochazhi")+"','%')";
			if(po.get("zongzhi")!=null) hql=hql+"and zongzhi like  concat('%','"+po.get("zongzhi")+"','%')";
			if(po.get("gongsibianhao")!=null) hql=hql+"and gongsibianhao like  concat('%','"+po.get("gongsibianhao")+"','%')";
			hql=hql+" order by id desc";
			if(po.get("pageno")!=null&&po.get("pangeSize")!=null) hql=hql+"limit"+po.get("pageno")+","+po.get("pageSize");
			List<Diaochaxinxi> d= sessionfactory.getCurrentSession().createQuery(hql).list();
			return d;
			
		}
		
		@Override
		public List<Diaochaxinxi> select(Map<String, Object> map) {
			return null;
		}
}