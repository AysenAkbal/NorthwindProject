package com.example.northwind.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.business.abstracts.IShoppingCartService;
import com.example.northwind.entities.concretes.ShoppingCarts;

@RestController
@RequestMapping("/api/v1")
public class ShoppingCartContoller {

	@Autowired
	IShoppingCartService shoppingCartService;
	
	@GetMapping("/shoppingcarts")
	public List<ShoppingCarts> getAll(){
		return shoppingCartService.getAll();
	}
	
	//Sepeti sepet id'sine gore donme
	@GetMapping("/shoppingcarts/{basket_id}")
	public ShoppingCarts getById(@PathVariable(value ="basket_id") ShoppingCarts shoppingCarts) throws Exception
	{
	    
		return shoppingCartService.findById(shoppingCarts)
				.orElseThrow(()-> new Exception("No cards with " + shoppingCarts.getBasketId()) );
	}
	
	//Sepeti musteri bazinda listeleme
	@GetMapping("/shoppingcarts/name/{customer_id}")
	public List<ShoppingCarts> getByCustomerId(@PathVariable(value="customer_id", required = true) String customerId)throws Exception{
		
		List<ShoppingCarts> list = shoppingCartService.findByCustomerId(customerId);
		
		if(list == null) {
            System.out.println("Kullanıcı bulunamadı!");
        }
        return shoppingCartService.findByCustomerId(customerId);
	}
	
	@PostMapping("/shoppingcarts")
	public void add(@RequestBody ShoppingCarts shoppingCarts) throws Exception {
	
		 shoppingCartService.add(shoppingCarts);
	}
	
	@PutMapping("/shoppingcarts/{basket_id}")
	public ShoppingCarts deleteQuantity(@PathVariable(value ="basket_id") ShoppingCarts shoppingCarts, @RequestBody ShoppingCarts getShoppingCarts) throws Exception
	{
		return shoppingCartService.updateQuantity(shoppingCarts,getShoppingCarts);
	}
	
}
