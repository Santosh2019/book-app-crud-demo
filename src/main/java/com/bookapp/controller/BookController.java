package com.bookapp.controller;

import com.bookapp.appconstant.AppConstant;
import com.bookapp.model.BookDto;
import com.bookapp.exception.RecordNotFoundException;
import com.bookapp.serviceimpl.BookServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("book-app")
public class BookController {

    @Autowired
    private BookServiceImplementation serviceImplementaion;

    Logger logger = LoggerFactory.getLogger(BookController.class);

    Map<String, String> messages;

    @GetMapping("/test")
    public String getStatus() {
        return "Server is running";
    }


    @PostMapping("/addBook")
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDtoNameDto) {
        BookDto bookDto = serviceImplementaion.add(bookDtoNameDto);
        return new ResponseEntity<>(bookDto, HttpStatus.CREATED);
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<String> updateBook(@PathVariable("bookId") Integer bookId, @RequestBody BookDto bookDtoName) {
        String status;
        boolean book = serviceImplementaion.update(bookDtoName);
        if (book) {
            status = AppConstant.RECORD_UPDATED_SUCCESS;
        } else {
            status = AppConstant.RECORD_NOT_UPDATED;
        }
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable("bookId") Integer bookId) {
        boolean deleted = serviceImplementaion.delete(bookId);
        if (deleted) {
            return new ResponseEntity<>("Record Dleted SuccessFully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid BookDto ID", HttpStatus.OK);
        }
    }

    @GetMapping("/getSingleBook/{bookId}")
    public ResponseEntity<BookDto> getSingleBook(@PathVariable("bookId") Integer bookId) throws RecordNotFoundException {
        BookDto isCheck = serviceImplementaion.getBook(bookId);
        if (null != isCheck) {
            return new ResponseEntity<>(isCheck, HttpStatus.OK);
        }
        return new ResponseEntity<>(isCheck, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/getBookList")
    public ResponseEntity<List<BookDto>> getAllBookList() {
        List<BookDto> bookDtos = serviceImplementaion.getAllBooks();
        if (bookDtos.isEmpty()) {
            return new ResponseEntity<>(bookDtos, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(bookDtos, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> removeAll() {
        String messageDeleted = AppConstant.RECORD_DELETED;
        serviceImplementaion.deleteAllBooks();
        return new ResponseEntity<>(messageDeleted, HttpStatus.OK);
    }
}
