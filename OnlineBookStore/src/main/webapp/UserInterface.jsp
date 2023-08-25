<%@page import="com.dto.Book"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="com.dto.Customer"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="com.dto.Book"%>
<%@page import="javax.persistence.Query"%>
<%@page import="java.util.List"%>
<%@page import="com.dto.Customer"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Page</title>
<link rel="stylesheet" href="Css.css">
</head>
<body>
	 <%
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Booking");
	EntityManager em=emf.createEntityManager();
	
	Customer customer=(Customer)session.getAttribute("customer");
	%>
	
	<div class="Search-2">
	<h1>Welcome, <%=customer.getName() %></h1>
		<nav style="height: 3%;">
			<p style="padding-left: 60px;width: 100px;"><a href="Cart.jsp">Cart</a></p>
			<p><a href="History.jsp">Buying History</a></p>
		</nav>
		<form action="UserInterface.jsp">
			<p>Search Here</p>
			<input type="text" name="name" placeholder="Name of book">
			<span>OR</span>
			<input type="text" name="category" placeholder="Category">
			<input type="submit" value="Search">
		</form>
	</div>
	<%
		String Name=request.getParameter("name");
		String Cat=request.getParameter("category");
		
		if(Name!=null){
			Query qu=em.createQuery("select a from Book a where a.Bname=?1");
			qu.setParameter(1, Name);
			List<Book> book=qu.getResultList();
			
			if(book.size()>0){
				for(Book b:book){
					if(b.getStock()!=0){
				%>
			<div>
				<div class="contain">
					<h2>Book Name:<%=b.getBname() %></h2>
					<p>Publisher Name:<%=b.getPublisherName() %></p>
					<p>Writer Name:<%=b.getWriterName() %></p>
					<p>Category:<%=b.getCategory() %></p>
					<p>Stock:<%=b.getStock() %></p>
					<p>Price:<%=b.getPrice() %></p>
					<p class="anchor"><a href="AddCartCode.jsp?Id=<%=b.getId()%>">Add to Cart</a></p>
					<p class="anchor"><a href="BookCode.jsp?Id=<%=b.getId()%>">Buy Now</a></p>
				</div>
			</div>
				<% 
					}
				}
			}
			else{
				%>
				<h2>Sorry No Books Available</h2>
				<%
			}
		}
		else if(Cat!=null){
			Query qu=em.createQuery("select a from Book a where a.Category=?1");
			qu.setParameter(1, Cat);
			List<Book> book=qu.getResultList();
		
		if(book.size()>0){
			for(Book b:book){
				//if(b.getStock()!= 0){
			%>
		<div>
			<div class="contain">
				<h2>Book Name:<%=b.getBname() %></h2>
				<p>Publisher Name:<%=b.getPublisherName() %></p>
				<p>Writer Name:<%=b.getWriterName() %></p>
				<p>Category:<%=b.getCategory() %></p>
				<p>Stock:<%=b.getStock() %></p>
				<p>Price:<%=b.getPrice() %></p>
				<p class="anchor"><a href="AddCartCode.jsp?Id=<%=b.getId()%>">Add to Cart</a></p>
				<p class="anchor"><a href="BookCode.jsp?Id=<%=b.getId()%>">Buy Now</a></p>
			</div>
		</div>
			<% 
				//}
			}
		}
		else{
			%>
			<h2>Sorry No Books Available</h2>
			<%
		}
	}
	%>
	
	
</body>
</html>