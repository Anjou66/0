<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="gongsixinxihsgb" scope="page" class="com.bean.GongsixinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=gongsixinxi.xls");
%>
<html>
  <head>
    <title>公司信息</title>
  </head>

  <body >
 <%
			String sql="select * from gongsixinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>公司编号</td>    <td align='center'>密码</td>    <td align='center'>邮箱</td>    <td align='center'>公司名称</td>    <td align='center'>类型</td>    <td align='center'>行业</td>    <td align='center'>规模</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=gongsixinxihsgb.getAllGongsixinxi(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.gongsibianhao}</td>    <td>${u.mima}</td>    <td>${u.youxiang}</td>    <td>${u.gongsimingcheng}</td>    <td>${u.leixing}</td>    <td>${u.xingye}</td>    <td>${u.guimo}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

