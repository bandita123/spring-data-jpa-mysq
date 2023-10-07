package com.mkyong.rest;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(annotations=RestController.class)
@Order(1)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({Exception.class})
	public ResponseEntity<Response> exceptionhandler(Exception exception){
		Response response = new Response();
		response.setStatuscode("500");
		response.setStatusMsg(exception.getMessage());
		return new ResponseEntity(response,HttpStatus.OK);
		
	}
	
}
