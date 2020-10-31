package com.capgemini.admin.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.admin.entity.Book;
import com.capgemini.admin.entity.Review;
import com.capgemini.admin.exceptions.BookAlreadyExists;
import com.capgemini.admin.exceptions.BookNotFound;
import com.capgemini.admin.exceptions.EmptyRepository;


public interface BookService {

	//---------Book CRUD------------
	
	public void addBook(Book b) throws BookAlreadyExists, SQLException;
	public ResponseEntity<?> deleteBook(Integer id) throws BookNotFound;
	public boolean updateBook(Book b) throws ParseException ;
	public List<Book> getAllBooks() throws EmptyRepository;
	public Book findBookById(Integer id) throws BookNotFound;
	
	//------------Review CRUD------------
	
	public void addReview(Review r, Integer id);
	public ResponseEntity<?> deleteReview(Integer id);
	public void updateReview(Review r);
	public List<Review> getAllReviews();
	
	
	
	
}
