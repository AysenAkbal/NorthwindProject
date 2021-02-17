package com.example.northwind.business.abstracts;

import java.util.List;
import java.util.Optional;

import com.example.northwind.entities.concretes.Product;

public interface IProductService {

	List<Product> getAll();
	Optional<Product> findById(Product product);
	Product add(Product product);
	Product delete(Product product) throws Exception;
	Product update(Product product1,Product product) throws Exception;
}
