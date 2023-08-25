package com.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Parking")
public class ParkingOwner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String Oname;
	private long Mobno;
	@Column(unique = true)
	private String Email;
	private String pswd;
	private String status;
	
	@OneToMany
	List<Land> land;
	
	@ManyToOne
	Admin admin;
	
	@OneToMany
	List<History> history;

	public ParkingOwner(String oname, long mobno, String email, String pswd,String status) {
		super();
		Oname = oname;
		Mobno = mobno;
		Email = email;
		this.pswd = pswd;
		this.status=status;
	}
	
	public ParkingOwner() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOname() {
		return Oname;
	}

	public void setOname(String oname) {
		Oname = oname;
	}

	public long getMobno() {
		return Mobno;
	}

	public void setMobno(long mobno) {
		Mobno = mobno;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public List<Land> getLand() {
		return land;
	}

	public void setLand(List<Land> land) {
		this.land = land;
	}

	public List<History> getHistory() {
		return history;
	}

	public void setHistory(List<History> history) {
		this.history = history;
	}
	
}
