package com.example.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "shopping_cart")
public class ShoppingCarts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "basket_id")
	private int basketId;
	@Column(name= "customer_id")
	private String customerId;
	@Column(name= "product_name")
	private String productName;
	@Column(name= "product_id")
	private int product_id;
	@Column(name= "quantity")
	private Integer quantity;
}
