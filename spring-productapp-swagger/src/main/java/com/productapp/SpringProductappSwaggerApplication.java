package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = 
	@Info(title = "Product-API",version = "1.0",description = "Product API with Spring")
		)
public class SpringProductappSwaggerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappSwaggerApplication.class, args);
	}
	
	@Autowired
	IProductService productService;

	@Override
	public void run(String... args) throws Exception {

		Product product = new Product("Laptop",200000.0,"Dell","Electronics");
//		productService.addProduct(product);
	}

}
