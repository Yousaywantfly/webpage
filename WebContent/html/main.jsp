<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
<script
	src="<%=application.getContextPath()%>/html/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		url:"<%=application.getContextPath()%>/UserServlet?op=selectall",
		success:function(list){
			var json=JSON.parse(list);
			var str="";
			for(var i=0;i<json.length;i++){
				str=str+"<tr><td>"+json[i].pid+"</td><td>"+json[i].pname+"</td><td>"+json[i].pinfor+"</td><td><a href='javascript:void(0)' onclick='textAddColl("+json[i].pid+")'>收藏</a></td></tr>";
			}
			$("#main").html(str);
		}
		
	});
	
	
});

function textAddColl(pid){
	
	$.ajax({
		url:"<%=application.getContextPath()%>/UserServlet?op=save&op1="+pid,
		success:function(msg){
			if(msg.flag){
				alert("收藏成功");
			}else{
				alert("收藏失败");
			}
			
			
		},
		dataType:"json"
	});
}







function textselect(){
	$.ajax({
		url:"<%=application.getContextPath()%>/UserServlet?op=select",
			data : {
				name : $("#select").val()
			},
			type : 'post',
			success : function(data) {
				alert(data);
				var jsonArray = JSON.parse(data);
				var str = "";
				for (var i = 0; i < jsonArray.length; i++) {
					str = str + "<tr><td>" + jsonArray[i].pid + "</td><td>"
							+ jsonArray[i].pname + "</td><td>"
							+ jsonArray[i].pinfor + "</td><tr>";
				}
				$("#main").html(str);
			}

		});

	}
</script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

html, body {
	height: 100%;
	width: 100%;
	overflow: hidden;
	/* position: fixed; */
}

.title {
	height: 7%;
	width: 100%;
	/* background-color: gray; */
}

h5 {
	font-size: 20px;
	margin-left: 70%;
	padding-top: 1.5%;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>

	<div class="title">
		<h5>${sessionScope.user.uname }
			<a href="login.jsp">注销</a> &nbsp;&nbsp;<a
				href="<%=application.getContextPath()%>/UserServlet?op=show"><img
				src="img/shoppingcar.jpg" style="height: 20px; width: 20px" />&nbsp;购物车

			</a> <input type="text" id="select">
			<button onclick="textselect()">搜索</button>
		</h5>
	</div>
	<div>
		<table id="main">

		</table>
	</div>
</body>
</html>