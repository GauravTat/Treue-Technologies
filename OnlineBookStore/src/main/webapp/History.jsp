<%@page import="java.util.List"%>
<%@page import="com.dto.*"%>
<%@page import="javax.persistence.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<link rel="stylesheet" href="Css.css">
</head>
<body>
	<%
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Booking");
	EntityManager em=emf.createEntityManager();
	
	Customer customer=(Customer)session.getAttribute("customer");
	List<History> history=customer.getHistory();
	if(history.size()>0){
		%>
	<table cellpadding=0 cellspacing=35>
		<tr>
			<th>Transaction No</th>
			<th>Book Name</th>
			<th>Publisher Name</th>
			<th>Writer Name</th>
			<th>Price</th>
			<th>Give rating/Review</th>
		</tr>
		<%
		for(History h:history){
		%>
		<tr>
			<td><%=h.getTransctionId() %></td>
			<td><%=h.getBname() %></td>
			<td><%=h.getPublisherName() %></td>
			<td><%=h.getWriterName() %></td>
			<td><%=h.getPrice() %></td>
			<td><p style="width: 95px;"><a href="Rate.jsp?Id=<%=h.getId()%>">Rate/Review</a></p></td>
		</tr>
	</table>
		<%
		}
	}
	else{
	%>
	<h2 class="table-h2">No Book Purchase <a href="UserInterface.jsp">buy Now</a></h2>
	<%} %>
	
	
</body>
</html>