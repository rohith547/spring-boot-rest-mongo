package com.myRetail.restapi.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Rohith Shabad
 * 
 * <p>Domain object to hold product related information.</p>
 */

@Document(collection = "products")
public class Product {
	
    @Id
    private String id;
    private String name;
    private ProductPrice current_price;

    public Product() {
    }

    public Product(String prodName, ProductPrice prodPrice) {
        this.name = prodName;
        this.current_price = prodPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String prodName) {
        this.name = prodName;
    }

	public ProductPrice getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(ProductPrice current_price) {
		this.current_price = current_price;
	}


}
