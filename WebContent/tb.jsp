<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图标情况</title>
<link rel="stylesheet" type="text/css" href="css/Chart.min.css" />
		<script type="text/javascript" src="js/Chart.min.js"></script>
</head>


<%

String diaochabianhao=request.getParameter("diaochabianhao");
String sql="select * from diaochaxinxi where diaochabianhao ='"+diaochabianhao+"'";
ResultSet rs=connDbBean.executeQuery(sql);
rs.next();

int zongzi=Integer.parseInt(rs.getString("zongzhi"));
int diaochazhi=Integer.parseInt(rs.getString("diaochazhi"));

int chazhi=zongzi-diaochazhi;


%>



<body>
<div style="width: 500px;height: 500px">
<canvas id="myChart_pie" width="200px" height="200px"></canvas>

		<script>
			var ctx = document.getElementById('myChart_pie').getContext('2d');
			var data = {
				datasets: [{
					data: [<%=diaochazhi%>, <%=chazhi%>], //在这里写数据
					backgroundColor: ["green", "red"] //在这里指定颜色
				}],

				labels: [ //这里写标签，即每个数据属于哪个种类
					'期待值',
					'非期待值'
					
				]
			};

			var myPieChart = new Chart(ctx, {
				type: 'pie',
				data: data
			});
		</script>

</div>



</body>
</html>