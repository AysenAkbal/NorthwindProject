package com.example.northwind.dataaccess.concretes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.northwind.entities.concretes.Categories;


public interface CategoryRepository extends JpaRepository<Categories, Integer> {

}
