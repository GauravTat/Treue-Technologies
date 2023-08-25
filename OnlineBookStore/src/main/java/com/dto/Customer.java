package com.dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String Name;
	@Column(unique = true)
	private String Email;
	private long MobNo;
	private Date DOB;
	private String pswd;
	
	@OneToMany
	List<History> history;
	
	@OneToMany
	List<Items> item;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String email, long mobNo, Date dOB, String pswd) {
		super();
		Name = name;
		Email = email;
		MobNo = mobNo;
		DOB = dOB;
		this.pswd = pswd;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
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

	public long getMobNo() {
		return MobNo;
	}

	public void setMobNo(long mobNo) {
		MobNo = mobNo;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
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

	public List<Items> getItem() {
		return item;
	}

	public void setItem(List<Items> item) {
		this.item = item;
	}
	
}
