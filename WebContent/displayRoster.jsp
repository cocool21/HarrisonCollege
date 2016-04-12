<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display Roster</title>
</head>
<body>
Instructor: <c:out value="${teacherid}" /><br />
Class: <c:out value="${classid}" /><br />
	<table>
		<tr>
			<th>Student ID</th>
			<th>Student Name</th>
			<th>Grade</th>
			<th></th>
			
		</tr>
		<c:forEach items="${roster}" var="student">
			<tr>
				<td><c:out value="${student.hcStudent.studentid}" /></td>
				<td><c:out value="${student.hcStudent.studentname}" /></td>
				<td><c:out value="${student.grade}" /></td>
			    <td><form action="SignUpServlet" method="post">
			    <input type="hidden" name="student" value="${student }">
			    <input type="text" name="grade" value="${student.grade}">
			    <input type="submit" value="Update Grade"></form>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form action="ReturnToMenu" method="post">
	<input type="submit" value="Return to menu">
</form>
</body>
</html>