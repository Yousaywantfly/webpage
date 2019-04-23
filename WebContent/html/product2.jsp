<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品详情页</title>
		<style type="text/css">
			*{
				margin: 0;
				padding: 0;
			}
			.picture{
				height: 500px;
				width: 450px;
				
				margin-left: 30px;
				background-color: yellow;
				float: left;
			}
			.infor{
				height: 450px;
				width: 700px;
				margin-top: 100px;
				margin-left: 500px;
				
			}
			.infor_title{
				font-size: 50px;
				/*padding-left: 10%;*/
				
			}
			.infor_price{
				/*padding-left: 10%;*/
				background-color: lightgray;
				height:30%;
			}
			 #price{
				padding-top: 5%;
				padding-left: 5%;
			}
			 #price1{
				
				padding-left: 9.5%;
			}
			.save{
				padding-top: 30%;
				padding-left: 10%;
				float: left;
			}
			.delete{
				padding-top: 30%;
				padding-left: 30%;
			}
		</style><title>Insert title here</title>
</head>
<body>
<div class="body">
		<div class="picture"><img src="img/background.png" style="width: 450px;height: 500px;"/></div>
		<div class="infor">
			<div class="infor_title">北京大学学历代办</div>
			<div class="infor_price"><h4 id="price">统一零售价：9999</h4><br/><h4 id="price1">促销价：9998</h4></div>
			<div class="infor_infor"></div>
			<div class="save"><a href="<%=application.getContextPath()%>/UserServlet?op=save&op1=2">收藏</a></div>
			<div class="delete"><a href="<%=application.getContextPath()%>/UserServlet?op=delete&op1=2">取消收藏</a></div>
		</div>
		</div>
</body>
</html>