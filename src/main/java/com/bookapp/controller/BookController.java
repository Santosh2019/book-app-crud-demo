package com.bookapp.controller;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.appconstant.AppConstant;
import com.bookapp.bean.Book;
import com.bookapp.exception.RecordNotFoundException;
import com.bookapp.properties.AppProperties;
import com.bookapp.serviceimpl.BookServiceImplementation;

@RestController
@CrossOrigin
public class BookController {

	@Autowired
	private BookServiceImplementation serviceImplementaion;

	Logger logger = LoggerFactory.getLogger(BookController.class);

	Map<String, String> messages;

	public BookController(BookServiceImplementation serviceImplementaion, AppProperties appProperties) {
		super();
		this.serviceImplementaion = serviceImplementaion;
		this.messages = appProperties.getMessages();
	}

	@PostMapping("/addBook")
	public ResponseEntity<Book> addBook(@RequestBody Book bookName) {
		Book book = serviceImplementaion.add(bookName);
		logger.info("Books Recorded created Successfully");
		return new ResponseEntity<Book>(book, HttpStatus.CREATED);
	}

	@PutMapping("/update/{bookId}")
	public ResponseEntity<String> updateBook(@PathVariable("bookId") Integer bookId, @RequestBody Book bookName) {
		String status = AppConstant.EMPTY_SIR;
		boolean book = serviceImplementaion.update(bookName);
		if (book) {
			status = AppConstant.RECORD_UPDATED_SUCCESS;

		} else {
			status = AppConstant.RECORD_NOT_UPDATED;
		}
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable("bookId") Integer bookId) {
		boolean deleted = serviceImplementaion.delete(bookId);
		if (deleted) {
			return new ResponseEntity<String>("Record Deleted SuccessFully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Invalid Book ID", HttpStatus.OK);
		}
	}

	@GetMapping("/getSinglBook/{bookId}")
	public ResponseEntity<Book> getSingleBook(@PathVariable("bookId") Integer bookId) throws RecordNotFoundException {
		Book isCheck = serviceImplementaion.getBook(bookId);
		if (isCheck != null) {

			return new ResponseEntity<Book>(isCheck, HttpStatus.OK);
		}
		return new ResponseEntity<Book>(isCheck, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/getbooklist")
	public ResponseEntity<List<Book>> getAllBookList() {
		List<Book> books = serviceImplementaion.getAllBooks();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@GetMapping("/findByName")
	public ResponseEntity<List<String>> findByName() {

		List<String> books = serviceImplementaion.findByName();

		return new ResponseEntity<List<String>>(books, HttpStatus.OK);
	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> removeAll() {
		String msg = "Deleted";
		serviceImplementaion.deleteAllBooks();
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

}
