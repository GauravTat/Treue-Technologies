package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.dto.Customer;

@WebServlet("/Saveuser")
public class SaveUser extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Booking");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		String Name=req.getParameter("name");
		String Email=req.getParameter("email");
		long Mobno=Integer.parseInt(req.getParameter("number"));
		Date dob=Date.valueOf(req.getParameter("DOB"));
		String pswd=req.getParameter("pswd");
		
		Customer customer=new Customer(Name, Email, Mobno, dob, pswd);
		
		et.begin();
		em.persist(customer);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("<script>alert('Account Created Successfully')</script>");
		
		req.getRequestDispatcher("LoginFrom.jsp").include(req, resp);
		resp.setContentType("text/html");
		
	}
}
