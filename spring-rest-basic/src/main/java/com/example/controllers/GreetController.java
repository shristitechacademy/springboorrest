package com.example.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Book;
import com.example.service.IGreetService;

@RestController
public class GreetController {
	
	@Autowired
	private IGreetService greetService;
	
	// http://localhost:8080/show-message
	@GetMapping("/show-message")
	public String printMessage() {
	 return greetService.showMessage();	
	}
	
	
	@GetMapping("/welcome-user/{uname}")
	public String welcomeUser(@PathVariable("uname") String username) {
		return "Welcome "+username;
	}
	
	@GetMapping("/greet-user/{username}/{city}")
	public String greetUser(
			@PathVariable("username") String username,
			@PathVariable("city") String city) {
		return "Hi "+username+" !!!Enjoy your stay in "+city;
		
	}
	
	// http://localhost:8080/show-details/?uname=Sri&department=Admin
	@GetMapping("/show-details")
	public String showDetails(@RequestParam("uname") String username,@RequestParam("department") String department) {
		return username +" is from   "+department +" group"; 
	}
	
	// http://localhost:8080/show-books/?author=Kathy
	@GetMapping("/show-books")
	public List<String> showBooks(@RequestParam("author") String author){
		if(author.equals("Kathy")) {
			return Arrays.asList("Head First Java","Head First JSP");
		}else if(author.equals("Robin")) {
			return Arrays.asList("Leadership","5 am club");
		}else {
			return Arrays.asList("no books available");
		}
			
	}
	
	@PostMapping("/print-book")
	public Book printData(@RequestBody Book book ) {
		return book;
	}
	
	
	
}
