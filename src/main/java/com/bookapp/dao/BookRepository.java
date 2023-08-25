package com.bookapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookapp.bean.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
