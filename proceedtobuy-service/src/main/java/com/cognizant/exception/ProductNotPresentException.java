package com.cognizant.exception;

public class ProductNotPresentException extends RuntimeException {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public ProductNotPresentException(String msg) {
	super(msg);
}
}
