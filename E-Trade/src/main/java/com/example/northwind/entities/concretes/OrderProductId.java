package com.example.northwind.entities.concretes;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OrderProductId implements Serializable{

	private int orderId;
	private int productId;
	
	
	public OrderProductId() {
		
	}

	public OrderProductId(int orderId, int productId) {
		this.orderId = orderId;
		this.productId = productId;
	}
	
}
