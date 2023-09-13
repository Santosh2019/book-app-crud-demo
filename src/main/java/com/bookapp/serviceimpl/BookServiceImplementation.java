package com.bookapp.serviceimpl;

import com.bookapp.dao.AccountRepository;
import com.bookapp.dao.BookRepository;
import com.bookapp.exception.RecordNotFoundException;
import com.bookapp.model.AccountRegistrationDto;
import com.bookapp.model.BookDto;
import com.bookapp.service.BookAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplementation implements BookAppService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountRegistrationDto accountRegistration(AccountRegistrationDto accountRegistration) {
        return accountRepository.save(accountRegistration);
    }

    @Override
    public BookDto add(BookDto book) {
        return bookRepository.save(book);
    }

    @Override
    public boolean update(BookDto name) {
        BookDto isUpdated = bookRepository.save(name);
        return isUpdated.getBookId() != null;
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
    public BookDto getBook(Integer bookId) throws RecordNotFoundException {
        Optional<BookDto> checkBookId = bookRepository.findById(bookId);
        if (checkBookId.isPresent()) {
            return checkBookId.get();
        } else {
            throw new RecordNotFoundException("No records exist for given id");
        }
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }

    @Override
    public AccountRegistrationDto checkLogin(String userName) {
        return accountRepository.findByUserName(userName);
    }

}
