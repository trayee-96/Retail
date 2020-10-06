package com.cognizant.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.DTO.Product;
import com.cognizant.DTO.Vendor;
import com.cognizant.client.ProductClient;
import com.cognizant.exception.ProductNotPresentException;
import com.cognizant.model.Cart;
import com.cognizant.model.VendorWishlist;
import com.cognizant.repository.CartRepository;
import com.cognizant.repository.WishListRepository;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepository repository;
	@Autowired
	ProductClient client;
	@Autowired
	WishListRepository wlrepo;

	@Transactional
	@Override
	public ResponseEntity<?> addProductToCart(int customerId, int productId, int zipCode, Date expectedDeliveryDate) {
		Product p = client.searchProductById(productId).get();
		Cart c = repository.findByUserIdAndProductId(customerId, productId);
		if (c != null) {
			c.setCount(c.getCount() + 1);
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(c));
		}

		Cart cr = new Cart(6, customerId, p.getId(), zipCode, expectedDeliveryDate, 15, 1);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(cr));

	}

	@Transactional
	@Override
	public ResponseEntity<?> addProductToWishList(int customerId, int productId,int quantity) {
		List<Vendor> vendors = new ArrayList<>();
		Vendor v=new Vendor(15,"Anil",50L,4.5);
		vendors.add(v);
		return ResponseEntity.status(HttpStatus.OK).body(wlrepo.save(new VendorWishlist(v.getVendorId(),productId,quantity,new Date())));
	}

	@Transactional
	@Override
	public ResponseEntity<?> deleteFromCart(int customerId, int productId) {
		Cart c = repository.findByUserIdAndProductId(customerId, productId);
		if (c != null) {
			if (c.getCount() > 1) {
				c.setCount(c.getCount() - 1);
				repository.save(c);
				return ResponseEntity.status(HttpStatus.OK)
						.body("Product with id " + productId + "removed successfully");
			}
			repository.delete(c);
			return ResponseEntity.status(HttpStatus.OK).body("Product with id " + productId + "removed successfully");
		}
		throw new ProductNotPresentException("Product with id" + productId + "is not in the cart.");

	}

}
