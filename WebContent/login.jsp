<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>${message}</p>
	<table>
		<tr>
			<td>
				<form action="loginServlet" method="post">
					<p>Existing User</p>
					User Name:<br> <input type="text" name="username"><br>
					Password:<br> <input type="text" name="password"><br>
					<br> <input type="submit" value="login">
				</form>
			</td>
			<td>
				<form action="SignUpServlet" method="post">
					<p>New User Sign Up Here!</p>
					Name:<br> <input type="text" name="name"><br>
					User Name:<br> <input type="text" name="newusername"><br>
					Password:<br> <input type="text" name="newpassword"><br>
					Major:<br> <select name="major">
						<option value="1">Biology</option>
						<option value="2">Physics</option>
						<option value="3">Math</option>

					</select> <br> Year:<br>
					<select name="year">
						<option value="Freshman">Freshman</option>
						<option value="Sophomore">Sophomore</option>
						<option value="Junior">Junior</option>
						<option value="Senior">Senior</option>
					</select> <br> <input type="submit" value="Sign Up">
				</form>
			</td>

		</tr>
	</table>
</body>
</html>