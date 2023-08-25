package com.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Land {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private double Tprice;
	private double Cprice;
	private String Area;
	private int space;
	private String Address;
	
	@ManyToOne
	ParkingOwner po;

	public Land() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Land(double Tprice, double Cprice, String area, String address,int space) {
		super();
		this.Tprice = Tprice;
		this.Cprice = Cprice;
		Area = area;
		Address = address;
		this.space=space;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTPrice() {
		return Tprice;
	}

	public void setTPrice(double Tprice) {
		this.Tprice = Tprice;
	}
	
	public double getCPrice() {
		return Cprice;
	}

	public void setCPrice(double Cprice) {
		this.Cprice = Cprice;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public ParkingOwner getPo() {
		return po;
	}

	public void setPo(ParkingOwner po) {
		this.po = po;
	}

	public double getTprice() {
		return Tprice;
	}

	public void setTprice(double tprice) {
		Tprice = tprice;
	}

	public double getCprice() {
		return Cprice;
	}

	public void setCprice(double cprice) {
		Cprice = cprice;
	}

	public int getSpace() {
		return space;
	}

	public void setSpace(int space) {
		this.space = space;
	}
	
}
