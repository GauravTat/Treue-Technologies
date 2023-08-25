<%@page import="com.dto.Land"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
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
<title>Welcome Page</title>
<link rel="stylesheet" href="Css.css">
</head>
<body>
	<%
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Parking");
	EntityManager em=emf.createEntityManager();
	
	User u=(User)session.getAttribute("user");
	%>
	<div class="search2">
		<nav>
		<h1>Welcome,<%=u.getName()%></h1>
		<p><a style="color: black;" href="History.jsp">History</a></p>			
		</nav>
	</div>
	<div class="div-3">
		<form action="Interface.jsp">
		<p>Enter Location name</p>
		<input type="text" name="Location" placeholder="Pune" >
		<input type="submit" value="Search" class="sub">
		</form>
	</div>
	
	<%
		String location=request.getParameter("Location");
		Query qu=em.createQuery("select a from Land a where a.Area=?1");
		qu.setParameter(1,location);
		int c=0;
		
		List<Land> land=qu.getResultList();
		
		if(land.size()>0){
			for(Land l:land){
	%>
	<div class="div-1 s">
		<p>Car prize:<%=l.getCPrice() %></p>
		<p>Two wheeler prize:<%=l.getTPrice() %></p>
		<p>Area:<%=l.getArea() %></p>
		<p>Address:<%=l.getAddress() %></p>
		<h3>Available space:<%=l.getSpace() %></h3>
		<form action="BookCode" method="post">
			<input type="radio" name="choice" value="Car"><span>Car</span>
			<input type="radio" name="choice" value="Two"><span>Two Wheeler</span>
			<input type="text" name="car" placeholder="MH24CQ0000">
			<input type="number" name="id" value="<%=l.getId()%>" hidden>
			<input type="submit" value="Book Now" class="sub" >
		</form>
	</div>
	
	<%
		}}
		else if(c++>=1){
			%>
			<h1>Sorry,No Parking Area is Available</h1>
			<%
		}
	%>
</body>
</html>