<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
<link rel="stylesheet" href="Css.css">
</head>
<body>
	<div class="div-1 Login-div login">
		<form action="Login" method="get">
			<input type="email" name="email" placeholder="xyz@gmail.com">
			<input type="password" name="pass" placeholder="***********">
			<input type="submit" value="Log In" class="sub">
		</form>
		<p>Don't Have Account <a href="CreateUser.html">Create Account</a></p>
		<p>Register Agency <a href="CreateShop.html">Click</a></p>
	</div>
</body>
</html>