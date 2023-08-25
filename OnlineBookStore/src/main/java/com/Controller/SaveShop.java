package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.Shopkeeper;

@WebServlet("/CreateShop")
public class SaveShop extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Booking");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		String Name=req.getParameter("name");
		String Email=req.getParameter("email");
		long Mobno=Integer.parseInt(req.getParameter("number"));
		String pswd=req.getParameter("pass");
 
		LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Date DOJ=Date.valueOf(dateObj.format(formatter));
		
		Shopkeeper shopkeeper=new Shopkeeper(Name, Email, Mobno, pswd, DOJ);
		
		et.begin();
		em.persist(shopkeeper);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("<script>alert('Account Created Successfully')</script>");
		
		req.getRequestDispatcher("loginFrom.jsp").include(req, resp);
		resp.setContentType("text/html");
	}
}
