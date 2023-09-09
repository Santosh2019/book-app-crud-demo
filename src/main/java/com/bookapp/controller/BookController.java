package com.bookapp.controller;

import com.bookapp.appconstant.AppConstant;
import com.bookapp.bean.Book;
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
    public ResponseEntity<Book> addBook(@RequestBody Book bookName) {
        Book book = serviceImplementaion.add(bookName);
        logger.info("Books Recorded created Successfully");
        return new ResponseEntity<Book>(book, HttpStatus.CREATED);
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<String> updateBook(@PathVariable("bookId") Integer bookId, @RequestBody Book bookName) {
        logger.info("book id is {}:" + bookId);
        String status;
        boolean book = serviceImplementaion.update(bookName);
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
            return new ResponseEntity<>("Invalid Book ID", HttpStatus.OK);
        }
    }

    @GetMapping("/getSinglBook/{bookId}")
    public ResponseEntity<Book> getSingleBook(@PathVariable("bookId") Integer bookId) throws RecordNotFoundException {
        Book isCheck = serviceImplementaion.getBook(bookId);
        if (isCheck != null) {

            return new ResponseEntity<Book>(isCheck, HttpStatus.OK);
        }
        return new ResponseEntity<>(isCheck, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/getBookList")
    public ResponseEntity<List<Book>> getAllBookList() {
        List<Book> books = serviceImplementaion.getAllBooks();
        if (books.isEmpty()) {
            return new ResponseEntity<>(books, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> removeAll() {
        String msg = "Deleted";
        serviceImplementaion.deleteAllBooks();
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

}
