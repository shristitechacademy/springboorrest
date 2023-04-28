package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	ResponseEntity<Void> addBook(@RequestBody Book book) {
		 bookService.addBook(book);
		 return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	//	http://localhost:8080/book-api/books
	@PutMapping("/books")
	ResponseEntity<Book> updateBook(@RequestBody Book book) {
		Book nbook =  bookService.updateBook(book);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "updating one book");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(nbook);
		
	}
	
	//	http://localhost:8080/book-api/books/2
	@DeleteMapping("/books/{bookId}")
	ResponseEntity<Void> deleteBook(@PathVariable("bookId")int bookId) {
		bookService.deleteBook(bookId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	//	http://localhost:8080/book-api/books
	@GetMapping("/books")
	ResponseEntity<List<Book>> getAll(){
		List<Book> books = bookService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "getting all books");
		headers.add("desc","Retrieving boks from database");
		ResponseEntity<List<Book>> entity = new ResponseEntity<>(books, headers,HttpStatus.OK);
		return entity;
		
	}
	
	//	http://localhost:8080/book-api/books/id/1
	@GetMapping("/books/id/{bookId}")
	ResponseEntity<Book> getById(@PathVariable("bookId")int bookId) {
		Book book =  bookService.getById(bookId);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("info", "getting one book by Id");
		return ResponseEntity.ok().headers(httpHeaders).body(book);
	}
	
	//	http://localhost:8080/book-api/books/author/Kathy
	@GetMapping("/books/author/{nauthor}")
	ResponseEntity<List<Book>> getByAuthor(@PathVariable("nauthor")String author){
		List<Book> books = bookService.getByAuthor(author);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("info", "getting books by author "+author);
		return ResponseEntity.ok().headers(httpHeaders).body(books);
		
	}
	
	//	http://localhost:8080/book-api/books/category
	@GetMapping("/books/category")
	ResponseEntity<List<Book>> getByCategory(@RequestParam("ncategory") String category){
		List<Book> books =  bookService.getByCategory(category);
		return ResponseEntity.ok(books);
	}
	
	//	http://localhost:8080/book-api/books/price/1000
	@GetMapping("/books/price/{price}")
	ResponseEntity<List<Book>> getByLesserPrice(@PathVariable("price")double price){
		List<Book> books =  bookService.getByLesserPrice(price);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("info", "getting books by lesser price "+price);
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(httpHeaders).body(books);
		
	}

	//	http://localhost:8080/book-api/books/catgeory/Fiction/price/1000
	@GetMapping("/books/category/{category}/price/{price}")
	ResponseEntity<List<Book>>  getByCategoryAndPrice(@PathVariable("category")String category, @PathVariable("price")double price){
		List<Book> books = bookService.getByCategoryAndPrice(category, price);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("info", "getting books by lesser price and category "+category);
		return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(books);
	}
	
}
