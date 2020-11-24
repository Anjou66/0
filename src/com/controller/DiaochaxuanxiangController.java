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

import com.entity.Diaochaxuanxiang;
import com.service.*;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class DiaochaxuanxiangController {
	@Resource
	private DiaochaxuanxiangServer diaochaxuanxiangService;


   
	@RequestMapping("addDiaochaxuanxiang.do")
	public String addDiaochaxuanxiang(HttpServletRequest request,Diaochaxuanxiang diaochaxuanxiang,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		diaochaxuanxiang.setAddtime(time.toString().substring(0, 19));
		diaochaxuanxiangService.add(diaochaxuanxiang);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "diaochaxuanxiangList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:diaochaxuanxiangList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateDiaochaxuanxiang.do")
	public String doUpdateDiaochaxuanxiang(int id,ModelMap map,Diaochaxuanxiang diaochaxuanxiang){
		diaochaxuanxiang=diaochaxuanxiangService.getById(id);
		map.put("diaochaxuanxiang", diaochaxuanxiang);
		return "diaochaxuanxiang_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("diaochaxuanxiangDetail.do")
	public String diaochaxuanxiangDetail(int id,ModelMap map,Diaochaxuanxiang diaochaxuanxiang){
		diaochaxuanxiang=diaochaxuanxiangService.getById(id);
		map.put("diaochaxuanxiang", diaochaxuanxiang);
		return "diaochaxuanxiang_detail";
	}
	
	//命名规则
	
//	前台详细
	@RequestMapping("dcxxDetail2.do")
	public String dcxxDetail(int id,ModelMap map,Diaochaxuanxiang diaochaxuanxiang){
		diaochaxuanxiang=diaochaxuanxiangService.getById(id);
		map.put("diaochaxuanxiang", diaochaxuanxiang);
		return "diaochaxuanxiangdetail";
	}
//	
	@RequestMapping("updateDiaochaxuanxiang.do")
	public String updateDiaochaxuanxiang(int id,ModelMap map,Diaochaxuanxiang diaochaxuanxiang,HttpServletRequest request,HttpSession session){
		diaochaxuanxiangService.update(diaochaxuanxiang);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:diaochaxuanxiangList.do";
	}

//	分页查询
	@RequestMapping("diaochaxuanxiangList.do")
	public String diaochaxuanxiangList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Diaochaxuanxiang diaochaxuanxiang, String biaoti, String xuanxiangA, String xuanxiangB, String xuanxiangC, String daan, String diaochabianhao, String gongsibianhao){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(xuanxiangA==null||xuanxiangA.equals("")){pmap.put("xuanxiangA", null);}else{pmap.put("xuanxiangA", xuanxiangA);}		if(xuanxiangB==null||xuanxiangB.equals("")){pmap.put("xuanxiangB", null);}else{pmap.put("xuanxiangB", xuanxiangB);}		if(xuanxiangC==null||xuanxiangC.equals("")){pmap.put("xuanxiangC", null);}else{pmap.put("xuanxiangC", xuanxiangC);}		if(daan==null||daan.equals("")){pmap.put("daan", null);}else{pmap.put("daan", daan);}		if(diaochabianhao==null||diaochabianhao.equals("")){pmap.put("diaochabianhao", null);}else{pmap.put("diaochabianhao", diaochabianhao);}		if(gongsibianhao==null||gongsibianhao.equals("")){pmap.put("gongsibianhao", null);}else{pmap.put("gongsibianhao", gongsibianhao);}		
		int total=diaochaxuanxiangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Diaochaxuanxiang> list=diaochaxuanxiangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "diaochaxuanxiang_list";
	}
	
	@RequestMapping("diaochaxuanxiangList2.do")
	public String diaochaxuanxiangList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Diaochaxuanxiang diaochaxuanxiang, String biaoti, String xuanxiangA, String xuanxiangB, String xuanxiangC, String daan, String diaochabianhao, String gongsibianhao,HttpServletRequest request){
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
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(xuanxiangA==null||xuanxiangA.equals("")){pmap.put("xuanxiangA", null);}else{pmap.put("xuanxiangA", xuanxiangA);}		if(xuanxiangB==null||xuanxiangB.equals("")){pmap.put("xuanxiangB", null);}else{pmap.put("xuanxiangB", xuanxiangB);}		if(xuanxiangC==null||xuanxiangC.equals("")){pmap.put("xuanxiangC", null);}else{pmap.put("xuanxiangC", xuanxiangC);}		if(daan==null||daan.equals("")){pmap.put("daan", null);}else{pmap.put("daan", daan);}		if(diaochabianhao==null||diaochabianhao.equals("")){pmap.put("diaochabianhao", null);}else{pmap.put("diaochabianhao", diaochabianhao);}		
		
		int total=diaochaxuanxiangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Diaochaxuanxiang> list=diaochaxuanxiangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "diaochaxuanxiang_list2";
	}	
	
	@RequestMapping("dcxx2List.do")
	public String dcxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Diaochaxuanxiang diaochaxuanxiang, String biaoti, String xuanxiangA, String xuanxiangB, String xuanxiangC, String daan, String diaochabianhao, String gongsibianhao){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(xuanxiangA==null||xuanxiangA.equals("")){pmap.put("xuanxiangA", null);}else{pmap.put("xuanxiangA", xuanxiangA);}		if(xuanxiangB==null||xuanxiangB.equals("")){pmap.put("xuanxiangB", null);}else{pmap.put("xuanxiangB", xuanxiangB);}		if(xuanxiangC==null||xuanxiangC.equals("")){pmap.put("xuanxiangC", null);}else{pmap.put("xuanxiangC", xuanxiangC);}		if(daan==null||daan.equals("")){pmap.put("daan", null);}else{pmap.put("daan", daan);}		if(diaochabianhao==null||diaochabianhao.equals("")){pmap.put("diaochabianhao", null);}else{pmap.put("diaochabianhao", diaochabianhao);}		if(gongsibianhao==null||gongsibianhao.equals("")){pmap.put("gongsibianhao", null);}else{pmap.put("gongsibianhao", gongsibianhao);}		
		int total=diaochaxuanxiangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Diaochaxuanxiang> list=diaochaxuanxiangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "diaochaxuanxianglist";
	}
	
	@RequestMapping("deleteDiaochaxuanxiang.do")
	public String deleteDiaochaxuanxiang(int id,HttpServletRequest request){
		diaochaxuanxiangService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:diaochaxuanxiangList.do";
	}
	
	
}
