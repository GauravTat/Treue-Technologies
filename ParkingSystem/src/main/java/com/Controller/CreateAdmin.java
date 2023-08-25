package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.Admin;

@WebServlet("/Admin")
public class CreateAdmin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Parking");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String pswd=req.getParameter("pass");
		
		Admin ad=new Admin(name, email, pswd);
		
		et.begin();
		em.persist(ad);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("<script>alert('Account Created Successfully')</script>");
		
		req.getRequestDispatcher("LoginForm.jsp").include(req, resp);
		resp.setContentType("text/html");
	}
}
