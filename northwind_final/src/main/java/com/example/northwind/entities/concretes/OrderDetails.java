package com.example.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="order_details")
@IdClass(OrderProductId.class)
public class OrderDetails {

	@Id
	@Column(name="order_id")
	private int orderId;
	@Id
	@Column(name="product_id")
	private int productId;
	
	@Column(name="unit_price")
	private float unitPrice;
	@Column(name="quantity")
	private int quantity;
	@Column(name="discount")
	private float discount;
	
	
}
