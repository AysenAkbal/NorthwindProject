package com.example.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.business.abstracts.IOrderService;
import com.example.northwind.entities.concretes.OrderDetails;
import com.example.northwind.entities.concretes.Orders;

@RestController
@RequestMapping("/api/v1")
public class OrderController {


	@Autowired
	IOrderService orderservice;
	
	@GetMapping("/orderdetails")
	public List<OrderDetails> getAll(){
		
		return orderservice.getAll();
	}
	
	@GetMapping("/orders")
	public List<Orders> getOrders(){
		
		return orderservice.getOrders();
	}
	
	@PostMapping("/orders")
	public Orders saleProduct(@RequestBody Orders order) {
		
		return orderservice.add(order);
	}
	
	@PostMapping("/orderdetails")
	public OrderDetails saleDetails(@RequestBody OrderDetails orderDetails) {
		
		return orderservice.add(orderDetails);
	}
	
}
