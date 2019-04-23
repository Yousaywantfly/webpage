<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的收藏</title>
</head>
<body>
<table>
<c:forEach items="${sessionScope.l }" var="l" >
 <tr>
<td>${l.user.uname }</td>
<td>${l.pro.pname } </td>
<td>${l.pro.pinfor }</td>
<td>${l.save_time }</td>
</tr>
</c:forEach>
</table>
</body>
</html>