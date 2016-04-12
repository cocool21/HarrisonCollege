<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>${Student ID}<p>
<br>
<br>
<p>${Student Name}</p>
<table>
<tr>
			
			<th>Class ID</th>
			<th>Semester</th>
			<th>Grade</th>
			
		</tr>
		<c:forEach items="${Transcript}" var="Transcript">
			<tr>
				<td><c:out value="${Transcript.classid}" /></td>
				<td><c:out value="${Transcript.semester}" /></td>
				<td><c:out value="${Transcript.grade}" /></td>
				
			</tr>
		</c:forEach>
		<form action="RegisteredClasses" method="Post">
				<input type="submit" name="Buy" value="{Transcript.classid}" ></form> <!--//garbage value --> 
</table>
</body>
</html>