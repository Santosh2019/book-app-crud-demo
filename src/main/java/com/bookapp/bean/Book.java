package com.bookapp.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;

	private Integer bookPrice;

	private String bookName;
	
	  public Integer getBookPrice() { return bookPrice; }
	  
	  public Integer getBookId() { return bookId; }
	  
	  public void setBookId(Integer bookId) { this.bookId = bookId; }
	  
	  public void setBookPrice(Integer bookPrice) { this.bookPrice = bookPrice; }
	  
	  public String getBookName() { return bookName; }
	  
	  public void setBookName(String bookName) { this.bookName = bookName; }
	 
}
