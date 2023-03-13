package com.bookapp.service;

import java.util.List;

import com.bookapp.bean.Book;
import com.bookapp.exception.RecordNotFoundException;

public interface BookAppService {

	public Book add(Book name);

	public List<Book> getAllBooks();

	public Book getBook(Integer bookId) throws RecordNotFoundException;

	public boolean update(Book name);

	public boolean delete(Integer bookId);

	public void deleteAllBooks();

	public List<String> findByName();

}
