/**
 * 
 */
package com.myRetail.restapi.service;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.myRetail.restapi.domain.Product;

/**
 * @author Rohith Shabad
 * 
 * <p>See implementation {@link ProductNameRetrievalServiceImpl}</p>
 */
public interface ProductNameRetrievalService {
	
	public String retrieveProductNameFromInternalHost(Product product) throws JsonParseException, JsonMappingException, IOException;

}
