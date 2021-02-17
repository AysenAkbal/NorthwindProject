package com.example.northwind.dataaccess.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.northwind.entities.concretes.OrderDetails;
import com.example.northwind.entities.concretes.ShoppingCarts;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCarts, Integer> {

	@Query(value="SELECT basket_id from shopping_cart where product_id =?1 and customer_id =?2", nativeQuery= true)
    List<Integer> findEqualityForNewItem(Integer productId, String customerId);
	
	@Modifying(clearAutomatically=true)
	@Query(value="UPDATE shopping_cart SET quantity=?1 WHERE basket_id=?2",nativeQuery= true)
	void updateQuantity(Integer quantity, Integer basketId);
	
	@Query(value="SELECT * FROM shopping_cart where customer_id =?1", nativeQuery= true)
	List<ShoppingCarts> findBasketForCustomer(String customerId);
	
	@Query(value="UPDATE shopping_cart SET quantity=?1 WHERE basket_id=?2", nativeQuery= true)
	void deleteQuantity(Integer deletedQauntiy,Integer basketId);
	
	@Query(value="DELETE FROM SHOPPING_CART WHERE CUSTOMER_ID=?1 AND PRODUCT_ID=?2",nativeQuery= true)
	void deleteAfterSale(String customerId, Integer productId);
}
