package com.bookapp.dao;

import com.bookapp.model.BookDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookDto, Integer> {
}
