/**
 * 
 */
package com.myRetail.restapi.controllers;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.myRetail.restapi.domain.Product;
import com.myRetail.restapi.domain.ProductPrice;
import com.myRetail.restapi.repositories.ProductRepository;
import com.myRetail.restapi.service.ProductNameRetrievalService;

/**
 * @author Rohith Shabad
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class)
public class ProductControllerMockTest {
	
	@Autowired private MockMvc mockMvc;

	@MockBean private ProductRepository productRepository;
	
	@MockBean private ProductNameRetrievalService productNameRetrievalService;

	private Product product = new Product();
	private RequestBuilder requestBuilder;
	private String expectedJson 	= "{\"id\":\"13860428\",\"name\":\"The Big Lebowski (Blu-ray)\",\"current_price\":{\"value\":13.49,\"currency_code\":\"USD\"}}";
	private String priceUpdatedJson = "{\"id\":\"13860428\",\"name\":null,\"current_price\":{\"value\":100,\"currency_code\":\"USD\"}}";
	
	private static final String EMPTY_STRING = "";

    
	@Before
	public void setUp() throws Exception{
		
		ProductPrice productPrice = new ProductPrice();
		productPrice.setCurrency_code("USD");
		productPrice.setValue(BigDecimal.valueOf(13.49));
		product.setCurrent_price(productPrice);
		product.setId("13860428");

	}
	
	@Test
	public void getSingleProductTest_when_product_returned_by_repository_isNull() throws Exception{
		
		Mockito.when(productRepository.findOne(Mockito.anyString())).thenReturn(null);
		Mockito.when(productNameRetrievalService.retrieveProductNameFromInternalHost(Mockito.any(Product.class))).thenReturn("The Big Lebowski (Blu-ray)");
		
		requestBuilder = MockMvcRequestBuilders.get("/products/13860428").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		assertEquals(EMPTY_STRING, result.getResponse().getContentAsString());
	}
	
	@Test
	public void getSingleProductTest_when_product_returned_by_repository_isNotNull() throws Exception{
		
		Mockito.when(productRepository.findOne(Mockito.anyString())).thenReturn(product);
		Mockito.when(productNameRetrievalService.retrieveProductNameFromInternalHost(Mockito.any(Product.class))).thenReturn("The Big Lebowski (Blu-ray)");
		
		requestBuilder = MockMvcRequestBuilders.get("/products/13860428").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		JSONAssert.assertEquals(expectedJson, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void updateProductPriceTest() throws Exception{
		
		Mockito.when(productRepository.findOne(Mockito.anyString())).thenReturn(product);
		Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(new Product());
		Mockito.when(productNameRetrievalService.retrieveProductNameFromInternalHost(Mockito.any(Product.class))).thenReturn("The Big Lebowski (Blu-ray)");
		
		requestBuilder = MockMvcRequestBuilders.put("/products/13860428").accept(MediaType.APPLICATION_JSON).content("{\"value\":100, \"currency_code\":\"USD\"}").contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		JSONAssert.assertEquals(priceUpdatedJson, result.getResponse()
				.getContentAsString(), false);
	}
	

}
