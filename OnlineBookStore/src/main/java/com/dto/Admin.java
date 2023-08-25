package com.dto;

import java.util.List;

import javax.persistence.*;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String Name;
	private String Email;
	private String pswd;
	
	@OneToMany
	List<Shopkeeper> shopkeeper;
	
	public Admin(long id, String name, String email, String pswd) {
		super();
		Id = id;
		Name = name;
		Email = email;
		this.pswd = pswd;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public List<Shopkeeper> getShopkeeper() {
		return shopkeeper;
	}

	public void setShopkeeper(List<Shopkeeper> shopkeeper) {
		this.shopkeeper = shopkeeper;
	}
	
	
}
