package com.bookapp.service;

import java.util.List;

import com.bookapp.model.Book;

public interface IBookService {

	// crud operation using the inbuilt methods
	
	Book addBook(Book book);
	Book updateBook(Book book);
	void deleteBook(int bookId);
	
	Book getById(int bookId);
	List<Book> getAll();


	// Using derived queries
	List<Book> getByAuthor(String author);
	List<Book> getByCategory(String category);
	List<Book> getByLesserPrice(double price);
	
	List<Book> getByCategoryAndPrice(String category, double price);
	

}
