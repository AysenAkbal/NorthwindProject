package com.example.northwind.dataaccess.concretes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.northwind.entities.concretes.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

	//@Query(value="select cast (customer_id AS varchar(100)) from orders where order_id = ( SELECT MAX(ORDER_ID) FROM ORDERS)", nativeQuery= true)
	//List<String> findCustomerId();
	
	@Query(value="select cast (customer_id AS varchar(100)) from orders where order_id=:orderId",nativeQuery= true)
	String findCustomerId(@Param("orderId") Integer OrderId);
	
}
