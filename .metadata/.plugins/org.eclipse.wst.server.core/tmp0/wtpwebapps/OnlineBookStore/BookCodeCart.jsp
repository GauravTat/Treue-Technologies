<%@page import="com.dto.Items"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Random"%>
<%@page import="com.dto.Shopkeeper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.dto.History"%>
<%@page import="com.dto.Customer"%>
<%@page import="com.dto.Book"%>
<%@page import="javax.persistence.*"%>
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
	
	String Bname=request.getParameter("Bname");
	long id=Integer.parseInt(request.getParameter("Id"));
	
	//Create Random number
	Random rand = new Random();
	int No=rand.nextInt(100000);
	
	Customer customer=(Customer)session.getAttribute("customer");
	
	Query qu=em.createQuery("select a from Book a where a.Bname=?1");
	qu.setParameter(1, Bname);
	List<Book> b=qu.getResultList();
	Book book=b.get(0);
	
	Shopkeeper shop=book.getShopkeeper();
	book.setStock(book.getStock()- 1);
	
	//removing product from Cart After Buying
	Items item=em.find(Items.class, id);
	
	History his=new History(book.getBname(),book.getPublisherName(),book.getWriterName(),book.getCategory(),book.getPrice(),No);
	his.setCustomer(customer);
	his.setShopkeeper(shop);
	
	List<History> history=customer.getHistory();
	if(history.size()>0){
		history.add(his);
	}
	else{
		history=new ArrayList<History>();
		history.add(his);
	}
	customer.setHistory(history);
	
	List<History> history1=shop.getHistory();
	if(history1.size()>0){
		history1.add(his);
	}
	else{
		history1=new ArrayList<History>();
		history1.add(his);
	}
	shop.setHistory(history1);
	
	et.begin();
	em.persist(his);
	em.remove(item);
	em.merge(customer);
	em.merge(shop);
	et.commit();
	
	PrintWriter pw=response.getWriter();
	pw.write("<script>alert('Booked Successfully')</script>");
	
	request.getRequestDispatcher("UserInterface.jsp").include(request, response);
	response.setContentType("text/html");
	
	%>
</body>
</html>