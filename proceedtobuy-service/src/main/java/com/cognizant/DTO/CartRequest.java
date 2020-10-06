package com.cognizant.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {
	private int customerId;
	private int productId;
	private int zipCode;
	private String expectedDeliveryDate;
//	public CartRequest(int customerId, int productId, int zipCode, String expectedDeliveryDate) throws ParseException {
//		super();
//		this.customerId = customerId;
//		this.productId = productId;
//		this.zipCode = zipCode;
//		this.expectedDeliveryDate = new SimpleDateFormat("dd/MM/yyyy").parse(expectedDeliveryDate);
//	}
	
}
