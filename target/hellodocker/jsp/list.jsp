<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>demo</title>
</head>
<body>
<center>
<table style="width:600px;" border="1">
	<tr>
		<th>姓名</th>
		<th>年龄</th>
	</tr>
	<c:forEach var="user" items="${userList}">
		<tr>
			<td>${user.name }</td>
			<td>${user.age }</td>
		</tr>
	</c:forEach>

</table>
</center>
</body>
</html>