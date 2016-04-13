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
<title>Insert title here</title>
</head>
<body>
	<h3 class="text-success">Harrison College</h3>
	
	<p class="text-danger"> <strong>${message} </strong></p>
	
	
	<table class="table table-bordered table-striped">
		<tr>
			<td>
				<form action="loginServlet" method="post" role="form">
					<div class="form-group">
						<p><b>Existing User</b></p>
						User Name:<br> <input type="text" name="username"><br>
						Password:<br> <input type="text" name="password"><br>
						<br> <input type="submit" value="login">
					</div>
				</form>
			</td>
			<td>
				<form action="SignUpServlet" method="post" role="form">
					<div class="form-group">
						<p><b>New User Sign Up Here!</b></p>
						Name:<br> <input type="text" name="name"><br>
						User Name:<br> <input type="text" name="newusername"><br>
						Password:<br> <input type="text" name="newpassword"><br>
						Major:<br> <select name="major">
							<option value="1">Biology</option>
							<option value="2">Physics</option>
							<option value="3">Math</option>

						</select> <br> Year:<br> <select name="year">
							<option value="Freshman">Freshman</option>
							<option value="Sophomore">Sophomore</option>
							<option value="Junior">Junior</option>
							<option value="Senior">Senior</option>
						</select> <br> <input type="submit" value="Sign Up">
					</div>
				</form>
			</td>

		</tr>
	</table>
</body>
</html>