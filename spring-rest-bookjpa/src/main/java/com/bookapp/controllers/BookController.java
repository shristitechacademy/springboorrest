package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@RestController
@RequestMapping("/book-api")
public class BookController {

	private IBookService bookService;
	@Autowired
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
	
	//	http://localhost:8080/book-api/books
	@PostMapping("/books")
	Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	//	http://localhost:8080/book-api/books
	@PutMapping("/books")
	Book updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	
	//	http://localhost:8080/book-api/books/2
	@DeleteMapping("/books/{bookId}")
	void deleteBook(@PathVariable("bookId")int bookId) {
		bookService.deleteBook(bookId);
	}
	
	//	http://localhost:8080/book-api/books
	@GetMapping("/books")
	List<Book> getAll(){
		return bookService.getAll();
		
	}
	
	//	http://localhost:8080/book-api/books/id/1
	@GetMapping("/books/id/{bookId}")
	Book getById(@PathVariable("bookId")int bookId) {
		return bookService.getById(bookId);
	}
	
	//	http://localhost:8080/book-api/books/author/Kathy
	@GetMapping("/books/author/{nauthor}")
	List<Book> getByAuthor(@PathVariable("nauthor")String author){
		return bookService.getByAuthor(author);
	}
	
	//	http://localhost:8080/book-api/books/category
	@GetMapping("/books/category")
	List<Book> getByCategory(@RequestParam("ncategory") String category){
		return bookService.getByCategory(category);
	}
	
	//	http://localhost:8080/book-api/books/price/1000
	@GetMapping("/books/price/{price}")
	List<Book> getByLesserPrice(@PathVariable("price")double price){
		return bookService.getByLesserPrice(price);
	}

	//	http://localhost:8080/book-api/books/catgeory/Fiction/price/1000
	@GetMapping("/books/category/{category}/price/{price}")
	List<Book> getByCategoryAndPrice(@PathVariable("category")String category, @PathVariable("price")double price){
		return bookService.getByCategoryAndPrice(category, price);
	}
	
}
