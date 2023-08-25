package com.dto;

import javax.persistence.*;

@Entity
public class History {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private int TransctionId;
	private String Bname;
	private String publisherName;
	private String WriterName;
	private String Category; 
	private double price;
	
	@ManyToOne
	Shopkeeper shopkeeper;
	
	@ManyToOne
	Customer customer;
	

	public History(String bname, String publisherName, String writerName, String category,double price,int TransctionId) {
		this.Bname = bname;
		this.publisherName = publisherName;
		this.WriterName = writerName;
		this.Category = category;
		this.price = price;
		this.TransctionId=TransctionId;
	}

	public History() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public int getTransctionId() {
		return TransctionId;
	}

	public void setTransctionId(int transctionId) {
		TransctionId = transctionId;
	}

	public Shopkeeper getShopkeeper() {
		return shopkeeper;
	}

	public void setShopkeeper(Shopkeeper shopkeeper) {
		this.shopkeeper = shopkeeper;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getBname() {
		return Bname;
	}

	public void setBname(String bname) {
		Bname = bname;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getWriterName() {
		return WriterName;
	}

	public void setWriterName(String writerName) {
		WriterName = writerName;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
}