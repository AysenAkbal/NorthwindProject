package com.example.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.business.abstracts.IProductService;
import com.example.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/v1")
public class ProductsController {

	@Autowired
	IProductService productService;
	
	@GetMapping("/products")
	public List<Product> getAll(){
		return productService.getAll();
	}
	
	@GetMapping("/products/{product_id}")
	public Product getById(@PathVariable(value ="product_id") Product product) throws Exception
	{
	    
		return productService.findById(product)
				.orElseThrow(()-> new Exception("No categories with " + product.getId()) );
	}
	
	@PostMapping("/products")
	public Product add(@RequestBody Product product) {
		return productService.add(product);
	}
	
	@DeleteMapping("/products/{product_id}")
	public Product delete(@PathVariable(value ="product_id") Product product) throws Exception
	{
		return productService.delete(product);
	}
	
	@PutMapping("/products/{product_id}")
	public Product update(@PathVariable(value ="product_id") Product product1, @RequestBody Product product) throws Exception
	{
		return productService.update(product1,product);
	}
}
