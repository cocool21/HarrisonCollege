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
   color: Blue;
   text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Instructor Menu</title>
</head>
<h1>Harrison College</h1>

<h2>Welcome: </h2> 
${teacherid};
<body>

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


</body>
</html>