package com.bookapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookapp.bean.Book;

@Repository
public interface BookAppRepo extends JpaRepository<Book, Integer> {

	@Query("SELECT bookName from Book ")
	public List<String>findByName();
	
	
}
