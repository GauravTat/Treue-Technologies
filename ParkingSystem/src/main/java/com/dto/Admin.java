package com.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String Name;
	@Column(unique = true)
	private String Email;
	private String pswd;
	
	@OneToMany
	List<ParkingOwner> po;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String name, String email, String pswd) {
		super();
		Name = name;
		Email = email;
		this.pswd = pswd;
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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public List<ParkingOwner> getPo() {
		return po;
	}

	public void setPo(List<ParkingOwner> po) {
		this.po = po;
	}

	
	
}
