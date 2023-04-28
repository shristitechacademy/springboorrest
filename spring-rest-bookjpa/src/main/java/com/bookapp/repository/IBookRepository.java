package com.bookapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer>{

	List<Book> getByAuthor(String author);

	List<Book> readByCategory(String category);

	List<Book> findByPriceLessThan(double price);

	// custom query
	@Query("from Book b where b.category=?1 and b.price<?2")
	List<Book> findByCatAndPrice(String category, double price);
}
