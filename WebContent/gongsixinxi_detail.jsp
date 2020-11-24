<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>公司信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  公司信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>公司编号：</td><td width='39%'>${gongsixinxi.gongsibianhao}</td>     <td width='11%'>密码：</td><td width='39%'>${gongsixinxi.mima}</td></tr><tr>     <td width='11%'>邮箱：</td><td width='39%'>${gongsixinxi.youxiang}</td>     <td width='11%'>公司名称：</td><td width='39%'>${gongsixinxi.gongsimingcheng}</td></tr><tr>     <td width='11%'>类型：</td><td width='39%'>${gongsixinxi.leixing}</td>     <td width='11%'>行业：</td><td width='39%'>${gongsixinxi.xingye}</td></tr><tr>     <td width='11%'>规模：</td><td width='39%'>${gongsixinxi.guimo}</td>     <td width='11%'>简介：</td><td width='39%'>${gongsixinxi.jianjie}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

