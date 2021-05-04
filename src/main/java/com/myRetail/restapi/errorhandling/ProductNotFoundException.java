/**
 * 
 */
package com.myRetail.restapi.errorhandling;

/**
 * @author Rohith Shabad
 *
 */
public class ProductNotFoundException extends RuntimeException {
	
	private String productId;
	
	public ProductNotFoundException(String productId, String message) {
		super(message);
		this.productId = productId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	

}
