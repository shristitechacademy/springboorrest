package com.productapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@RestController
@RequestMapping("/product-api")
public class ProductController {

	@Autowired
	IProductService productService;
	
	@GetMapping("/products")
	ResponseEntity<List<Product>> getAll(){
		List<Product> products = productService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	
	
	@PostMapping("/products")
	Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	@PutMapping("/products")
	Product updateProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	@DeleteMapping("/products/{productId}")
	void deleteProduct(@PathVariable("productId") Product product) {
		productService.addProduct(product);
	}
	@GetMapping("/products/id/{product-id}")
	Product getById(@PathVariable("product-id") int productId) {
		return productService.getById(productId);
		
	}
	
}


