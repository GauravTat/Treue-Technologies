package movie.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import movie.dto.User;

@WebServlet("/Login")
public class LoginValidation extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String pswd=req.getParameter("pass");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Movie");
		EntityManager em=emf.createEntityManager();
		
		Query qu=em.createQuery("select a from User a where a.Email=?1 and a.Pswd=?2");
		qu.setParameter(1, email);
		qu.setParameter(2, pswd);
		List<User> user=qu.getResultList();
		
		if(user.size()>0) {
			User u=user.get(0);
			HttpSession hs=req.getSession();
			hs.setAttribute("user", u);
			
			req.getRequestDispatcher("UserInterface.jsp").forward(req, resp);
			resp.setContentType("text/html");
		}
		else {
			PrintWriter pw=resp.getWriter();
			pw.write("<script>alert('No user is Found')</script>");
			
			req.getRequestDispatcher("LoginForm.html").include(req, resp);
			resp.setContentType("text/html");
		}
	}
}
