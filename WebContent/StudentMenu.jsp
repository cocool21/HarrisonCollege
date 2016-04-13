<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
h1 {
    color: Red;
    text-align: center;
}

h2{
   color: green;
   text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Menu Page</title>
</head>
<body>
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
</body>
</html>