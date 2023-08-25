<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="java.util.ArrayList"%>
<%@page import="movie.dto.SearchHistory"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="movie.dto.Movie"%>
<%@page import="movie.dto.User"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="Css.css">
</head>
<body>
<%!User user; %>
	<%
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Movie");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		user=(User)session.getAttribute("user");
		Query qu=em.createQuery("select a from Movie a");
		List<Movie> movie=qu.getResultList();
		
	%>
	<div>
		<div class="search">
		<h1>Welcome, <%=user.getName() %></h1>
		<lable for="mydropdown" style="color:white;">Genre:</lable>
		<select id="mydropdown" onchange="window.location.href=this.value;">
		 	<option value="" selected disabled>Select an Genre</option>
			 <option value="Search.jsp?Genre=Action">Action</option>
			 <option value="Search.jsp?Genre=Comedy">Comedy</option>
			 <option value="Search.jsp?Genre=Drama">Drama</option>
			 <option value="Search.jsp?Genre=Thriller">Thriller</option>
			 <option value="Search.jsp?Genre=Adventure">Adventure</option>
			 <option value="Search.jsp?Genre=Romance">Romance</option>
		</select>
		<form action="Search.jsp">
			<input type="text" name="Mname" placeholder="Name of Movie">
			<input type="submit" value="Search">
		</form>
		</div>
	</div>
	<%
		List<SearchHistory> sh=user.getSh();
		if(sh.size()>0){
			for(int i=0;i<sh.size();i++){
				SearchHistory s=sh.get(i);
				Query qu2=em.createQuery("select a from Movie a where a.MovieName=?1");
				qu2.setParameter(1, s.getSearch());
				
				List<Movie> hisMovie=qu2.getResultList();
				
				if(hisMovie.size()>0){
					for(Movie m:hisMovie){
						%>
					<div class="div-1 box">
						<h1><%=m.getMovieName() %></h1>
						<p><%=m.getDateOfLaunch() %></p>
						<p><%=m.getQuality() %></p>
						<p class="anchor"><a href="Rate.jsp?Id=<%=m.getId()%>">Give a rating</a></p>
					</div>
						<%
					}
				}
			}
		}
	%>
	
	
</body>
</html>