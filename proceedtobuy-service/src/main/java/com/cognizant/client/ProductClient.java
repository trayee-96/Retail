package com.cognizant.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.DTO.Product;

import feign.Headers;
@Headers("Content-Type: application/json")
@FeignClient(name="products",url="http://localhost:8081/api")
public interface ProductClient{
	@GetMapping("searchid/{productId}")
	public  Optional<Product> searchProductById(@PathVariable("productId") int productId);
}
