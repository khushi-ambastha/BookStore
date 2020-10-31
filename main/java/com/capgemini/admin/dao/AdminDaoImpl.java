package com.capgemini.admin.dao;

import java.text.ParseException;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.capgemini.admin.entity.Book;
import com.capgemini.admin.entity.Review;

/**
 * This is the Dao class. It performs CRUD operations.
 * @author Khushi
 *
 */
@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {


	@Autowired
	private BookRepository bookrepo;
	
	@Autowired
	private ReviewRepository reviewRepo;
	
	
	/**
	 * This  method adds the book to the repository.
	 * @param Book object
	 * 
	 */
	@Override
	public void addBook(Book b) {
		// TODO Auto-generated method stub
		
            bookrepo.save(b);
		
	}

	/**
	 * This method deletes the book from the repository.
	 * @param the bookid
	 */
	@Override
	public void deleteBook(Integer id) {
		// TODO Auto-generated method stub
		bookrepo.deleteById(id);

	}

	/**
	 * This method updates the book present in the repository.
	 * @param Book object
	 * @throws ParseException 
	 * 
	 */
	@Override
	public boolean updateBook(Book b) throws ParseException  {
		boolean exists =bookrepo.existsById(b.getBookID());
		System.out.println(exists);
        Book bookdetails;
		if(exists==true) {
		bookdetails=null;
        bookdetails = findBookById(b.getBookID());
        if(b.getTitle()!=null)
        	bookdetails.setTitle(b.getTitle());
        if(b.getAuthor()!=null)
        	bookdetails.setAuthor(b.getAuthor());
        if(b.getCategory()!=null)
        	bookdetails.setCategory(b.getCategory());
        if(b.getDescription()!=null)
        	bookdetails.setDescription(b.getDescription());
        if(b.getImageUrl()!=null)
        	bookdetails.setImageUrl(b.getImageUrl());
        if(b.getIsbn()!=null)
        	bookdetails.setIsbn(b.getIsbn());
        if(b.getPrice()!= bookdetails.getPrice())
        	bookdetails.setPrice(b.getPrice());
        if(b.getPublishdate()!=null)
        	bookdetails.setPublishdate(b.getPublishdate());
       
        	System.out.println(bookdetails);
		bookrepo.save(bookdetails);
		return true;
		}
		return false;
		}
		
	

	/**
	 * This method retrieves the book list from the repository
	 * @return List of Book
	 * 
	 */
	@Override
	public List<Book> getAllBooks()  {
	
		
		return bookrepo.findAll();
	}

	/**
	 * This method retrieve the book by the given id from the repository.
	 * @param the book id
	 * 
	 */
	@Override
	public Book findBookById(Integer id)   {
		// TODO Auto-generated method stub
		
		
		return bookrepo.getOne(id);
	}
	/**
	 * This method is used to add the review of a book to the repository
	 * @param Review object
	 * @param the BookId
	 * 
	 */
	@Override
	public void addReview(Review r, Integer id) {
		// TODO Auto-generated method stub
		Book b= new Book();
		b= bookrepo.getOne(id);
		//Review rev= new Review();
		
		reviewRepo.save(r);
		
		List<Review> list = b.getReviews();
		list.add(r);
		b.setReviews(list);
		bookrepo.save(b);
		
	}

	/**
	 * This method is used to delete the review from the repository
	 * @param the review ID
	 * 
	 */
	@Override
	public void deleteReview(Integer id) {
		// TODO Auto-generated method stub
		reviewRepo.deleteById(id);
	}
	 /**
     * This method is used to update the review present in the repository
     * @param Review object
     * 
     */
	@Override
	public void updateReview(Review r) {
		// TODO Auto-generated method stub
		Review reviewdetails= reviewRepo.getOne(r.getReviewID());
		reviewdetails.setRating(r.getRating());
		reviewdetails.setHeadline(r.getHeadline());
		reviewdetails.setComment(r.getComment());
		
		reviewRepo.save(reviewdetails);
	}

	/**
	 * This method is used to retrieve the review list from the repository.
	 * @return list of reviews
	 */
	@Override
	public List<Review> getAllReviews() {
		// TODO Auto-generated method stub
		return reviewRepo.findAll();
	}
}


