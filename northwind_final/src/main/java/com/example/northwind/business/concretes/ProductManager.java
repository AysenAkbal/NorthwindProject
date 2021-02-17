package com.example.northwind.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.IProductService;
import com.example.northwind.dataaccess.concretes.ProductRepository;
import com.example.northwind.entities.concretes.Product;

@Service
public class ProductManager implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAll() {

		return productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(Product product) {
		int productId = product.getId();
		return productRepository.findById(productId);
	}

	@Override
	public Product add(Product product) {

		int productNameLength = product.getProductName().length();
		int categoryId = product.getCategoryId();

		int findNumberOfCategory = productRepository.findNumberOfCategory(categoryId);

		// System.out.println(findNumberOfCategory);

		if (productNameLength > 2 && findNumberOfCategory < 10) {
			System.out.println("The product has been successfully added !");
			return productRepository.save(product);

		} else {
			System.out.println("The product could not be added because of required conditions !");
			return product;
		}

	}

	@Override
	public Product delete(Product product) throws Exception {
		int productId = product.getId();

		Product productDelete = productRepository.findById(productId)
				.orElseThrow(() -> new Exception("No product with id:" + productId));
		productRepository.delete(productDelete);
		return productDelete;

	}

	@Override
	public Product update(Product product1, Product product) throws Exception {

		int productId = product1.getId();
		Product productToUpdate = productRepository.findById(productId)
				.orElseThrow(() -> new Exception("No product with id:" + productId));

		productToUpdate.setProductName(product.getProductName());
		productToUpdate.setCategoryId(product.getCategoryId());
		productToUpdate.setSupplierId(product.getSupplierId());
		productToUpdate.setQuantity(product.getQuantity());
		productToUpdate.setCategoryId(product.getCategoryId());
		productToUpdate.setUnitPrice(product.getUnitPrice());
		productToUpdate.setUnitsInStock(product.getUnitsInStock());
		productToUpdate.setUnitsOnOrder(product.getUnitsOnOrder());
		productToUpdate.setReorderLevel(product.getReorderLevel());
		productToUpdate.setDiscontinued(product.getDiscontinued());

		Product updatedProduct = productRepository.save(productToUpdate);
		return updatedProduct;

	}

}
