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

import com.entity.Huatixinxi;
import com.service.*;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class HuatixinxiController {
	@Resource
	private HuatixinxiServer huatixinxiService;


   
	@RequestMapping("addHuatixinxi.do")
	public String addHuatixinxi(HttpServletRequest request,Huatixinxi huatixinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		huatixinxi.setAddtime(time.toString().substring(0, 19));
		huatixinxiService.add(huatixinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "huatixinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:huatixinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateHuatixinxi.do")
	public String doUpdateHuatixinxi(int id,ModelMap map,Huatixinxi huatixinxi){
		huatixinxi=huatixinxiService.getById(id);
		map.put("huatixinxi", huatixinxi);
		return "huatixinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("huatixinxiDetail.do")
	public String huatixinxiDetail(int id,ModelMap map,Huatixinxi huatixinxi){
		huatixinxi=huatixinxiService.getById(id);
		map.put("huatixinxi", huatixinxi);
		return "huatixinxi_detail";
	}
//	前台详细
	@RequestMapping("htxxDetail.do")
	public String htxxDetail(int id,ModelMap map,Huatixinxi huatixinxi){
		huatixinxi=huatixinxiService.getById(id);
		map.put("huatixinxi", huatixinxi);
		return "huatixinxidetail";
	}
//	
	@RequestMapping("updateHuatixinxi.do")
	public String updateHuatixinxi(int id,ModelMap map,Huatixinxi huatixinxi,HttpServletRequest request,HttpSession session){
		huatixinxiService.update(huatixinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:huatixinxiList.do";
	}

//	分页查询
	@RequestMapping("huatixinxiList.do")
	public String huatixinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huatixinxi huatixinxi, String huatimingcheng){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huatimingcheng==null||huatimingcheng.equals("")){pmap.put("huatimingcheng", null);}else{pmap.put("huatimingcheng", huatimingcheng);}		
		int total=huatixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huatixinxi> list=huatixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huatixinxi_list";
	}
	
	
	
	@RequestMapping("htxxList.do")
	public String htxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huatixinxi huatixinxi, String huatimingcheng){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huatimingcheng==null||huatimingcheng.equals("")){pmap.put("huatimingcheng", null);}else{pmap.put("huatimingcheng", huatimingcheng);}		
		int total=huatixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huatixinxi> list=huatixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huatixinxilist";
	}
	
	@RequestMapping("deleteHuatixinxi.do")
	public String deleteHuatixinxi(int id,HttpServletRequest request){
		huatixinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:huatixinxiList.do";
	}
	
	@RequestMapping("quchongHuatixinxi.do")
	public void quchongHuatixinxi(Huatixinxi huatixinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("huatimingcheng", huatixinxi.getHuatimingcheng());
		   System.out.println("huatimingcheng==="+huatixinxi.getHuatimingcheng());
		   System.out.println("huatimingcheng222==="+huatixinxiService.quchongHuatixinxi(map));
		   JSONObject obj=new JSONObject();
		   if(huatixinxiService.quchongHuatixinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "话题名称可以用！");
				  
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
