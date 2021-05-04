/**
 * 
 */
package com.myRetail.restapi.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Rohith Shabad
 *
 */
@ControllerAdvice
public class ExceptionHandlerUtil {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ExceptionResponse> productNotFound(ProductNotFoundException ex){
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setErrorCode(ex.getMessage());
		exceptionResponse.setErrorMessage("Product with product Id: "+ex.getProductId() + ", doesn't have a valid name");
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
		
	}
	

}
