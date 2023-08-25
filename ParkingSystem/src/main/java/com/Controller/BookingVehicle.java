package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.History;
import com.dto.Land;
import com.dto.ParkingOwner;
import com.dto.User;

@WebServlet("/BookCode")
public class BookingVehicle extends HttpServlet {
	
	History history;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id=Integer.parseInt(req.getParameter("id"));
		String carNo=req.getParameter("car");
		String choice=req.getParameter("choice");
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Parking");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	HttpSession hs=req.getSession();
	User user=(User)hs.getAttribute("user");
	
	Land land=em.find(Land.class, id);
	ParkingOwner po=land.getPo();
	
	land.setSpace(land.getSpace()-1);
	
	
	if(choice.equalsIgnoreCase("Car")) {
		history=new History(carNo,land.getCPrice(),land.getArea(),land.getAddress());
	}
	else if(choice.equalsIgnoreCase("Two")){
		history=new History(carNo,land.getTPrice(),land.getArea(),land.getAddress());
	}
		
	//adding list to user
	List<History> his=user.getHistory();
	if(his.size()>0){
		his.add(history);
	}
	else{
		his=new ArrayList<History>();
		his.add(history);
	}
	
	//adding list to Parking 
	List<History> his1=po.getHistory();
	if(his1.size()>0){
		his1.add(history);
	}
	else{
		his1=new ArrayList<History>();
		his1.add(history);
	}
	
	user.setHistory(his);
	po.setHistory(his1);
	history.setPo(po);
	history.setUser(user);
	
	et.begin();
	em.persist(history);
	em.merge(user);
	em.merge(land);
	em.merge(po);
	et.commit();
	
	PrintWriter pw= resp.getWriter();
	pw.write("<script>alert('Booking Done')</script>");
	
	req.getRequestDispatcher("Interface.jsp").include(req, resp);
	resp.setContentType("text/html");
	}

}
