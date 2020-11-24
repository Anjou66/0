<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="diaochaxinxihsgb" scope="page" class="com.bean.DiaochaxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=diaochaxinxi.xls");
%>
<html>
  <head>
    <title>调查信息</title>
  </head>

  <body >
 <%
			String sql="select * from diaochaxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>调查编号</td>    <td align='center'>话题名称</td>    <td align='center'>调查名称</td>    <td align='center'>参与人数</td>    <td align='center'>调查值</td>    <td align='center'>总值</td>    <td align='center'>公司编号</td>    <td  width='80' align='center'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=diaochaxinxihsgb.getAllDiaochaxinxi(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.diaochabianhao}</td>    <td>${u.huatimingcheng}</td>    <td>${u.diaochamingcheng}</td>    <td>${u.canyurenshu}</td>    <td>${u.diaochazhi}</td>    <td>${u.zongzhi}</td>    <td>${u.gongsibianhao}</td>    <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=diaochaxinxi'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

