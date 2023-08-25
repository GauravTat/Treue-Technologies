package movie.dto;

import javax.persistence.*;

@Entity
public class RateReview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int Action;
	private int Mirchmasala;
	private String Feedback;
	
	@ManyToOne
	Movie movie;

	public RateReview(int action, int mirchmasala, String feedback) {
		super();
		Action = action;
		Mirchmasala = mirchmasala;
		Feedback = feedback;
	}

	public RateReview() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAction() {
		return Action;
	}

	public void setAction(int action) {
		Action = action;
	}

	public int getMirchmasala() {
		return Mirchmasala;
	}

	public void setMirchmasala(int mirchmasala) {
		Mirchmasala = mirchmasala;
	}

	public String getFeedback() {
		return Feedback;
	}

	public void setFeedback(String feedback) {
		Feedback = feedback;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	

}
