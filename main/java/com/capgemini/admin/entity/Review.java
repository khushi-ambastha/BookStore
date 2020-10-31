package com.capgemini.admin.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookReviews", schema="hr")
public class Review implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int reviewID;
	private int reviewRating;
	private String reviewHeadline;
	private String reviewComment;
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getReviewID() {
		return reviewID;
	}
	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}
	public int getRating() {
		return reviewRating;
	}
	public void setRating(int rating) {
		this.reviewRating = rating;
	}
	public String getHeadline() {
		return reviewHeadline;
	}
	public void setHeadline(String headline) {
		this.reviewHeadline = headline;
	}
	public String getComment() {
		return reviewComment;
	}
	public void setComment(String comment) {
		this.reviewComment = comment;
	}
	@Override
	public String toString() {
		return "Review [reviewID=" + reviewID + ", reviewRating=" + reviewRating + ", reviewHeadline=" + reviewHeadline
				+ ", reviewComment=" + reviewComment + "]";
	}
	
	
	
	
}
