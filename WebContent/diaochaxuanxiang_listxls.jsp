<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="diaochaxuanxianghsgb" scope="page" class="com.bean.DiaochaxuanxiangBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=diaochaxuanxiang.xls");
%>
<html>
  <head>
    <title>调查选项</title>
  </head>

  <body >
 <%
			String sql="select * from diaochaxuanxiang  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>标题</td>    <td align='center'>选项A</td>    <td align='center'>选项B</td>    <td align='center'>选项C</td>    <td align='center'>答案</td>    <td align='center'>调查编号</td>    <td align='center'>公司编号</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=diaochaxuanxianghsgb.getAllDiaochaxuanxiang(9);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.biaoti}</td>    <td>${u.xuanxiangA}</td>    <td>${u.xuanxiangB}</td>    <td>${u.xuanxiangC}</td>    <td>${u.daan}</td>    <td>${u.diaochabianhao}</td>    <td>${u.gongsibianhao}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

