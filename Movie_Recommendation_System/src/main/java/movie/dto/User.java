package movie.dto;

import java.util.List;

import javax.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String Name;
	private long MobNo;
	private String Email;
	private String Pswd;
	
	@ManyToOne
	Movie movie;
	
	@OneToMany
	List<SearchHistory> sh;

	public User(String name, long mobNo, String email, String pswd) {
		super();
		Name = name;
		MobNo = mobNo;
		Email = email;
		Pswd = pswd;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public long getMobNo() {
		return MobNo;
	}

	public void setMobNo(long mobNo) {
		MobNo = mobNo;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPswd() {
		return Pswd;
	}

	public void setPswd(String pswd) {
		Pswd = pswd;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public List<SearchHistory> getSh() {
		return sh;
	}

	public void setSh(List<SearchHistory> sh) {
		this.sh = sh;
	}
	
	
}
