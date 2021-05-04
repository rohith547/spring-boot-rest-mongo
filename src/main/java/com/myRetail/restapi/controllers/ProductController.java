package com.myRetail.restapi.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.myRetail.restapi.domain.Product;
import com.myRetail.restapi.domain.ProductPrice;
import com.myRetail.restapi.repositories.ProductRepository;
import com.myRetail.restapi.service.ProductNameRetrievalService;

/**
 *
 * @author <b>Rohith Shabad</b>
 * <p> A spring controller class to expose rest api. </p>
 */
@RestController
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ProductNameRetrievalService productNameRetrievalService;
    
    @RequestMapping(method=RequestMethod.GET, value="/products/{id}")
    public Product getSingleProduct(@PathVariable String id) throws JsonParseException, JsonMappingException, IOException {
    	
        Product product = productRepository.findOne(id);
        if(product != null) {
        	product.setName(productNameRetrievalService.retrieveProductNameFromInternalHost(product));
        }
        
        return product;
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/products/{id}")
    public Product updateProductPrice(@PathVariable String id, @RequestBody ProductPrice productPrice) {
        Product product = productRepository.findOne(id);
       
        if(productPrice != null && product != null){
        	product.setCurrent_price(productPrice);
            productRepository.save(product);
        }
        
        return product;
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/products")
    public Iterable<Product> getAllProducts() {
    	
        return productRepository.findAll();
    } 
    
}