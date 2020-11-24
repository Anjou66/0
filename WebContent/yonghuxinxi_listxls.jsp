<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="yonghuxinxihsgb" scope="page" class="com.bean.YonghuxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=yonghuxinxi.xls");
%>
<html>
  <head>
    <title>用户信息</title>
  </head>

  <body >
 <%
			String sql="select * from yonghuxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>用户昵称</td>    <td align='center'>密码</td>    <td  width='90' align='center'>头像</td>    <td align='center'>手机</td>    <td align='center'>邮箱</td>    <td  width='65' align='center'>出生日期</td>    <td  width='40' align='center'>性别</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=yonghuxinxihsgb.getAllYonghuxinxi(9);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.yonghucheng}</td>    <td>${u.mima}</td>    <td width='90' align='center'><a href='${u.touxiang}' target='_blank'><img src='${u.touxiang}' width=88 height=99 border=0 /></a></td>    <td>${u.shouji}</td>    <td>${u.youxiang}</td>    <td>${u.chushengriqi}</td>    <td align='center'>${u.xingbie}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

