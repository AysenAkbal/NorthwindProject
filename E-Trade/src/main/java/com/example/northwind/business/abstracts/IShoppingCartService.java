package com.example.northwind.business.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.northwind.entities.concretes.ShoppingCarts;

public interface IShoppingCartService {

	List<ShoppingCarts> getAll();
	void add(ShoppingCarts shoppingCarts) throws Exception;
	Optional<ShoppingCarts> findById(ShoppingCarts shoppingCarts);
	ShoppingCarts updateQuantity(ShoppingCarts shoppingCarts, ShoppingCarts getShoppingCarts)throws Exception;
	List<ShoppingCarts> findByCustomerId(String customerId);
	//void delete(ShoppingCarts shoppingCarts) throws Exception;
}
