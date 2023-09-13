package com.bookapp.service;

import com.bookapp.exception.RecordNotFoundException;
import com.bookapp.model.AccountRegistrationDto;
import com.bookapp.model.BookDto;

import java.util.List;

public interface BookAppService {
    BookDto add(BookDto book);

    AccountRegistrationDto accountRegistration(AccountRegistrationDto accountRegistrationDto);

    AccountRegistrationDto checkLogin(String userName);

    List<BookDto> getAllBooks();

    BookDto getBook(Integer bookId) throws RecordNotFoundException;

    boolean update(BookDto name);

    boolean delete(Integer bookId);

    void deleteAllBooks();
}
