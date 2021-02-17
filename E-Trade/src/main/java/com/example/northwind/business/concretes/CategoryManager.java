package com.example.northwind.business.concretes;


import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.ICategoryService;
import com.example.northwind.dataaccess.concretes.CategoryRepository;
import com.example.northwind.entities.concretes.Categories;

@Service
public class CategoryManager implements ICategoryService{

	@Autowired
	private CategoryRepository categoryRepository;

	
	@Override
	public List<Categories> getAll() {
		
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Categories> findById(Categories category) {
		int categoryId = category.getId();
		return categoryRepository.findById(categoryId);
	}

	@Override
	public Categories add(Categories category) {
	
		return categoryRepository.save(category);
		
	}

	@Override
	public Categories delete(Categories category) throws Exception {
		int categoryId = category.getId();
		
		Categories categoryDelete = categoryRepository.findById(categoryId)
					.orElseThrow(()->new Exception("No category with id:"+ categoryId));
		categoryRepository.delete(categoryDelete);
		return categoryDelete;
	}

	@Override
	public Categories update(Categories category1, Categories category) throws Exception {
		
		int categoryId = category1.getId();
		Categories categoryToUpdate = categoryRepository.findById(categoryId)
			.orElseThrow(()->new Exception("No category with id:"+categoryId));
	 	
		categoryToUpdate.setCategoryName(category.getCategoryName());
		categoryToUpdate.setDescription(category.getDescription());
	
		Categories updatedCategory = categoryRepository.save(categoryToUpdate);
		return updatedCategory;
	}

	



}
