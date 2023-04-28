package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {
	
	IProductRepository productRepository;

	@Autowired
	public void setProductRepository(IProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	@Override
	public Product getById(int productId) throws ProductNotFoundException {
		return productRepository
				.findById(productId)
				.orElseThrow(()-> new ProductNotFoundException("invalid id"));
	}
	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		 productRepository.deleteById(productId);
	}

	

}
