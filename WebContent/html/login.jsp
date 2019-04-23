<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆</title>
<script src="<%=application.getContextPath()%>/html/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function textAjax() {
		var form = $("#main").serialize();
		alert(form);
		$.ajax({
			/* 	url : "UserServlet?" + form + "&op=login", */
			url : "<%=application.getContextPath()%>/UserServlet?op=login&" + form,
			success : function(msg) {
				if (msg.flag) {
					location.href = "<%=application.getContextPath()%>/html/main.jsp";
				} else {
					alert("用户名或密码错误");
				}
			},
			dataType : "json"
		});
		return false;
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
	position: fixed;
}

.main {
	margin-top: 5%;
	margin-left: 10%;
	height: 60%;
	width: 25%;
	/*position: relative;*/
	/*background-color:black;*/
	border-radius: 5%;
	position: fixed;
}

#size {
	font-size: 50px;
	font-family: "微软雅黑";
	color: rgba(1, 1, 1, 0.5);
}

#username1 {
	margin-top: 20%;
	margin-left: 20%;
}

#password1 {
	margin-top: 30%;
	margin-left: 20%;
}

#button {
	margin-top: 30%;
	margin-left: 30%;
	margin-bottom: 15%;
	height: 5%;
	width: 5%;
}
</style>

</head>
<body background="img/background3.jpg"
	style="background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed;">
	<form action="" method="post" id="main" onsubmit="return textAjax()">

		<fieldset class="main">

			<legend id="size">登陆:</legend>
			<div class="main1">
				<div id="username1">
					用户名： <input type="text"
						style="border: 0px; background: rgba(0, 0, 0, 0.2);"
						name="username" id="username" />
				</div>
				<div id="password1">
					密&nbsp;&nbsp;&nbsp;码： <input type="text"
						style="border: 0px; background: rgba(0, 0, 0, 0.2);"
						name="password" id="password" />
				</div>
				<div id="button">
					<button type="submit"
						style="height: 45px; width: 120px; background: rgba(0, 0, 0, 0.2);">
						登陆</button>
				</div>
			</div>
		</fieldset>

	</form>

</body>
</html>