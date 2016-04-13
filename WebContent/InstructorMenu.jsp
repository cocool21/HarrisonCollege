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
<title>Instructor Menu</title>
</head>
<!--  

<h2>Welcome</h2>
${teacherid}-->
<body>
<<<<<<< HEAD
	<%@ include file="Menu.jsp"%>
	<div class="container">

		<div class="panel panel-default">
			<div class="panel-heading">Instructor Menu</div>
			<div class="panel-body">
				<a href="ViewAllCourses">View All Courses</a>
			</div>
			<div class="panel-body">
				<a href="ViewAllClasses">View All Classes</a>
			</div>
			<div class="panel-body">
				<a href="ViewClasses">View Classes</a>
			</div>
			<div class="panel-body">
				<a href="ViewSpreadsheet">View Spreadsheet</a>
			</div>
			
		</div>
	</div>

	
=======

 <form action="ViewAllCourses" method="post">
  <input type="submit" name="instructor" value="View All Courses" > <br>
</form> 

 <form action="ViewAllClasses" method="post">
  <input type="submit" name="instructor" value="View All Classes" > <br>
</form>

 <form action="ViewClasses" method="post">
 <input type="submit" name="instructor" value="View Classes" > <br>  
 
</form>

 <form action="ViewSpreadsheet" method="post">
  <input type="submit" name="instructor" value="View Spreadsheet" > <br>
</form>

<br>
>>>>>>> 1bd557e03a95383145465b9334a29b8106439957

<form action="Logout" method="post">
	<input type="submit" value="Logout">
</form>

</body>
</html>