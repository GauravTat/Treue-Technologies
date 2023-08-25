package com.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String Name;
	private long Mobno;
	@Column(unique = true)
	private String Email;
	private String pswd;
	
	@OneToMany
	List<History> history;
	
	public User(String name, long mobno, String email, String pswd) {
		super();
		Name = name;
		Mobno = mobno;
		Email = email;
		this.pswd = pswd;
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
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}


	public List<History> getHistory() {
		return history;
	}


	public void setHistory(List<History> history) {
		this.history = history;
	}
	
	
}
