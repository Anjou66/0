﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>修改我的话题</TITLE>
	    
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="wodehuati_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateWodehuati.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改我的话题<input type="hidden" name="id" value="${wodehuati.id}" /></td>
						</tr>
						<tr ><td width="200">话题名称：</td><td><select name='huatimingcheng' id='huatimingcheng' style=' height:19px; border:solid 1px #000000; color:#666666'><%=connDbBean.hsggetoption("huatixinxi","huatimingcheng")%></select></td></tr>		<tr ><td width="200">用户昵称：</td><td><input name='yonghucheng' type='text' id='yonghucheng' onblur='checkform()' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" />&nbsp;*<label id='clabelyonghucheng' /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.huatimingcheng.value='${wodehuati.huatimingcheng}';</script>	<script language="javascript">document.form1.yonghucheng.value='${wodehuati.yonghucheng}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var yonghuchengobj = document.getElementById("yonghucheng"); if(yonghuchengobj.value==""){document.getElementById("clabelyonghucheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入用户昵称</font>";return false;}else{document.getElementById("clabelyonghucheng").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
