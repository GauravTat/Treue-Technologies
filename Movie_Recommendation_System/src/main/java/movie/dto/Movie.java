package movie.dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String MovieName;
	private String Genre;
	private Date DateOfLaunch;
	private String Quality;
	
	@OneToMany
	List<User> user;
	
	@OneToMany
	List<RateReview> rate;

	public Movie(String movieName, String genre, Date dateOfLaunch,String quality) {
		super();
		MovieName = movieName;
		Genre = genre;
		DateOfLaunch = dateOfLaunch;
		Quality = quality;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMovieName() {
		return MovieName;
	}

	public void setMovieName(String movieName) {
		MovieName = movieName;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public Date getDateOfLaunch() {
		return DateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		DateOfLaunch = dateOfLaunch;
	}

	public String getQuality() {
		return Quality;
	}

	public void setQuality(String quality) {
		Quality = quality;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<RateReview> getRate() {
		return rate;
	}

	public void setRate(List<RateReview> rate) {
		this.rate = rate;
	}
	
	
	
}
