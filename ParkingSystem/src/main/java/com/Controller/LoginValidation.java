package com.Controller;

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

import com.dto.Admin;
import com.dto.ParkingOwner;
import com.dto.User;




@WebServlet("/Login")
public class LoginValidation extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Parking");
		EntityManager em=emf.createEntityManager();
		
		String email=req.getParameter("email");
		String pswd=req.getParameter("pswd");
		
		Query qu=em.createQuery("select a from User a where a.Email=?1 and a.pswd=?2");
		qu.setParameter(1, email);
		qu.setParameter(2, pswd);
		List<User> user=qu.getResultList();
		
		Query qu1=em.createQuery("select a from Admin a where a.Email=?1 and a.pswd=?2");
		qu1.setParameter(1, email);
		qu1.setParameter(2, pswd);
		List<Admin> admin=qu1.getResultList();
		
		Query qu2=em.createQuery("select a from ParkingOwner a where a.Email=?1 and a.pswd=?2");
		qu2.setParameter(1, email);
		qu2.setParameter(2, pswd);
		List<ParkingOwner> po=qu2.getResultList();
		
		if(user.size()>0) {
			User u=user.get(0);
			HttpSession hs=req.getSession();
			hs.setAttribute("user", u);
			
			req.getRequestDispatcher("Interface.jsp").forward(req, resp);
			resp.setContentType("text/html");
		}
		else if(po.size()>0) {
			ParkingOwner p=po.get(0);
			if(p.getStatus().equalsIgnoreCase("active")) {
				HttpSession hs=req.getSession();
				hs.setAttribute("po", p);
				
				req.getRequestDispatcher("Parking.jsp").forward(req, resp);
				resp.setContentType("text/html");
			}
			else {
				PrintWriter pw=resp.getWriter();
				pw.write("<script>alert('your account is block')</script>");
				
				req.getRequestDispatcher("LoginForm.jsp").include(req, resp);
				resp.setContentType("text/html");
			}
		}
		else if(admin.size()>0) {
			Admin a=admin.get(0);
			HttpSession hs=req.getSession();
			hs.setAttribute("admin", a);
			
			req.getRequestDispatcher("AdminOption.jsp").forward(req, resp);
			resp.setContentType("text/html");
		}
		else {
			PrintWriter pw=resp.getWriter();
			pw.write("<script>alert('User Not Found')</script>");
			
			req.getRequestDispatcher("LoginForm.jsp").include(req, resp);
			resp.setContentType("text/html");
		}
	}
}
