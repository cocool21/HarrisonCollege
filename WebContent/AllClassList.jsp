<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Class List</title>
</head>
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
		</tr>
		<c:forEach items="${classlist}" var="class">
			<tr>
				<td><c:out value="${class.classid}" /></td>
				<td><c:out value="${class.hcCours.courseid}" /></td>
				<td><c:out value="${class.hcCours.coursename}" /></td>
				<td><c:out value="${class.hcInstructor.instructorname}" /></td>
				<td><c:out value="${class.hcClassroom.roomnumber + class.hcClassroom.buildingname}" /></td>
				<td><c:out value="${class.schedule}" /></td>
				<td><c:out value="${class.semester}" /></td>
				<td><c:out value="${class.hcCours.credits}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>