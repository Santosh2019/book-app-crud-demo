package com.bookapp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bookapp.bean.Book;
import com.bookapp.controller.BookController;
import com.bookapp.serviceimpl.BookServiceImplementation;

public class BookRepositoryTest {

	private BookServiceImplementation serviceImplementation = mock(BookServiceImplementation.class);

	private BookController bookController = new BookController(serviceImplementation, null);

	@Test
	void testAddBook() {
		Book bookToAdd = new Book();
		bookToAdd.setBookId(1);
		bookToAdd.setBookName("asf");
		bookToAdd.setBookPrice(1254);
		when(serviceImplementation.add(any(Book.class))).thenReturn(bookToAdd);
		ResponseEntity<Book> response = bookController.addBook(bookToAdd);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(bookToAdd, response.getBody());
		verify(serviceImplementation).add(bookToAdd);
	}

	@Test
	void testUpdateBook() {
		int bookId = 1;
		Book bookToUpdate = new Book();
		bookToUpdate.setBookId(1);
		bookToUpdate.setBookName("asf");
		bookToUpdate.setBookPrice(1254);
		when(serviceImplementation.update(any(Book.class))).thenReturn(true);
		ResponseEntity<String> response = bookController.updateBook(bookId, bookToUpdate);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		verify(serviceImplementation).update(bookToUpdate);
	}

	@Test
	public void testGetAllBookList() {
		List<Book> sampleBooks = new ArrayList<>();
		Book bookOne = new Book();
		bookOne.setBookId(1);
		bookOne.setBookName("Welcoem");
		bookOne.setBookPrice(125);

		Book bookTwo = new Book();
		bookTwo.setBookId(1);
		bookTwo.setBookName("Welcoem");
		bookTwo.setBookPrice(125);
		when(serviceImplementation.getAllBooks()).thenReturn(sampleBooks);
		ResponseEntity<List<Book>> response = bookController.getAllBookList();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(sampleBooks, response.getBody());
		verify(serviceImplementation).getAllBooks();
	}

}
