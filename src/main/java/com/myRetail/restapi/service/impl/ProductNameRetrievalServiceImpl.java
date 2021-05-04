/**
 * 
 */
package com.myRetail.restapi.service.impl;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myRetail.restapi.domain.Product;
import com.myRetail.restapi.errorhandling.ProductNotFoundException;
import com.myRetail.restapi.service.ProductNameRetrievalService;
import com.myRetail.restapi.service.objects.ProductResponse;

/**
 * @author Rohith Shabad
 * <p>A helper class to call the internally hosted rest service to retrieve the name of the product.</p>
 *
 */
@Component
public class ProductNameRetrievalServiceImpl implements ProductNameRetrievalService {
	
private RestTemplate restTemplate = new RestTemplate();
	
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private static final Log LOGGER = LogFactory.getLog(ProductNameRetrievalService.class);
	
	private static final String API_URL = "https://redsky.target.com/v3/pdp/tcin/";
	private static final String PATH = "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics&key=candidate";
	
	/**
	 * Calls a internal rest service to get the product information which includes product name.
	 * @param product
	 * @return String
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public String retrieveProductNameFromInternalHost(Product product) throws JsonParseException, JsonMappingException, IOException {
		
		String jsonResponse = null;
		restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
		if(product == null || product.getId() == null) {
			return jsonResponse;
		}
		try {
			//rest service call
			jsonResponse = restTemplate.getForObject(API_URL + product.getId() + PATH, String.class);
		} catch(HttpClientErrorException ex) {
			LOGGER.error(ex);
			throw new ProductNotFoundException(product.getId(), "Call to internal service failed");
		}
		
		
		return retrieveProductNameFromJsonReponse(jsonResponse);
	}
	
	/**
	 * Unmarshall and retrieve the product name from json response using object mapper.
	 * @param jsonResponse
	 * @return String
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	protected String retrieveProductNameFromJsonReponse(String jsonResponse) throws JsonParseException, JsonMappingException, IOException {
		
		if(!StringUtils.isEmpty(jsonResponse) && objectMapper != null){
			
			ProductResponse productResponse = objectMapper.readValue(jsonResponse, ProductResponse.class);
			
			if(productResponse != null && productResponse.getProduct() != null && productResponse.getProduct().getItem() != null &&
					productResponse.getProduct().getItem().getProductDescription() != null) {
				return productResponse.getProduct().getItem().getProductDescription().getTitle();
			}
		}
		
		return jsonResponse;
		
	}

}
