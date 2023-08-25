<%@page import="java.util.ArrayList"%>
<%@page import="movie.dto.SearchHistory"%>
<%@page import="movie.dto.User"%>
<%@page import="movie.dto.Movie"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
<link rel="stylesheet" href="Css.css">
</head>
<body>
<div>
	<%
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Movie");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		User user=(User)session.getAttribute("user");
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
			<input type="submit" value="Search" class="sub">
		</form>
		</div>
	</div>
	<%
		String Genre=request.getParameter("Genre");
		if(Genre!=null){
			Query qu1=em.createQuery("select a from Movie a where a.Genre=?1");
			qu1.setParameter(1, Genre);
			List<Movie> GenreMovie=qu1.getResultList();
			
			if(GenreMovie.size()>0){
				for(Movie m:GenreMovie){
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
		
		String MName=request.getParameter("Mname");
		if(MName!=null){
			Query qu3=em.createQuery("select b from Movie b where b.MovieName=?1");
			qu3.setParameter(1, MName);
			List<Movie> SearchMovie=qu3.getResultList();
			
			//Adding Search History 
			SearchHistory shistory=new SearchHistory(MName,user);
			List<SearchHistory> sh=user.getSh();
			if(sh.size()>0){
				sh.add(shistory);
			}
			else{
				sh=new ArrayList<SearchHistory>();
				sh.add(shistory);
			}
			user.setSh(sh);
			
			if(SearchMovie.size()>0){
				for(Movie m:SearchMovie){
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
			else{
				%>
			<h2>No Movies Found</h2>
				<%
			}
			et.begin();
			em.persist(shistory);
			em.merge(user);
			et.commit();
		}
	%>
</body>
</html>