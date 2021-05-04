package com.myRetail.restapi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.myRetail.restapi.domain.Product;

/**
 *
 * @author Rohith Shabad
 * <p>A simple mongo db repository</p>
 */
public interface ProductRepository extends CrudRepository<Product, String> {
    Product findOne(String id);
}
