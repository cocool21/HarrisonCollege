<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <style>
h1 {
    color: Red;
    text-align: center;
}

h2{
   color: green;
   text-align: center;
}
</style> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Student Menu Page</title>
</head>
<body>
<<<<<<< HEAD
	
	<%@ include file="Menu.jsp" %>
	<div class="container">

		<div class="panel panel-default">
			<div class="panel-heading">Student Menu</div>
			<div class="panel-body">

				<a href="RegisteredClasses">View Registered Classes</a>
			</div>
			<div class="panel-body">

				<a href="ViewAllCourses">View All Courses</a>
			</div>
			<div class="panel-body">

				<a href="ViewAllClasses">View All Classes</a>
			</div>
			<div class="panel-body">


				<a href="ViewTranscripts">View Transcripts</a>

			</div>
		</div>
	</div>
=======
<h1>Harrison College</h1>

<h2>Student Menu</h2>

<form action="RegisteredClasses" method="post">
 <input type="submit" name="student" value="View Registered Classes" > <br>
</form>
    
    <form action="ViewAllCourses" method="post">
  <input type="submit" name="student" value="View All Courses" > <br>
</form> 
    <form action="ViewAllClasses" method="post">
  <input type="submit" name="student" value="View All Classes" > <br>
</form> 

<form action="ViewTranscripts" method="post">
  <input type="submit" name="student" value="View Transcripts" > <br>
</form> 
<form action="Logout" method="post">
	<input type="submit" value="Logout">
</form>  
>>>>>>> 6708fb33b85ffbb30d1ed856a65bf05d2b08bad4
</body>
</html>