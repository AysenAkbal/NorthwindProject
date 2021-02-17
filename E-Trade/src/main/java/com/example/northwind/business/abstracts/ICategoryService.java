package com.example.northwind.business.abstracts;


import java.util.List;
import java.util.Optional;
import com.example.northwind.entities.concretes.Categories;



public interface ICategoryService {

	List<Categories> getAll();
	Optional<Categories> findById(Categories category);
	Categories add(Categories category);
	Categories delete(Categories category) throws Exception;
	Categories update(Categories category1,Categories category) throws Exception;
    
}
	
