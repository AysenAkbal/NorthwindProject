package com.example.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.northwind.business.abstracts.IOrderService;
import com.example.northwind.dataaccess.concretes.OrderDetailsRepository;
import com.example.northwind.dataaccess.concretes.OrderRepository;
import com.example.northwind.dataaccess.concretes.ShoppingCartRepository;
import com.example.northwind.entities.concretes.OrderDetails;
import com.example.northwind.entities.concretes.Orders;

@Transactional
@Service
public class OrderManager implements IOrderService {

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	
	@Override
	public List<OrderDetails> getAll() {
		
		return orderDetailsRepository.findAll();
	}

	@Override
	public List<Orders> getOrders() {
		
		return orderRepository.findAll();
	}
	
	@Override
	public Orders add(Orders order) {
		
		return orderRepository.save(order);
		
	}

	@Override
	public OrderDetails add(OrderDetails orderDetails) {
		
		orderDetailsRepository.save(orderDetails); 
	    int orderProductId = orderDetails.getProductId();
	    int orderId = orderDetails.getOrderId();
	    //List<String> list =orderRepository.findCustomerId();
	    String customerId = orderRepository.findCustomerId(orderId);
	    System.out.println(customerId);
	    System.out.println(orderProductId);
	    //String custId = list.get(0);
	    shoppingCartRepository.deleteAfterSale(customerId, orderProductId);
	    return orderDetails;
		
	}

	

	
}
