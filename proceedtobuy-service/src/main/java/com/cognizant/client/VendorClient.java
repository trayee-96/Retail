package com.cognizant.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.DTO.Vendor;

//@FeignClient(name="vendor",url="http://localhost:8080/vendors")
public interface VendorClient {
	@GetMapping("/getvendors/{productId}")
	public List<Vendor> getVendors(@PathVariable int productId);
}
