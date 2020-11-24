package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Diaochaxinxi;
import com.service.*;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class DiaochaxinxiController {
	@Resource
	private DiaochaxinxiServer diaochaxinxiService;


   
	@RequestMapping("addDiaochaxinxi.do")
	public String addDiaochaxinxi(HttpServletRequest request,Diaochaxinxi diaochaxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		diaochaxinxi.setAddtime(time.toString().substring(0, 19));
		diaochaxinxiService.add(diaochaxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "diaochaxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:diaochaxinxiList.do";
		
		
		
	}
	
	@RequestMapping("insertDiaochaxinxiDetail.do")
	public void insertDiaochaxinxiDetail(HttpServletRequest request,HttpSession session,HttpServletResponse response) throws SQLException{
		
		
		int row=Integer.parseInt(request.getParameter("row"));
		
		String diaochabianhao=request.getParameter("diaochabianhao"); 
		
		int qidaizhi=0;
		
		for(int a=1;a<=row;a++){
			qidaizhi+=Integer.parseInt(request.getParameter("data"+a));
		}
		
		System.out.println("row"+row);
		
		//获取原始信息
		
		 String sql="select * from diaochaxinxi where diaochabianhao='"+diaochabianhao+"'";
		 db d=new db();
		 ResultSet rs=d.executeQuery(sql);
		 rs.next();
		 int canyurenshu=Integer.parseInt(rs.getString("canyurenshu"))+1;
		 int diaochazhi=Integer.parseInt(rs.getString("diaochazhi"))+qidaizhi;
		 int zongzhi=row*canyurenshu;
		 rs.close();
		 
		 
		 sql="update diaochaxinxi set  canyurenshu='"+canyurenshu+"',diaochazhi='"+diaochazhi+"',zongzhi='"+zongzhi+"' where   diaochabianhao='"+diaochabianhao+"'  ";
		 
		 d.hsgexecute(sql);
		
		 
		try{
			
			 response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>javscript:alert('操作成功！');window.history.go(-1);</script>"); 
		}catch(Exception e){
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
 
//	处理编辑
	@RequestMapping("doUpdateDiaochaxinxi.do")
	public String doUpdateDiaochaxinxi(int id,ModelMap map,Diaochaxinxi diaochaxinxi){
		diaochaxinxi=diaochaxinxiService.getById(id);
		map.put("diaochaxinxi", diaochaxinxi);
		return "diaochaxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("diaochaxinxiDetail.do")
	public String diaochaxinxiDetail(int id,ModelMap map,Diaochaxinxi diaochaxinxi){
		diaochaxinxi=diaochaxinxiService.getById(id);
		map.put("diaochaxinxi", diaochaxinxi);
		return "diaochaxinxi_detail";
	}
//	前台详细
	@RequestMapping("dcxxDetail.do")
	public String dcxxDetail(int id,ModelMap map,Diaochaxinxi diaochaxinxi){
		diaochaxinxi=diaochaxinxiService.getById(id);
		map.put("diaochaxinxi", diaochaxinxi);
		return "diaochaxinxidetail";
	}
//	
	@RequestMapping("updateDiaochaxinxi.do")
	public String updateDiaochaxinxi(int id,ModelMap map,Diaochaxinxi diaochaxinxi,HttpServletRequest request,HttpSession session){
		diaochaxinxiService.update(diaochaxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:diaochaxinxiList.do";
	}

//	分页查询
	@RequestMapping("diaochaxinxiList.do")
	public String diaochaxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Diaochaxinxi diaochaxinxi, String diaochabianhao, String huatimingcheng, String diaochamingcheng, String canyurenshu, String diaochazhi, String zongzhi, String gongsibianhao, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(diaochabianhao==null||diaochabianhao.equals("")){pmap.put("diaochabianhao", null);}else{pmap.put("diaochabianhao", diaochabianhao);}		if(huatimingcheng==null||huatimingcheng.equals("")){pmap.put("huatimingcheng", null);}else{pmap.put("huatimingcheng", huatimingcheng);}		if(diaochamingcheng==null||diaochamingcheng.equals("")){pmap.put("diaochamingcheng", null);}else{pmap.put("diaochamingcheng", diaochamingcheng);}		if(canyurenshu==null||canyurenshu.equals("")){pmap.put("canyurenshu", null);}else{pmap.put("canyurenshu", canyurenshu);}		if(diaochazhi==null||diaochazhi.equals("")){pmap.put("diaochazhi", null);}else{pmap.put("diaochazhi", diaochazhi);}		if(zongzhi==null||zongzhi.equals("")){pmap.put("zongzhi", null);}else{pmap.put("zongzhi", zongzhi);}		if(gongsibianhao==null||gongsibianhao.equals("")){pmap.put("gongsibianhao", null);}else{pmap.put("gongsibianhao", gongsibianhao);}		
		int total=diaochaxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Diaochaxinxi> list=diaochaxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "diaochaxinxi_list";
	}
	
	@RequestMapping("diaochaxinxiList2.do")
	public String diaochaxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Diaochaxinxi diaochaxinxi, String diaochabianhao, String huatimingcheng, String diaochamingcheng, String canyurenshu, String diaochazhi, String zongzhi, String gongsibianhao, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("gongsibianhao", (String)request.getSession().getAttribute("username"));
		if(diaochabianhao==null||diaochabianhao.equals("")){pmap.put("diaochabianhao", null);}else{pmap.put("diaochabianhao", diaochabianhao);}		if(huatimingcheng==null||huatimingcheng.equals("")){pmap.put("huatimingcheng", null);}else{pmap.put("huatimingcheng", huatimingcheng);}		if(diaochamingcheng==null||diaochamingcheng.equals("")){pmap.put("diaochamingcheng", null);}else{pmap.put("diaochamingcheng", diaochamingcheng);}		if(canyurenshu==null||canyurenshu.equals("")){pmap.put("canyurenshu", null);}else{pmap.put("canyurenshu", canyurenshu);}		if(diaochazhi==null||diaochazhi.equals("")){pmap.put("diaochazhi", null);}else{pmap.put("diaochazhi", diaochazhi);}		if(zongzhi==null||zongzhi.equals("")){pmap.put("zongzhi", null);}else{pmap.put("zongzhi", zongzhi);}		
		
		int total=diaochaxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Diaochaxinxi> list=diaochaxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "diaochaxinxi_list2";
	}	
	
	@RequestMapping("dcxxList.do")
	public String dcxxList(@RequestParam(value="page",required=false)String page,HttpServletRequest request,
			ModelMap map,HttpSession session,Diaochaxinxi diaochaxinxi, String diaochabianhao, String huatimingcheng, String diaochamingcheng, String canyurenshu, String diaochazhi, String zongzhi, String gongsibianhao, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		if(request.getParameter("huatimingcheng")!=null){
			huatimingcheng=request.getParameter("huatimingcheng");
			System.out.println("根据我的话题查询调查");
		}
		
		if(diaochabianhao==null||diaochabianhao.equals("")){pmap.put("diaochabianhao", null);}else{pmap.put("diaochabianhao", diaochabianhao);}		if(huatimingcheng==null||huatimingcheng.equals("")){pmap.put("huatimingcheng", null);}else{pmap.put("huatimingcheng", huatimingcheng);}		if(diaochamingcheng==null||diaochamingcheng.equals("")){pmap.put("diaochamingcheng", null);}else{pmap.put("diaochamingcheng", diaochamingcheng);}		if(canyurenshu==null||canyurenshu.equals("")){pmap.put("canyurenshu", null);}else{pmap.put("canyurenshu", canyurenshu);}		if(diaochazhi==null||diaochazhi.equals("")){pmap.put("diaochazhi", null);}else{pmap.put("diaochazhi", diaochazhi);}		if(zongzhi==null||zongzhi.equals("")){pmap.put("zongzhi", null);}else{pmap.put("zongzhi", zongzhi);}		if(gongsibianhao==null||gongsibianhao.equals("")){pmap.put("gongsibianhao", null);}else{pmap.put("gongsibianhao", gongsibianhao);}		
		int total=diaochaxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Diaochaxinxi> list=diaochaxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "diaochaxinxilist";
	}
	
	@RequestMapping("deleteDiaochaxinxi.do")
	public String deleteDiaochaxinxi(int id,HttpServletRequest request){
		diaochaxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:diaochaxinxiList.do";
	}
	
	@RequestMapping("quchongDiaochaxinxi.do")
	public void quchongDiaochaxinxi(Diaochaxinxi diaochaxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("diaochabianhao", diaochaxinxi.getDiaochabianhao());
		   System.out.println("diaochabianhao==="+diaochaxinxi.getDiaochabianhao());
		   System.out.println("diaochabianhao222==="+diaochaxinxiService.quchongDiaochaxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(diaochaxinxiService.quchongDiaochaxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "调查编号可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
