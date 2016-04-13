<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<p>${studentid}<p>
<br>
<br>
<p>${student}</p>
<table class="table">
<tr>
			
			<th>Class ID</th>
			<th>Semester</th>
			<th>Grade</th>
			
		</tr>
		<c:forEach items="${Transcript}" var="Transcript">
			<tr>
				<td><c:out value="${Transcript.hcClass.classid}" /></td>
				<td><c:out value="${Transcript.hcClass.semester}" /></td>
				<td><c:out value="${Transcript.grade}" /></td>
				
			</tr>
		</c:forEach>
		<form action="RegisteredClasses" method="Post">
				<input type="submit" name="Buy" value="{Transcript.classid}" ></form> <!--//garbage value --> 
</table>
</body>
</html>