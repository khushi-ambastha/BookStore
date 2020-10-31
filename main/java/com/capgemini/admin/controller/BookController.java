package com.capgemini.admin.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.admin.entity.Book;
import com.capgemini.admin.entity.Review;
import com.capgemini.admin.exceptions.BookAlreadyExists;
import com.capgemini.admin.exceptions.BookNotFound;
import com.capgemini.admin.exceptions.EmptyRepository;
import com.capgemini.admin.service.BookService;



/**
 * The BookContoller class
 * @author Khushi
 *
 */
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("BookStore/admin")
public class BookController {

	org.slf4j.Logger logger = LoggerFactory.getLogger(BookController.class);	
	
	@Autowired
	private BookService bookservice;
	
	
	/**
	 * This is the add book method 
	 * @param Book object
	 * @return ResponseEntity returns the response body with Http status 
	 * @throws SQLException the SQL exception is thrown
	 * @throws BookAlreadyExists exception 
	 */
	
	@RequestMapping(value="addBook")
	public ResponseEntity<?> addBook(@RequestBody Book book) throws BookAlreadyExists, SQLException
	{
		logger.trace("Add Book method working..");
		
		
		
		try{
			bookservice.addBook(book);
		}catch(Exception e)
		{
			//return new ResponseEntity<>("Book present",HttpStatus.CONFLICT);
			throw new BookAlreadyExists("Book already present");
			
		} 
		return new ResponseEntity<>("Book Added",HttpStatus.ACCEPTED);
		
		
	}
	
	/**
	 * This delete book method will delete the book with the given ID
	 * @param bookid the id of the book
	 * @return ResponseEntity returns the response body with Http status 
	 * @throws BookNotFound exception
	 * 
	 */
	@DeleteMapping(value="deleteBook/{bookid}")
	public ResponseEntity<?> deleteBook(@PathVariable String bookid) throws BookNotFound
	{
		logger.trace("deleteBook method is working..");
		int id=Integer.parseInt(bookid);
		
		return bookservice.deleteBook(id);
		
	}
	
	/**
	 * This method is used to get the list of all books
	 * @return the list of books
	 * @throws EmptyRepository exception is if the repository is empty
	 */
	@GetMapping(value="getBookList")
	public List<Book> getBookList() throws EmptyRepository{
		logger.trace("getBookList method is working");
		return bookservice.getAllBooks();
	}
	
	/**
	 * This method is used to get the book details by its ID
	 * @param bookid the id of the book
	 * @return Book object
	 * @throws BookNotFound exception
	 */
	
	@GetMapping(value="getBookByID/{bookid}")
	public Book getBookByID(@PathVariable String bookid) throws BookNotFound {
		logger.trace("getBookByID method is working..");
		int id= Integer.parseInt(bookid);
		return bookservice.findBookById(id);
	}
	
	/**
	 * This is method is used to update the book details
	 * @param book object
	 * @return String message
	 * @throws ParseException exception
	 */
	@RequestMapping(value="updateBook")
	public String updateBook(@RequestBody Book book) throws ParseException
	{
		logger.trace("updateBook method is working..");
		if(bookservice.updateBook(book)==true)
		return "Book Updated";
		else
			return "Book not updated";
	}
	
	/**
	 * This method is used to add the review of a book
	 * @param review object 
	 * @param bookid the id of the book
	 * @return String value which contains the message 
	 */
	@RequestMapping(value="addReview/{bookid}")
	public String addReview(@RequestBody Review review,@PathVariable String bookid)
	{
		logger.trace("aadReview method is working..");
		int id= Integer.parseInt(bookid);
		bookservice.addReview(review,id);
		return "Review added";
	}
	
	/**
	 * This method is used to delete the review with the given ID
	 * @param reviewId the id of the review
	 * @return ResponseEntity returns response body 
	 */
	@DeleteMapping(value="deleteReview/{reviewId}")
	public ResponseEntity<?> deleteReview(@PathVariable String reviewId)
	{
		logger.trace("deleteReview method is working..");
		int id= Integer.parseInt(reviewId);
		return bookservice.deleteReview(id);
	}
	
	/**
	 * This method is used to update the review.
	 * @param Review object
	 * @return String message
	 */
	@RequestMapping(value="updateReview")
	public String updateReview(Review r)
	{
		logger.trace("updateReview method is working..");
		bookservice.updateReview(r);
		return "Review updated";
	}
	/**
	 * This method is used to get all reviews.
	 * @return the list of reviews
	 */
	
	@GetMapping(value="getAllReviews")
	public List<Review> getallReviews(){
		logger.trace("getAllReview method is working..");
		return bookservice.getAllReviews();
	}
	/**
	 * This method is used to get the review by BookId.
	 * @param bookid the id of the book
	 * @return list of reviews of a book
	 * @throws BookNotFound exception
	 */
	@GetMapping(value="getReviewsByBookId/{bookid}")
	public List<Review> getReviews(@PathVariable String bookid) throws BookNotFound{
		logger.trace("getReviewsByBookId method is working..");
		int id= Integer.parseInt(bookid);
		
		return bookservice.findBookById(id).getReviews();
		
	}

}
