<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Instructor Menu</title>
</head>
<body>
	<form action="viewcourses" method="post">
		<p>
			<br />
		<h3>View All Courses</h3>
		<br /> <input type="hidden" name="option" value="1"> 
		<label for="viewcourses"></label> 
			<input id="viewcourses" name="viewcourses" value="viewcourses">
			 <input type="submit" value="View Courses">
		</p>
	</form>

	<form action="viewclasses" method="post">
		<p>
			<br />
		<h3>View All Classes in Current Semester</h3>
		<br /> <input type="hidden" name="option" value="2">  
		<input type="submit" value="View Classes">
		</p>
	</form>


</body>
</html>