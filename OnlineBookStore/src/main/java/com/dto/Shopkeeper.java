package com.dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Shopkeeper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String Sname;
	private String Email;
	private long Mobno;
	private String pswd;
	private Date DOJ;
	
	@OneToMany
	List<History> history;
	
	@OneToMany
	List<Book> book;

	public Shopkeeper(String sname, String email, long mobno, String pswd, Date dOJ) {
		super();
		Sname = sname;
		Email = email;
		Mobno = mobno;
		this.pswd = pswd;
		DOJ = dOJ;
	}

	public Shopkeeper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public long getMobno() {
		return Mobno;
	}

	public void setMobno(long mobno) {
		Mobno = mobno;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public Date getDOJ() {
		return DOJ;
	}

	public void setDOJ(Date dOJ) {
		DOJ = dOJ;
	}

	public List<History> getHistory() {
		return history;
	}

	public void setHistory(List<History> history) {
		this.history = history;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}
	
}
