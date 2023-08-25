<%@page import="java.util.ArrayList"%>
<%@page import="com.dto.Book"%>
<%@page import="com.dto.Items"%>
<%@page import="java.util.List"%>
<%@page import="com.dto.Customer"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<%
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Booking");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	long id=Integer.parseInt(request.getParameter("Id"));
	Book book=em.find(Book.class, id);
	
	Customer customer=(Customer)session.getAttribute("customer");
	Items it=new Items(book.getBname(),book.getPublisherName(),book.getWriterName(),book.getCategory(),book.getPrice());
	it.setCust(customer);
	
	List<Items> item =customer.getItem();
	if(item.size()>0){
		item.add(it);
	}
	else{
		item=new ArrayList<Items>();
		item.add(it);
	}
	customer.setItem(item);
	
	et.begin();
	em.persist(it);
	em.merge(customer);
	et.commit();
	
	request.getRequestDispatcher("Cart.jsp").forward(request, response);
	response.setContentType("text/html");
	%>
</body>
</html>