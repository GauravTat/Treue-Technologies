package movie.dto;

import javax.persistence.*;

@Entity
public class SearchHistory {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String search;
	 
	 @ManyToOne
	 User user;

	 
	public SearchHistory(String search, User user) {
		super();
		this.search = search;
		this.user = user;
	}

	public SearchHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	 
	 
}
