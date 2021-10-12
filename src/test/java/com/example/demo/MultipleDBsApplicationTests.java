package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.book.BookRepository;
import com.example.demo.dao.reader.ReaderRepository;
import com.example.demo.model.book.Book;
import com.example.demo.model.reader.Reader;



@SpringBootTest
class MultipleDBsApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private ReaderRepository readerRepository;
	
	
	private Book book;
	private Reader reader;
	
	@Before
	public void initializeDataObjects() {
		book = new Book();
		book.setBookId(1);
		book.setAuthor("Chander Chauhan");
		book.setBookName("Spring Boot with Multiple Databases");
		book.setIsbn("45698712365");
		
		reader = new Reader();
		reader.setReaderId(book.getBookId());
		reader.setFirstName("Houssam");
		reader.setLastName("EL Mansouri");
	}
	
	@Test
	public void saveBookToBookDB() {
		Book savedBook = bookRepository.save(new Book(1, "Chander Chauhan", "Spring Boot with Multiple Databases", "45698712365"));
		assertTrue(savedBook.getBookName().equals("Spring Boot with Multiple Databases"));
	}
	
	
	@Test
	public void saveReaderToReaderDB() {
		Reader savedReader = readerRepository.save(new Reader(1, "Houssam", "EL Mansouri"));
		assertTrue(savedReader.getFirstName().equals("Houssam"));
	}
	

}
