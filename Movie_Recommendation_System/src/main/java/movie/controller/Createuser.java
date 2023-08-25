package movie.controller;

import java.io.IOException;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.dto.User;

@WebServlet("/Saveuser")
public class Createuser extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Movie");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		String Name=req.getParameter("name");
		String Email=req.getParameter("email");
		long Mobno=Integer.parseInt(req.getParameter("number"));
		String pswd=req.getParameter("pswd");
		
		User user=new User(Name, Mobno, Email, pswd);
		
		et.begin();
		em.persist(user);
		et.commit();
		
		req.getRequestDispatcher("LoginForm.html").forward(req, resp);
		resp.setContentType("text/html");
	}
}
