package com.capgemini.admin.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.admin.dao.AdminDao;
import com.capgemini.admin.dao.ReviewRepository;
import com.capgemini.admin.entity.Book;
import com.capgemini.admin.entity.Review;
import com.capgemini.admin.exceptions.BookAlreadyExists;
import com.capgemini.admin.exceptions.BookNotFound;
import com.capgemini.admin.exceptions.EmptyRepository;

/**
 * Book Service Class
 * @author Khushi
 *
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private AdminDao admindao;
	  
	
	@Autowired
	private ReviewRepository reviewRepo;
	
	/**
	 * Method - addBook()
	 * @param the Book object
	 * @return ResponseEntity 
	 * 
	 */
	@Override
	public void addBook(Book b) throws BookAlreadyExists,SQLException {
		
		
		admindao.addBook(b);
		
		
		
	}

	/**
	 * @param book id
	 * @throws BookNotFound exception is thrown
	 * @return ResponseEntity 
	 */
	@Override
	public ResponseEntity<?> deleteBook(Integer id) throws BookNotFound {
		// TODO Auto-generated method stub
		if(admindao.findBookById(id)==null) {
			throw new BookNotFound("Book not found");
		}
		else {
		admindao.deleteBook(id);
		return new ResponseEntity<>("Book deleted",HttpStatus.FOUND);
		}
	}

	/**
	 * This method updates the book 
	 * @param the book class reference
	 * @return boolean returns whether book is updated or not
	 * @throws ParseException 
	 */
	@Override
	public boolean updateBook(Book b) throws ParseException  {
		// TODO Auto-generated method stub
		return admindao.updateBook(b);
	}

	/**
	 * This method is used to find all the books present in the repository
	 * @return list of books
	 * @throws EmptyRepository exception is thrown
	 */
	@Override
	public List<Book> getAllBooks() throws EmptyRepository {
		// TODO Auto-generated method stub
		List<Book> books= admindao.getAllBooks();
		if(books.isEmpty())
			throw new EmptyRepository("No Books Present.");
		else
		return books;
	}

	/**
	 * This method is used to find the book by given ID
	 * @param Integer the BookID
	 * @return Book object
	 * @throws BookNotFound exception is thrown
	 */
	@Override
	public Book findBookById(Integer id) throws BookNotFound {
		// TODO Auto-generated method stub
		Book bookdetail = admindao.findBookById(id);
		if(bookdetail==null)
			throw new BookNotFound("Book not found");
		else
		return bookdetail;
	}

	/**
	 * This method is used to add the review of a book
	 * @param Review object
	 * @param the BookId
	 * 
	 */
	@Override
	public void addReview(Review r,Integer id) {
		// TODO Auto-generated method stub
		
		admindao.findBookById(id);
		//Review rev= new Review();
		
		
	}

	/**
	 * This method is used to delete the review.
	 * @param the review ID
	 * @return ResponseEntity returns the response with http status
	 */
	@Override
	public ResponseEntity<?> deleteReview(Integer id) {
		// TODO Auto-generated method stub
		admindao.deleteReview(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
     /**
      * This method is used to update the review
      * @param Review object
      * 
      */
	@Override
	public void updateReview(Review r) {
		// TODO Auto-generated method stub
		reviewRepo.save(r);
	}

	/**
	 * This method is used to get all the reviews
	 * @return list of reviews
	 * 
	 */
	@Override
	public List<Review> getAllReviews() {
		// TODO Auto-generated method stub
		return reviewRepo.findAll();
	}

}
