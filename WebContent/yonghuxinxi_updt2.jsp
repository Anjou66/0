<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<TITLE>修改用户信息</TITLE>
	    
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
       
	</head>


	<body>
			<form action="updateYonghuxinxi2.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改用户信息<input type="hidden" name="id" value="${yonghuxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">用户昵称：</td><td><input name='yonghucheng' type='text' id='yonghucheng' value='' onblur='hsgcheck()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelyonghucheng' /></td></tr>		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelmima' /></td></tr>		<tr ><td width="200">头像：</td><td><input name='touxiang' type='text' id='touxiang' size='50' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('touxiang')" style='border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabeltouxiang' /></td></tr>		<tr ><td width="200">手机：</td><td><input name='shouji' type='text' id='shouji' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelshouji' /></td></tr>		<tr ><td width="200">邮箱：</td><td><input name='youxiang' type='text' id='youxiang' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelyouxiang' /></td></tr>		<tr ><td width="200">出生日期：</td><td><input name='chushengriqi' type='text' id='chushengriqi' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/></td></tr>		<tr ><td width="200">性别：</td><td><select name='xingbie' id='xingbie'><option value="男">男</option><option value="女">女</option></select>&nbsp;*<label id='clabelxingbie' /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.yonghucheng.value='${yonghuxinxi.yonghucheng}';</script>	<script language="javascript">document.form1.mima.value='${yonghuxinxi.mima}';</script>	<script language="javascript">document.form1.touxiang.value='${yonghuxinxi.touxiang}';</script>	<script language="javascript">document.form1.shouji.value='${yonghuxinxi.shouji}';</script>	<script language="javascript">document.form1.youxiang.value='${yonghuxinxi.youxiang}';</script>	<script language="javascript">document.form1.chushengriqi.value='${yonghuxinxi.chushengriqi}';</script>	<script language="javascript">document.form1.xingbie.value='${yonghuxinxi.xingbie}';</script>	
					 </table>
			</form>
   </body>
</html>



<!--hssgchesck-->


<script language=javascript >  
 
 function checkform(){  
 
	var yonghuchengobj = document.getElementById("yonghucheng"); if(yonghuchengobj.value==""){document.getElementById("clabelyonghucheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入用户昵称</font>";return false;}else{document.getElementById("clabelyonghucheng").innerHTML="  "; } 	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 	var touxiangobj = document.getElementById("touxiang"); if(touxiangobj.value==""){document.getElementById("clabeltouxiang").innerHTML="&nbsp;&nbsp;<font color=red>请输入头像</font>";return false;}else{document.getElementById("clabeltouxiang").innerHTML="  "; } 	var shoujiobj = document.getElementById("shouji"); if(shoujiobj.value==""){document.getElementById("clabelshouji").innerHTML="&nbsp;&nbsp;<font color=red>请输入手机</font>";return false;}else{document.getElementById("clabelshouji").innerHTML="  "; } 	var youxiangobj = document.getElementById("youxiang"); if(youxiangobj.value==""){document.getElementById("clabelyouxiang").innerHTML="&nbsp;&nbsp;<font color=red>请输入邮箱</font>";return false;}else{document.getElementById("clabelyouxiang").innerHTML="  "; } 	var xingbieobj = document.getElementById("xingbie"); if(xingbieobj.value==""){document.getElementById("clabelxingbie").innerHTML="&nbsp;&nbsp;<font color=red>请输入性别</font>";return false;}else{document.getElementById("clabelxingbie").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
