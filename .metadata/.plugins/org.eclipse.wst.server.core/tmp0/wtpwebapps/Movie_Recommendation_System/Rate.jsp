<%@page import="movie.dto.Movie"%>
<%@page import="javax.persistence.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Css.css">
<title>Rate</title>
</head>
<body>
	<%
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Movie");
		EntityManager em=emf.createEntityManager();
		
		long id=Integer.parseInt(request.getParameter("Id"));
		Movie movie=em.find(Movie.class, id);
		
	%>
	<div class="rate">
			<form action="Review" method="post"><br>
				<p>Do you Like Action</p>
				<input type="number" name="id" 	value=<%=movie.getId()%> hidden>
				<input type="radio" name="like" value="0"><span>0</span>
				<input type="radio" name="like" value="1"><span>1</span>
				<input type="radio" name="like" value="2"><span>2</span>
				<input type="radio" name="like" value="3"><span>3</span>
				<input type="radio" name="like" value="4"><span>4</span>
				<input type="radio" name="like" value="5"><span>5</span>
				<p>MirchMasala</p>
				<input type="radio" name="mirchmasala" value="0"><span>0</span>
				<input type="radio" name="mirchmasala" value="1"><span>1</span>
				<input type="radio" name="mirchmasala" value="2"><span>2</span>
				<input type="radio" name="mirchmasala" value="3"><span>3</span>
				<input type="radio" name="mirchmasala" value="4"><span>4</span>
				<input type="radio" name="mirchmasala" value="5"><span>5</span>
				<p>FeedBack:</p>
				<input type="text" name="review" placeholder="Feedback" class="review">
				<input type="submit" class="sub">
			</form>
		</div>
</body>
</html>