<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GradeStudentDetail</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
}
th {
    text-align: left;
}
</style>
</head>
<body>
 <table>
		<tr>
			<th>Student Name</th>
			<th>Student ID</th>
			<th>Grade</th>
		<tr>
		
		<c:forEach items="${studentlist}" var="onestudent">
			<tr>				
				<td><c:out value="${onestudent.hcStudent.studentname}" /></td>
				<td><c:out value="${onestudent.hcStudent.studentid}" /></td>
				<td><c:out value="${onestudent.grade}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>