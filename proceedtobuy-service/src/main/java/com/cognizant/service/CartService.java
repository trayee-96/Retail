package com.cognizant.service;

import java.util.Date;

import org.springframework.http.ResponseEntity;

public interface CartService {
	public ResponseEntity<?> addProductToCart(int customerId, int productId, int zipCode, Date expectedDeliveryDate);

	public ResponseEntity<?> addProductToWishList(int customerId, int productId,int quantity);
	public ResponseEntity<?> deleteFromCart(int customerId,int productId);
}
