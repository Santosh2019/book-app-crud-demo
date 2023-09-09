package com.bookapp.service;

import com.bookapp.bean.Book;
import com.bookapp.exception.RecordNotFoundException;

import java.util.List;

public interface BookAppService {
	Book add(Book name);

	List<Book> getAllBooks();

	Book getBook(Integer bookId) throws RecordNotFoundException;

	boolean update(Book name);

	boolean delete(Integer bookId);

	void deleteAllBooks();
}
