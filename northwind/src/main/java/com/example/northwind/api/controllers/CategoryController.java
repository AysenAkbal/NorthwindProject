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

import com.example.northwind.business.abstracts.ICategoryService;
import com.example.northwind.dataaccess.concretes.CategoryRepository;
import com.example.northwind.entities.concretes.Categories;



@RestController
@RequestMapping("/api/v1")
public class CategoryController {

		@Autowired
		ICategoryService categoryService;
		@Autowired
	    CategoryRepository categoryRepository;
		
		@GetMapping("/categories")
		public List<Categories> getAll(){
			
			return categoryService.getAll();
		}
		
		@GetMapping("/categories/{category_id}")
		public Categories getById(@PathVariable(value ="category_id") Categories category) throws Exception
		{
			return categoryService.findById(category)
					.orElseThrow(()-> new Exception("No categories with " + category.getId()));
		}
		
		@PostMapping("/categories")
		public Categories add(@RequestBody Categories category) {
			
			return categoryService.add(category);
		}
		
		
		@DeleteMapping("/categories/{category_id}")
		public Categories delete(@PathVariable(value ="category_id") Categories category) throws Exception
		{
			return categoryService.delete(category);
		}
		
		@PutMapping("/categories/{category_id}")
		public Categories update(@PathVariable(value ="category_id") Categories category1, @RequestBody Categories category) throws Exception
		{
			return categoryService.update(category1,category);
		}
	
		
}
