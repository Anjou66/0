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

import com.entity.Gongsixinxi;
//import com.server.GongsixinxiServer;
import com.service.*;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class GongsixinxiController {
	@Resource
	private GongsixinxiServer gongsixinxiService;


   
	@RequestMapping("addGongsixinxi.do")
	public String addGongsixinxi(HttpServletRequest request,Gongsixinxi gongsixinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		gongsixinxi.setAddtime(time.toString().substring(0, 19));
		gongsixinxiService.add(gongsixinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "gongsixinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:gongsixinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateGongsixinxi.do")
	public String doUpdateGongsixinxi(int id,ModelMap map,Gongsixinxi gongsixinxi){
		gongsixinxi=gongsixinxiService.getById(id);
		map.put("gongsixinxi", gongsixinxi);
		return "gongsixinxi_updt";
	}
	
	@RequestMapping("doUpdateGongsixinxi2.do")
	public String doUpdateGongsixinxi2(ModelMap map,Gongsixinxi gongsixinxi,HttpServletRequest request){
		gongsixinxi=gongsixinxiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("gongsixinxi", gongsixinxi);
		return "gongsixinxi_updt2";
	}
	
@RequestMapping("updateGongsixinxi2.do")
	public String updateGongsixinxi2(int id,ModelMap map,Gongsixinxi gongsixinxi){
		gongsixinxiService.update(gongsixinxi);
		return "redirect:doUpdateGongsixinxi2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("gongsixinxiDetail.do")
	public String gongsixinxiDetail(int id,ModelMap map,Gongsixinxi gongsixinxi){
		gongsixinxi=gongsixinxiService.getById(id);
		map.put("gongsixinxi", gongsixinxi);
		return "gongsixinxi_detail";
	}
//	前台详细
	@RequestMapping("gsxxDetail.do")
	public String gsxxDetail(int id,ModelMap map,Gongsixinxi gongsixinxi){
		gongsixinxi=gongsixinxiService.getById(id);
		map.put("gongsixinxi", gongsixinxi);
		return "gongsixinxidetail";
	}
//	
	@RequestMapping("updateGongsixinxi.do")
	public String updateGongsixinxi(int id,ModelMap map,Gongsixinxi gongsixinxi,HttpServletRequest request,HttpSession session){
		gongsixinxiService.update(gongsixinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:gongsixinxiList.do";
	}

//	分页查询
	@RequestMapping("gongsixinxiList.do")
	public String gongsixinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gongsixinxi gongsixinxi, String gongsibianhao, String mima, String youxiang, String gongsimingcheng, String leixing, String xingye, String guimo, String jianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gongsibianhao==null||gongsibianhao.equals("")){pmap.put("gongsibianhao", null);}else{pmap.put("gongsibianhao", gongsibianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}		if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}		if(leixing==null||leixing.equals("")){pmap.put("leixing", null);}else{pmap.put("leixing", leixing);}		if(xingye==null||xingye.equals("")){pmap.put("xingye", null);}else{pmap.put("xingye", xingye);}		if(guimo==null||guimo.equals("")){pmap.put("guimo", null);}else{pmap.put("guimo", guimo);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		
		int total=gongsixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gongsixinxi> list=gongsixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gongsixinxi_list";
	}
	
	
	
	@RequestMapping("gsxxList.do")
	public String gsxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gongsixinxi gongsixinxi, String gongsibianhao, String mima, String youxiang, String gongsimingcheng, String leixing, String xingye, String guimo, String jianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gongsibianhao==null||gongsibianhao.equals("")){pmap.put("gongsibianhao", null);}else{pmap.put("gongsibianhao", gongsibianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}		if(gongsimingcheng==null||gongsimingcheng.equals("")){pmap.put("gongsimingcheng", null);}else{pmap.put("gongsimingcheng", gongsimingcheng);}		if(leixing==null||leixing.equals("")){pmap.put("leixing", null);}else{pmap.put("leixing", leixing);}		if(xingye==null||xingye.equals("")){pmap.put("xingye", null);}else{pmap.put("xingye", xingye);}		if(guimo==null||guimo.equals("")){pmap.put("guimo", null);}else{pmap.put("guimo", guimo);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		
		int total=gongsixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gongsixinxi> list=gongsixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gongsixinxilist";
	}
	
	@RequestMapping("deleteGongsixinxi.do")
	public String deleteGongsixinxi(int id,HttpServletRequest request){
		gongsixinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:gongsixinxiList.do";
	}
	
	@RequestMapping("quchongGongsixinxi.do")
	public void quchongGongsixinxi(Gongsixinxi gongsixinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("gongsibianhao", gongsixinxi.getGongsibianhao());
		   System.out.println("gongsibianhao==="+gongsixinxi.getGongsibianhao());
		   System.out.println("gongsibianhao222==="+gongsixinxiService.quchongGongsixinxi(map));
		   JSONObject obj=new JSONObject();
		   if(gongsixinxiService.quchongGongsixinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "公司编号可以用！");
				  
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
