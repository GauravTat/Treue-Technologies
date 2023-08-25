<%@page import="com.dto.Land"%>
<%@page import="java.util.List"%>
<%@page import="com.dto.History"%>
<%@page import="com.dto.ParkingOwner"%>
<%@page import="com.dto.User"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>History</title>
<link rel="stylesheet" href="Css.css">
</head>
<body>
	<%
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Parking");
	EntityManager em=emf.createEntityManager();
	
	User user=(User)session.getAttribute("user");
	ParkingOwner po=(ParkingOwner)session.getAttribute("po");
	
	if(user != null){
		List<History> history=user.getHistory();
		int c=0;
		%>
		<table cellpadding=0 cellspacing=35>
			<tr>
				<th>Sr.No.</th>
				<th>transaction id</th>
				<th>Price</th>
				<th>Area</th>
				<th>Address</th>
				<th>Vehicle No.</th>
			</tr>
		<% 
		for(History h:history){
			%>
			<tr>
				<td><%=++c %></td>
				<td><%=h.getId() %></td>
				<td><%=h.getPrice() %></td>
				<td><%=h.getArea() %></td>
				<td><%=h.getAddress() %></td>
				<td><%=h.getCarNo() %></td>
			</tr>
			</table>
			<% 
		}
	}
	else{
		int c=0;
		List<History> history=po.getHistory();
		%>
		<table cellpadding=0 cellspacing=35>
			<tr>
				<th>Sr.No.</th>
				<th>transaction id</th>
				<th>Price</th>
				<th>Area</th>
				<th>Address</th>
				<th>Vehicle No.</th>
			</tr>
		<% 
		for(History h:history){
			%>
			<tr>
				<td><%=++c %></td>
				<td><%=h.getId() %></td>
				<td><%=h.getPrice() %></td>
				<td><%=h.getArea() %></td>
				<td><%=h.getAddress() %></td>
				<td><%=h.getCarNo() %></td>
			</tr>
		</table>
			<% 
		}
	}
	
	
	%>
</body>
</html>