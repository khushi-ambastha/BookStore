package com.capgemini.admin.dao;

import java.text.ParseException;
import java.util.List;

import com.capgemini.admin.entity.Book;
import com.capgemini.admin.entity.Review;


public interface AdminDao {
	
	  
	//---------Book CRUD------------
	
		public void addBook(Book b) ;
		public void deleteBook(Integer id);
		public boolean updateBook(Book b) throws ParseException ;
		public List<Book> getAllBooks() ;
		public Book findBookById(Integer id) ;
		
		//------------Review CRUD------------
		
		public void addReview(Review r, Integer id);
		public void deleteReview(Integer id);
		public void updateReview(Review r);
		public List<Review> getAllReviews();

}
