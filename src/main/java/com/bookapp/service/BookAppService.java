package com.bookapp.service;

import com.bookapp.model.BookDto;
import com.bookapp.exception.RecordNotFoundException;

import java.util.List;

public interface BookAppService {
	BookDto add(BookDto name);

	List<BookDto> getAllBooks();

	BookDto getBook(Integer bookId) throws RecordNotFoundException;

	boolean update(BookDto name);

	boolean delete(Integer bookId);

	void deleteAllBooks();
}
