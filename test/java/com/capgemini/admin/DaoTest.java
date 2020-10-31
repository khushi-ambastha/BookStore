package com.capgemini.admin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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

import com.capgemini.admin.dao.AdminDao;
import com.capgemini.admin.entity.Book;
import com.capgemini.admin.exceptions.BookAlreadyExists;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringBootTest
public class DaoTest {

	@Autowired
	private AdminDao admindao;
	
	@BeforeAll
	static void setUpBeforeClass() {
		System.out.println("All test cases for Dao layer starting...");
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
		admindao.addBook(b);
		List<Book> books=admindao.getAllBooks();
		assertEquals(1, books.size());
		
		assertEquals(b.getTitle(), books.get(0).getTitle());
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
		admindao.updateBook(b);
		List<Book> books=admindao.getAllBooks();
		assertEquals(1, books.size());
		
		assertEquals(b.getTitle(), books.get(0).getTitle());
	}
	
	@Test
	public void testfindAllBooks() {
		assertNotEquals("No books found", admindao.getAllBooks());
	}
		
	@Test
	public void testfindBookById() {
		assertNotNull(admindao.findBookById(1));
	}
	
	@Test
	public void testzdeleteBook() {
		admindao.deleteBook(1);
		List<Book> books=admindao.getAllBooks();
		assertEquals(0,books.size());
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
