package com.cognizant.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.DTO.CartRequest;
import com.cognizant.service.CartService;

@RestController
@RequestMapping("/proceed")
public class ProceedController {
	@Autowired
	private CartService service;

	@PostMapping("/add")
	public ResponseEntity<?> addProductToCart(@RequestBody CartRequest request) throws ParseException {
		return service.addProductToCart(request.getCustomerId(), request.getProductId(), request.getZipCode(),
				new SimpleDateFormat("dd/MM/yyyy").parse(request.getExpectedDeliveryDate()));
	}
	@DeleteMapping("/delete/{customerId}/{productId}")
	public ResponseEntity<?> deleteProductFromCart(@PathVariable int customerId,@PathVariable int productId){
		return service.deleteFromCart(customerId, productId);
	}
	@GetMapping("/wishlist/{customerId}/{productId}/{quantity}")
	public  ResponseEntity<?> addProductToWishList(@PathVariable int customerId,@PathVariable int productId,@PathVariable int quantity){
		return service.addProductToWishList(customerId, productId,quantity);
	}
}
