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
<title>调查表信息</title>

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
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>

<%

%>

<body>
<jsp:include page="qttop.jsp"></jsp:include>

<div class="content">
	<div class="wrap">
		<div class="pad0">
			<div class="s_title">
				<div class="name">调查信息</div>
				<div class="menu">
					
				</div>
			</div>
			<div class="det_con"> 
					
					

<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                        
                    <%
                    
                    String diaochabianhao=request.getParameter("diaochabianhao");
                    
                    String sql="select * from diaochaxuanxiang where diaochabianhao='"+diaochabianhao+"'";
                    
                    ResultSet rs=connDbBean.executeQuery(sql);
                    int i=1;
                    int row=rs.getRow();
                    
                    %>
                    <form  action="insertDiaochaxinxiDetail.do?diaochabianhao=<%=diaochabianhao %>" method="post">
                    <% 
                    
                    while(rs.next()){
                    	
                    	%>
                    	
                    	 <tr style="border-bottom: 1px solid gray;">
                         	<td style="padding: 10px">
                         	<p><h3><%=rs.getString("biaoti") %></h3> </p>	
                         	
                         	选项A<input type="radio"  name="data<%=i %>"  value='<%if(rs.getString("daan").equals("A")){out.write("1");}else{out.write("0");} %>'   "><%=rs.getString("xuanxiangA") %></br>
                         	选项B<input type="radio"  name="data<%=i %>"  value='<%if(rs.getString("daan").equals("B")){out.write("1");}else{out.write("0");} %>'   "><%=rs.getString("xuanxiangB") %></br>
                         	选项C<input type="radio"  name="data<%=i %>"  value='<%if(rs.getString("daan").equals("C")){out.write("1");}else{out.write("0");}  %>'   "><%=rs.getString("xuanxiangC") %></br>
                         	
                       		
                         	
                         	</td>
                         
                         </tr>
                    	
                    	
                    	
                    	
                    	<%
                   
                    	i++;
                    }
                    
                    
                    %>     
                         
                         
                        
                         
                         
                         
                         
                        <tr> 
                        <td style="padding: 10px">
                        <input type="hidden" name="row" value='<%=i-1 %>'>
                        
                        	 <input type="submit" value="提交" />
						       <input type="reset" value="重置"/>&nbsp;
                        
                        </td>
                         </tr>
                         
                        </table>
<br>

</form>




					
			</div>	
		</div>
	</div>		
</div>
<jsp:include page="qtdown.jsp"></jsp:include>


</body>
</html>

