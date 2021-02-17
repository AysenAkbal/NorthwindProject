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
@Table(name="orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	@Column(name="customer_id")
	private String customerId;
	@Column(name="ship_country")
	private String shipCountry;
	@Column(name="ship_city")
	private String shipCity;
	@Column(name="ship_address")
	private String shipAddress;
}
