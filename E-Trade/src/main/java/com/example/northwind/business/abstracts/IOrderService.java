package com.example.northwind.business.abstracts;

import java.util.List;
import com.example.northwind.entities.concretes.OrderDetails;
import com.example.northwind.entities.concretes.Orders;


public interface IOrderService {

	List<OrderDetails> getAll();
	List<Orders> getOrders();
	Orders add(Orders orders);
	OrderDetails add(OrderDetails orderDetails);
	
}
