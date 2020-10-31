package com.capgemini.admin;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.admin.controller.BookController;
import com.capgemini.admin.entity.Book;
import com.capgemini.admin.entity.Review;
import com.capgemini.admin.exceptions.BookAlreadyExists;
import com.capgemini.admin.exceptions.BookNotFound;
import com.capgemini.admin.exceptions.EmptyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringBootTest
public class ControllerTest {
	
	@Autowired
	private BookController bookcontoller;
	
	@BeforeAll
	static void setUpBeforeClass() {
		System.out.println("All test cases for Controller layer starting...");
	}
	
	@BeforeEach
	void setup() {
		System.out.println("Test Case Started");
	}

	@Test
	public void testAddBook() throws SQLException, BookAlreadyExists, ParseException {
		Book b = new Book();
		b.setTitle("The vinci code");
		b.setAuthor("Dan Brown");
		b.setCategory("Mystery");
		b.setDescription("Mystery thriller");
		b.setImageUrl("D://book1.jpeg");
		b.setIsbn(" 97803074742");
		b.setPrice(600);
		String date="29-05-2003";
		b.setPublishdate(date);
		//b.setPublishdate(new SimpleDateFormat("dd-MM-yyyy").parse(date));
		
		assertNotNull(bookcontoller.addBook(b));
	
	}
	
	@Test
	public void testUpdateBook() throws ParseException {
		Book b = new Book();
		b.setBookID(1);
		b.setTitle("The vinci code");
		b.setAuthor("Dan Brown");
		b.setCategory("Mystery");
		b.setDescription("Mystery thriller");
		b.setImageUrl("D://book1.jpeg");
		b.setIsbn(" 9780307474278");
		b.setPrice(600);
		String date="29-06-2003";
		//b.setPublishdate(new SimpleDateFormat("dd-MM-yyyy").parse(date));
		b.setPublishdate(date);
		assertNotNull(bookcontoller.updateBook(b));
	}
	
	@Test
	public void testfindAllBooks() throws EmptyRepository {
		assertNotNull("No books found", bookcontoller.getBookList());
	}
	
	@Test
	public void testfindBookById() throws BookNotFound {
		assertNotNull(bookcontoller.getBookByID("1"));
	}
	
	@Test
	public void testAddReview() {
		Review rev= new Review();
		rev.setRating(2);
		rev.setHeadline("Suspense");
		rev.setComment("Brown talented piece of work");
		
		assertNotNull(bookcontoller.addReview(rev, "1"));
	}
	
	@Test
	public void testfindAllReviews() {
		assertNotNull("No reviews found", bookcontoller.getallReviews());
	}
	
	@Test
	public void testfindReviewByBookId() throws BookNotFound {
		assertNotNull(bookcontoller.getReviews("1"));
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("Test Case Over");	
	}
	
	@AfterAll
	static void setUpAfterClass() {
		System.out.println("All test cases ended.");
	}

	

}
