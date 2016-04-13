<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registered List</title>
</head>

<body>
<%@ include file="Menu.jsp" %>
	<table class="table">
		<tr>
			<th>Class ID</th>
			<th>Course ID</th>
			<th>Course Name</th>
			<th>Instructor</th>
			<th>Classroom</th>
			<th>Building</th>
			<th>Schedule</th>
			<th>Semester</th>
			<th>Credits</th>
			<th>action</th>
		</tr>
		
		<c:forEach items="${registeredlist}" var="registered">
			<tr>
				<td><c:out value="${registered.hcClass.classid}" /></td>
				<td><c:out value="${registered.hcClass.hcCours.courseid}" /></td>
				<td><c:out value="${registered.hcClass.hcCours.coursename}" /></td>
				<td><c:out value="${registered.hcClass.hcInstructor.instructorname}" /></td>
				<td><c:out value="${registered.hcClass.hcClassroom.roomnumber}" /></td>
				<td><c:out value="${registered.hcClass.hcClassroom.buildingname}" /></td>
				<td><c:out value="${registered.hcClass.schedule}" /></td>
				<td><c:out value="${registered.hcClass.semester}" /></td>
				<td><c:out value="${registered.hcClass.hcCours.credits}" /></td>
				<td><form action="DropServlet" method="Post">
				<input type="hidden" name="drop" value="${registered.hcClass.classid}">
				<input type="submit" value="drop" ></form></td>
			</tr>
		</c:forEach>
		</table>
	
	<form action="ClassAddListServlet" method="Post">
		<input type="hidden" name="add" value="${studentid}">
		<input type="submit" name="add" value="add class" >
		</form>
</body>
</html>