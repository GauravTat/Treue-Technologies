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
import com.dto.Customer;
import com.dto.Shopkeeper;

@WebServlet("/Login")
public class loginValidation extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Booking");
		EntityManager em=emf.createEntityManager();
		
		String email=req.getParameter("email");
		String pswd=req.getParameter("pass");
		
		Query qu=em.createQuery("select a from Customer a where a.Email=?1 and a.pswd=?2");
		qu.setParameter(1, email);
		qu.setParameter(2, pswd);
		List<Customer> customer=qu.getResultList();
		
		Query qu1=em.createQuery("select a from Shopkeeper a where a.Email=?1 and a.pswd=?2");
		qu1.setParameter(1, email);
		qu1.setParameter(2, pswd);
		List<Shopkeeper> shop=qu1.getResultList();
		
		Query qu2=em.createQuery("select a from Admin a where a.Email=?1 and a.pswd=?2");
		qu2.setParameter(1, email);
		qu2.setParameter(2, pswd);
		List<Admin> admin=qu2.getResultList();
		
		if(customer.size()>0) {
			Customer c=customer.get(0);
			HttpSession hs=req.getSession();
			hs.setAttribute("customer", c);
			
			req.getRequestDispatcher("UserInterface.jsp").forward(req, resp);
			resp.setContentType("text/html");
		}
		else if(shop.size()>0) {
			Shopkeeper sk=shop.get(0);
			HttpSession hs=req.getSession();
			hs.setAttribute("shopkeeper", sk);
			
			req.getRequestDispatcher("ShopInterface.jsp").forward(req, resp);
			resp.setContentType("text/html");
		}
		else if(admin.size()>0) {
			Admin ad=admin.get(0);
			HttpSession hs=req.getSession();
			hs.setAttribute("admin", ad);
			
			req.getRequestDispatcher("AdminInterface.jsp").forward(req, resp);
			resp.setContentType("text/html");
		}
		else {
			PrintWriter pw=resp.getWriter();
			pw.write("<script>alert('No user is Found')</script>");
			
			req.getRequestDispatcher("LoginFrom.jsp").include(req, resp);
			resp.setContentType("text/html");
		}
		
	}
}
