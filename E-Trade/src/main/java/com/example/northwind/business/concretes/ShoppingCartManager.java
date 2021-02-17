package com.example.northwind.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.northwind.business.abstracts.IShoppingCartService;
import com.example.northwind.dataaccess.concretes.ShoppingCartRepository;
import com.example.northwind.entities.concretes.ShoppingCarts;

@Transactional
@Service
public class ShoppingCartManager implements IShoppingCartService {

	@Autowired
	ShoppingCartRepository shoppingCartRepository;

	@Override
	public List<ShoppingCarts> getAll() {

		return shoppingCartRepository.findAll();
	}

	@Override
	public Optional<ShoppingCarts> findById(ShoppingCarts shoppingCarts) {
		int getBasketId = shoppingCarts.getBasketId();
		return shoppingCartRepository.findById(getBasketId);
	}

	@Override
	public List<ShoppingCarts> findByCustomerId(String custId) {

		System.out.println(custId);
		return shoppingCartRepository.findBasketForCustomer(custId);

	}

	@Override
	public void add(ShoppingCarts shoppingCarts) throws Exception {

		String getCustomerId = shoppingCarts.getCustomerId();
		int getProductId = shoppingCarts.getProduct_id();
		int getquantity = shoppingCarts.getQuantity();

		List<Integer> list = shoppingCartRepository.findEqualityForNewItem(getProductId, getCustomerId);

		if (list.isEmpty()) {
			shoppingCartRepository.save(shoppingCarts);
		} else {

			int getBasketId = list.get(0);
			int newQuantity = getquantity + 1;
			shoppingCartRepository.updateQuantity(newQuantity, getBasketId);

		}

	}

	@Override
	public ShoppingCarts updateQuantity(ShoppingCarts shoppingCarts, ShoppingCarts getShoppingCarts) throws Exception {

		int basketId = shoppingCarts.getBasketId();
		int quantityForDelete = 1;

		ShoppingCarts updateToQuantity = shoppingCartRepository.findById(basketId)
				.orElseThrow(() -> new Exception("No product with id:" + basketId));

		if(quantityForDelete > 0 && getShoppingCarts.getQuantity() >= quantityForDelete){
			updateToQuantity.setQuantity(getShoppingCarts.getQuantity() - quantityForDelete);

		}else{
			throw new IllegalArgumentException("Sepetinizde silmek istediginiz kadar urun bulunmamaktadir !");
		}

		ShoppingCarts updatedQuantity = shoppingCartRepository.save(updateToQuantity);
		return updatedQuantity;
	}

}
