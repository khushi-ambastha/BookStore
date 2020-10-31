
package com.capgemini.admin.entity;

import java.io.Serializable;
import java.text.ParseException;

import java.util.ArrayList;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="BookTable", schema="hr",uniqueConstraints=@UniqueConstraint(columnNames={"title", "isbn"}))
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
public class Book implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int bookID;
	@Column(unique=true)
	private String title;
	private String author;
	private  String description;
	@Column(unique=true)
	private String isbn;
	private String imageUrl;
	private float price;
	private String publishdate;
	private String category;
	
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="bookid")
	@JsonIgnore
	private List<Review> reviews = new ArrayList<Review>();
	
	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) throws ParseException {
		
		this.publishdate =publishdate;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", title=" + title + ", author=" + author + ", description=" + description
				+ ", isbn=" + isbn + ", imageUrl=" + imageUrl + ", price=" + price + ", publishdate=" + publishdate
				+ ", category=" + category + ", reviews=" + reviews + "]";
	}

	
	
	
	

}
