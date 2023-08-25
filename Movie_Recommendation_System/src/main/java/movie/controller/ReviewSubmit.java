package movie.controller;

import java.io.IOException;
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

import movie.dto.Movie;
import movie.dto.RateReview;

@WebServlet("/Review")
public class ReviewSubmit extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Movie");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		long id=Integer.parseInt(req.getParameter("id"));
		int Action=Integer.parseInt(req.getParameter("like"));
		int Mirch=Integer.parseInt(req.getParameter("mirchmasala"));
		String review=req.getParameter("review");
		
		RateReview rr=new RateReview(Action, Mirch, review);
		
		Movie movie=em.find(Movie.class, id);
		List<RateReview> rre= movie.getRate();
		
		if(rre.size()>0) {
			rre.add(rr);
		}
		else {
			rre =new ArrayList<RateReview>();
			rre.add(rr);
		}
		
		rr.setMovie(movie);
		
		et.begin();
		em.persist(rr);
		em.merge(movie);
		et.commit();
		
		req.getRequestDispatcher("UserInterface.jsp").forward(req, resp);
		resp.setContentType("text/html");
	}
}
