<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registered List</title>
</head>
<body>
<body>
	<table>
		<tr>
			<th>Class ID</th>
			<th>Course ID</th>
			<th>Course Name</th>
			<th>Instructor</th>
			<th>Classroom</th>
			<th>Schedule</th>
			<th>Semester</th>
			<th>Credits</th>
			<th>action</th>
		</tr>
		<c:forEach items="${registeredlist}" var="registered">
			<tr>
				<td><c:out value="${registered.classid}" /></td>
				<td><c:out value="${registered.hcCours.courseid}" /></td>
				<td><c:out value="${registered.hcCours.coursename}" /></td>
				<td><c:out value="${registered.hcInstructor.instructorname}" /></td>
				<td><c:out value="${registered.hcClassroom.roomnumber + class.hcClassroom.buildingname}" /></td>
				<td><c:out value="${registered.schedule}" /></td>
				<td><c:out value="${registered.semester}" /></td>
				<td><c:out value="${registered.hcCours.credits}" /></td>
				<td><input type="submit" name="drop" value="drop button" ></td>
			</tr>
		</c:forEach>
		<form action="AddDropServlet" method="Post">
		
		<input type="submit" name="add" value="add button" >
		</form>
	</table>
</body>
</html>