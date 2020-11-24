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

import com.entity.Wodehuati;
import com.service.*;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class WodehuatiController {
	@Resource
	private WodehuatiServer wodehuatiService;


   
	@RequestMapping("addWodehuati.do")
	public String addWodehuati(HttpServletRequest request,Wodehuati wodehuati,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		wodehuati.setAddtime(time.toString().substring(0, 19));
		wodehuatiService.add(wodehuati);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "wodehuatiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:wodehuatiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateWodehuati.do")
	public String doUpdateWodehuati(int id,ModelMap map,Wodehuati wodehuati){
		wodehuati=wodehuatiService.getById(id);
		map.put("wodehuati", wodehuati);
		return "wodehuati_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("wodehuatiDetail.do")
	public String wodehuatiDetail(int id,ModelMap map,Wodehuati wodehuati){
		wodehuati=wodehuatiService.getById(id);
		map.put("wodehuati", wodehuati);
		return "wodehuati_detail";
	}
//	前台详细
	@RequestMapping("wdhtDetail.do")
	public String wdhtDetail(int id,ModelMap map,Wodehuati wodehuati){
		wodehuati=wodehuatiService.getById(id);
		map.put("wodehuati", wodehuati);
		return "wodehuatidetail";
	}
//	
	@RequestMapping("updateWodehuati.do")
	public String updateWodehuati(int id,ModelMap map,Wodehuati wodehuati,HttpServletRequest request,HttpSession session){
		wodehuatiService.update(wodehuati);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:wodehuatiList.do";
	}

//	分页查询
	@RequestMapping("wodehuatiList.do")
	public String wodehuatiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wodehuati wodehuati, String huatimingcheng, String yonghucheng){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huatimingcheng==null||huatimingcheng.equals("")){pmap.put("huatimingcheng", null);}else{pmap.put("huatimingcheng", huatimingcheng);}		if(yonghucheng==null||yonghucheng.equals("")){pmap.put("yonghucheng", null);}else{pmap.put("yonghucheng", yonghucheng);}		
		int total=wodehuatiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wodehuati> list=wodehuatiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wodehuati_list";
	}
	
	@RequestMapping("wodehuatiList2.do")
	public String wodehuatiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wodehuati wodehuati, String huatimingcheng, String yonghucheng,HttpServletRequest request){
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
		
		pmap.put("yonghucheng", (String)request.getSession().getAttribute("username"));
		if(huatimingcheng==null||huatimingcheng.equals("")){pmap.put("huatimingcheng", null);}else{pmap.put("huatimingcheng", huatimingcheng);}		
		
		int total=wodehuatiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wodehuati> list=wodehuatiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wodehuati_list2";
	}	
	
	@RequestMapping("wdhtList.do")
	public String wdhtList(@RequestParam(value="page",required=false)String page,HttpServletResponse response,
			ModelMap map,HttpSession session,Wodehuati wodehuati, String huatimingcheng, String yonghucheng){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(session.getAttribute("username")!=null){
			yonghucheng=session.getAttribute("username").toString();
		}else{
			
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().write("<script>javscript:alert('操作成功！');window.history.go(-1);</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return "userlog";
		}
		
		
		
		if(huatimingcheng==null||huatimingcheng.equals("")){pmap.put("huatimingcheng", null);}else{pmap.put("huatimingcheng", huatimingcheng);}		if(yonghucheng==null||yonghucheng.equals("")){pmap.put("yonghucheng", null);}else{pmap.put("yonghucheng", yonghucheng);}		
		int total=wodehuatiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wodehuati> list=wodehuatiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wodehuatilist";
	}
	
	@RequestMapping("deleteWodehuati.do")
	public String deleteWodehuati(int id,HttpServletRequest request){
		wodehuatiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:wodehuatiList.do";
	}
	
	
}
