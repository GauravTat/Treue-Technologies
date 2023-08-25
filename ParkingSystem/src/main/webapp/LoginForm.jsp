<%@page import="com.dto.Admin"%>
<%@page import="com.dto.ParkingOwner"%>
<%@page import="com.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginForm</title>
<link rel="stylesheet" href="Css.css">
</head>
<body>
<%
	User user=(User)session.getAttribute("user");
	Admin admin=(Admin)session.getAttribute("admin");
	ParkingOwner po=(ParkingOwner)session.getAttribute("po");
	if (user==null || admin==null || po==null){
%>
	<div class="div-1">
		<h1>Login</h1>
		<form action="Login" method="get">
			<input type="text" placeholder="Email@gmail.com" name="email">
			<input type="password" placeholder="*****" name="pswd">
			<input type="submit" value="Log in" class="sub">
		</form>
		
		<p>Need Account : <a href="CreateAccUser.html">Create</a></p>
		<p>Land Owner want to give Land for Parking:<br><a href="ParkingOwnerCreateAcc.html">Click to Register</a></p>
	</div>
	
	<%
	}
	else{
		request.getRequestDispatcher("Interface.jsp").forward(request, response);
		response.setContentType("text/html");
	}
	%>
</body>
</html>