<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html class="no-js">
<head>
<meta />
<title>公司信息</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="qtimages/css/reset.css" rel="stylesheet" />
<link href="qtimages/css/main.css" rel="stylesheet"/>
<link href="qtimages/css/sub.css" rel="stylesheet"/>
<script src="qtimages/jquery.js"></script> 
<script src="js/jquery.SuperSlide.2.1.1.js"></script>

<script type="text/javascript" src="qtimages/inc.js"></script>
<link rel="stylesheet" href="qtimages/hsgbanner.css">
</head>
<%

  String id="";


 



   %>


	
<script language=javascript >  
function hsgcheck() {
		var gongsibianhao = $("#gongsibianhao").val();
		if(gongsibianhao==""||(gongsibianhao.length<6||gongsibianhao.length>12)){
			 $("#clabelgongsibianhao").html("<font color=red>公司编号不能为空且长度在3～12位之间！</font>");
			 $("input[id=gongsibianhao]").focus();
			 $("#querenzhuce").attr("disabled","disabled");
			 return false;
		} 
		else
		{
			$("#clabelgongsibianhao").html("");
			$.ajax({
				url : "quchongGongsixinxi.do",
				type : "post",
				data : "gongsibianhao=" + gongsibianhao,
				dataType : "json",
				success:function(result){
				if(result.info=="ng"){
					$("#clabelgongsibianhao").html("<font color=red>公司编号已存在，请更换！</font>");
					$("input[id=gongsibianhao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
				else
				{
					$("#querenzhuce").removeAttr("disabled");
				}
				},
				error:function(){
					$("#clabelgongsibianhao").html("系统异常，请检查错误！");
					$("input[id=gongsibianhao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
			});
		}
	}
</script>
	<script language="javascript">
function checkform()
{
	var gongsibianhaoobj = document.getElementById("gongsibianhao"); if(gongsibianhaoobj.value==""){document.getElementById("clabelgongsibianhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入公司编号</font>";return false;}else{document.getElementById("clabelgongsibianhao").innerHTML="  "; } 	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 	var youxiangobj = document.getElementById("youxiang"); if(youxiangobj.value==""){document.getElementById("clabelyouxiang").innerHTML="&nbsp;&nbsp;<font color=red>请输入邮箱</font>";return false;}else{document.getElementById("clabelyouxiang").innerHTML="  "; } 	var gongsimingchengobj = document.getElementById("gongsimingcheng"); if(gongsimingchengobj.value==""){document.getElementById("clabelgongsimingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入公司名称</font>";return false;}else{document.getElementById("clabelgongsimingcheng").innerHTML="  "; } 	var leixingobj = document.getElementById("leixing"); if(leixingobj.value==""){document.getElementById("clabelleixing").innerHTML="&nbsp;&nbsp;<font color=red>请输入类型</font>";return false;}else{document.getElementById("clabelleixing").innerHTML="  "; } 	var xingyeobj = document.getElementById("xingye"); if(xingyeobj.value==""){document.getElementById("clabelxingye").innerHTML="&nbsp;&nbsp;<font color=red>请输入行业</font>";return false;}else{document.getElementById("clabelxingye").innerHTML="  "; } 	var guimoobj = document.getElementById("guimo"); if(guimoobj.value==""){document.getElementById("clabelguimo").innerHTML="&nbsp;&nbsp;<font color=red>请输入规模</font>";return false;}else{document.getElementById("clabelguimo").innerHTML="  "; } 	var jianjieobj = document.getElementById("jianjie"); if(jianjieobj.value==""){document.getElementById("clabeljianjie").innerHTML="&nbsp;&nbsp;<font color=red>请输入简介</font>";return false;}else{document.getElementById("clabeljianjie").innerHTML="  "; } 	
}
function gow()
{
	document.location.href="gongsixinxiadd.jsp?id=<%=id%>";
}
</script>


<body>
<jsp:include page="qttop.jsp"></jsp:include>

<div class="content">
	<div class="wrap">
		<div class="pad0">
			<div class="s_title">
				<div class="name">公司信息</div>
				<div class="menu">
					
				</div>
			</div>
			<div class="det_con"> 
					
					<% 




%>

  

				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse" class="newsline">
						<form action="addGongsixinxi.do" name="form1" method="post">
						<tr ><td width="200">公司编号：</td><td><input name='gongsibianhao' type='text' id='gongsibianhao' value='' onblur='hsgcheck()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelgongsibianhao' /></td></tr>		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelmima' /></td></tr>		<tr ><td width="200">邮箱：</td><td><input name='youxiang' type='text' id='youxiang' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelyouxiang' /></td></tr>		<tr ><td width="200">公司名称：</td><td><input name='gongsimingcheng' type='text' id='gongsimingcheng' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelgongsimingcheng' /></td></tr>		<tr ><td width="200">类型：</td><td><input name='leixing' type='text' id='leixing' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelleixing' /></td></tr>		<tr ><td width="200">行业：</td><td><input name='xingye' type='text' id='xingye' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelxingye' /></td></tr>		<tr ><td width="200">规模：</td><td><select name='guimo' id='guimo'><option value="1-50">1-50</option><option value="50-100">50-100</option><option value="100-1000">100-1000</option><option value="1000以上">1000以上</option></select>&nbsp;*<label id='clabelguimo' /></td></tr>		<tr ><td width="200">简介：</td><td><textarea name='jianjie' cols='50' rows='5' id='jianjie' onblur='checkform()' style='border:solid 1px #000000; color:#666666' ></textarea>&nbsp;*<label id='clabeljianjie' /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						      <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						</form>
					 </table>
			
			<script language="javascript">popheight = 450;</script>
					
			</div>	
		</div>
	</div>		
</div>
<jsp:include page="qtdown.jsp"></jsp:include>


</body>
</html>

