package com.dto;

import javax.persistence.*;

@Entity
public class RateReview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id; 
	private int quality;
	private int liked;
	private int Overall;
	private String Review;
	
	@ManyToOne
	Book book;

	public RateReview(int quality, int liked, int overall, String review) {
		super();
		this.quality = quality;
		this.liked = liked;
		Overall = overall;
		Review = review;
	}

	public RateReview() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}


	public String getReview() {
		return Review;
	}

	public void setReview(String review) {
		Review = review;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public int getLike() {
		return liked;
	}

	public void setLike(int paper) {
		liked = paper;
	}

	public int getOverall() {
		return Overall;
	}

	public void setOverall(int overall) {
		Overall = overall;
	}
	
	
}
