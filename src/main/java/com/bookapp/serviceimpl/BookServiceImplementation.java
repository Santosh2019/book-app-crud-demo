package com.bookapp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.bean.Book;
import com.bookapp.dao.BookAppRepo;
import com.bookapp.exception.RecordNotFoundException;
import com.bookapp.service.BookAppService;

@Service
public class BookServiceImplementation implements BookAppService {

	@Autowired
	private BookAppRepo bookRepository;

	@Override
	public Book add(Book name) {
		Book book = bookRepository.save(name);
		return book;
	}

	@Override
	public boolean update(Book name) {
		Book isUpdated = bookRepository.save(name);
		return isUpdated.getBookId()!= null;
	}

	@Override
	public boolean delete(Integer bookId) {
		boolean status = false;
		try {
			bookRepository.deleteById(bookId);
			status = true;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Book getBook(Integer bookId) throws RecordNotFoundException {

		Optional<Book> checkBookId = bookRepository.findById(bookId);
		if (checkBookId.isPresent()) {
			return checkBookId.get();
		} else {
			throw new RecordNotFoundException("No Book record exist for given id");
		}
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> list = bookRepository.findAll();
		return list;
	}

	@Override
	public String getNames(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}

}
