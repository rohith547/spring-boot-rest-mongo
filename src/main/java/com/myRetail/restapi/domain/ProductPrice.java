/**
 * 
 */
package com.myRetail.restapi.domain;

import java.math.BigDecimal;

/**
 * @author Rohith Shabad
 * <p>Domain object to hold product pricing information. This class is referenced in {@link Product} domain object.</p>
 */
public class ProductPrice {
	
	private BigDecimal value;
	private String currency_code;
	
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public String getCurrency_code() {
		return currency_code;
	}
	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}
	

}
