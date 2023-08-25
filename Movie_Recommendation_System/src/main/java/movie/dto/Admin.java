package movie.dto;
import javax.persistence.*;

@Entity
public class Admin {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String Name;
	 private String pswd;
	 private String Email;
	 
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String name, String pswd, String email) {
		super();
		Name = name;
		this.pswd = pswd;
		Email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	 
}
